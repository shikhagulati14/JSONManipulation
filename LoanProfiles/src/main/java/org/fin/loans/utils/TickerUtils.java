package org.fin.loans.utils;

import com.google.gson.reflect.TypeToken;
import org.fin.loans.exception.TickerException;
import org.fin.loans.model.MarketData;
import org.fin.loans.model.Ticker;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TickerUtils {


    /**
     * @param url
     * @return
     * @throws TickerException
     */
    public static String downloadPayload(URL url) throws TickerException {

        String jsonResponse = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            // Read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            jsonResponse = CommonUtils.convertStreamToString(in);
        } catch (MalformedURLException | ProtocolException e) {
            throw new TickerException(e);
        } catch (IOException e) {
            throw new TickerException(e);
        }
        return jsonResponse;
    }



    /**
     * This method is used to parse the response.
     * @param json
     * @throws TickerException
     */
    public static List<MarketData> parseResponse(String json) throws TickerException {

        if (json != null) {
            TypeToken<List<MarketData>> token = new TypeToken<List<MarketData>>(){};
            List<MarketData> marketDataList = CommonUtils.getGsonObject().fromJson(json, token.getType());
            return marketDataList;
        }else {
            throw new TickerException("Invalid/Null Json for parsing.");
        }

    }

    /**
     * @param marketDataList
     * @return
     */
    public static String generateTickerData(List<MarketData> marketDataList) {
        List<Ticker> tickerList = new ArrayList<>();
        for(MarketData markerData : marketDataList){
            Ticker ticker = new Ticker(markerData.ticker==null?null:markerData.ticker, markerData.price, markerData.id);
            tickerList.add(ticker);
        }
        return CommonUtils.getGsonObject().toJson(tickerList);
    }

    /**
     * This method is used to store the output json file in current directory with name marketdata.json
     * @param tickerData
     * @throws TickerException
     */
    public static void generateTickerResponse(String tickerData) throws TickerException {
        try {
            CommonUtils.writeJsonResponseToFile(tickerData, "marketdata.json");
        } catch (IOException e) {
            throw new TickerException(e);
        }
    }
}
