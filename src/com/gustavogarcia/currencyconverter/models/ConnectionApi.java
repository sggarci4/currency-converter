package com.gustavogarcia.currencyconverter.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionApi {
    //        // Setting URL
//        String url_str = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD";
//
//// Making Request
//        URL url = new URL(url_str);
//        HttpURLConnection request = (HttpURLConnection) url.openConnection();
//        request.connect();
//
//// Convert to JSON
//        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//        JsonObject jsonobj = root.getAsJsonObject();
//
//// Accessing object
//        String req_result = jsonobj.get("conversionResult").getAsString();

    private String address;
    private String baseCode;
    private String targetCode;
    private double amountLocalCurrency;
    private String conversionResult;



    public ConnectionApi() throws IOException, InterruptedException {

    }

    public ConnectionApi(String baseCode, String targetCode, double amountLocalCurrency) throws IOException, InterruptedException {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amountLocalCurrency = amountLocalCurrency;
        this.address = "https://v6.exchangerate-api.com/v6/93de2c4a004ddfae8a9bb5ad/pair/" + this.baseCode +"/" + this.targetCode + "/" + this.amountLocalCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        JsonElement jsonElement = JsonParser.parseString(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        conversionResult = jsonObject.get("conversion_result").getAsString();
    }



    public String sendTranslation (){

        return conversionResult;
    }


//    public static void main(String[] args) throws IOException, InterruptedException {
//        ConnectionApi api = new ConnectionApi();
//        System.out.printf("""
//                Json:  %s
//                %n""", api.json);
//
//        System.out.println("Result of the JsonObject: " + api.conversionResult);
//    }
}
