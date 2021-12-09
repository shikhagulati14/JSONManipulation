package org.fin.loans.utils;

import com.google.gson.reflect.TypeToken;
import org.fin.loans.exception.LoanAlertExceptions;
import org.fin.loans.exception.TickerException;
import org.fin.loans.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanAlertUtils {


    /**
     * @param marketDataFile
     * @return
     * @throws LoanAlertExceptions
     */
    public static List<Ticker> loadAndParseTickerData(String marketDataFile) throws LoanAlertExceptions {
        //read Ticker data json
        String JsonResponse = getJsonFromFile(marketDataFile);
        TypeToken<List<Ticker>> token = new TypeToken<List<Ticker>>(){};
        List<Ticker> tickerList = CommonUtils.getGsonObject().fromJson(JsonResponse, token.getType());
        return tickerList;
    }

    /**
     * @param loanDatafile
     * @return
     * @throws LoanAlertExceptions
     */
    public static List<Loan> loadAndParseLoanData(String loanDatafile) throws LoanAlertExceptions {

        //read loan data json
        String JsonResponse = getJsonFromFile(loanDatafile);
        TypeToken<List<Loan>> token = new TypeToken<List<Loan>>(){};
        List<Loan> loanList = CommonUtils.getGsonObject().fromJson(JsonResponse, token.getType());
        //System.out.println(CommonUtils.getGsonObject().toJson(loanList));
        return loanList;

    }

    /**This method is used to get the JSON Response from the given file location.
     * @param fileURL
     * @return String after getting the JSON response successfully, throws exception otherwise.
     */
    public static String getJsonFromFile(String fileURL) throws LoanAlertExceptions {

        String response = null;
        try {
            FileInputStream fin=new FileInputStream(fileURL);
            InputStream bin=new BufferedInputStream(fin);
            response = CommonUtils.convertStreamToString(bin);
        } catch (IOException e) {
            throw new LoanAlertExceptions(e);
        } catch (Exception e) {
            throw new LoanAlertExceptions(e);
        }
        return response;
    }


    /**
     * @param tickerList
     * @return
     */
    public static Map<String, Double> extractMapFromTicker(List<Ticker> tickerList) {
        Map<String,Double> tickerMap = new HashMap<>();
        for(Ticker ticker: tickerList){
            tickerMap.put(ticker.getIsin(), ticker.getPrice());
        }
        return tickerMap;
    }

    /**
     * @param loanList
     * @param tickerMap
     * @return
     */
    public static List<UnsecuredLoan> findUnsecuredLoans(List<Loan> loanList, Map<String, Double> tickerMap) {

        List<UnsecuredLoan> unsecuredLoans = new ArrayList<>();
        for(Loan loan: loanList){
            Double totalPortfolioValue = getTotalPortfolioValue(loan,tickerMap);
            if( totalPortfolioValue < loan.getAmount()){
                unsecuredLoans.add(new UnsecuredLoan(loan.getId(), loan.getCreditpolicy(), loan.getAmount(),totalPortfolioValue));
            }
        }
        return unsecuredLoans;
    }

    /**
     * @param loan
     * @param tickerMap
     * This method calculates the total portfolio value by using the map of <id,price> .
     * @return
     */
    private static Double getTotalPortfolioValue(Loan loan, Map<String, Double> tickerMap) {
        Double totalPortfolioValue=0d;
        for(Position position : loan.getPositions()){
            totalPortfolioValue = totalPortfolioValue + position.getQuantity()*tickerMap.get(position.getId());
        }
        return totalPortfolioValue;
    }

    /**
     * @param loanAlerts
     * @throws LoanAlertExceptions
     */
    public static void generateUnsecuredLoanAlertReport(List<UnsecuredLoan> loanAlerts) throws LoanAlertExceptions{
        String jsonResponse = CommonUtils.getGsonObject().toJson(loanAlerts);

        try {
            CommonUtils.writeJsonResponseToFile(jsonResponse, "unsecuredLoans.json");
        } catch (IOException e) {
            throw new LoanAlertExceptions(e);
        }
        //System.out.println("Unsecured Loans: \n\n " + jsonResponse);
        System.out.println(jsonResponse);
    }
}
