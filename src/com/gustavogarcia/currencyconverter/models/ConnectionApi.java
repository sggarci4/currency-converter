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
    private String address;
    private String baseCode;
    private String targetCode;
    private double amountLocalCurrency;
    private String conversionResult;
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

}
