package com.gustavogarcia.currencyconverter.models;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class CurrencyTranslation {
    private String baseCode;
    private String targetCode;
    private double amount;
    private double conversionResult;
    private LocalDateTime dateTime;
    ConnectionApi api;

    public CurrencyTranslation(String baseCode, String targetCode, double amount) throws IOException, InterruptedException {
        this.baseCode = baseCode;
        this.targetCode = targetCode;
        this.amount = amount;
        this.api = new ConnectionApi(this.baseCode, this.targetCode, this.amount);
        this.conversionResult = Double.parseDouble(api.sendTranslation());
        this.dateTime = LocalDateTime.now();
    }

    public double getConversionResult() {
        return conversionResult;
    }

    @Override
    public String toString() {
        return """ 
                %,.2f [%s] ----> %,.2f [%s] at: %s
                """.formatted(amount, baseCode, conversionResult, targetCode, dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.SHORT)));
    }
}
