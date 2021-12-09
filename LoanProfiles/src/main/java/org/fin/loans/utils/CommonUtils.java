package org.fin.loans.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.fin.loans.exception.TickerException;

import java.io.*;

public class CommonUtils {
    private static final GsonBuilder builder;
    private static final Gson gson;

    static {
        builder = new GsonBuilder();
        gson = builder.serializeNulls().setPrettyPrinting().create();
    }

    /**This method is used to convert stream to string.
     * @param is InputStream.
     * @return String after converting stream to string successfully, exception otherwise.
     */
    public static String convertStreamToString(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
              throw e;
            }
        }
        return sb.toString();
    }

    /**
     * @return
     */
    public static Gson getGsonObject(){
        return gson;
    }

    public static void writeJsonResponseToFile(String jsonData, String fileName) throws IOException {
        //Write JSON file
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(jsonData);
            file.flush();
        } catch (IOException e) {
            throw e;
        }
    }

}
