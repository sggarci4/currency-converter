package com.gustavogarcia.currencyconverter.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class History {
    private List<CurrencyTranslation> transaction = new ArrayList<>();
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .create();

    public void savetransactions(CurrencyTranslation currencyTranslation) {
        transaction.add(currencyTranslation);

    }

    public void printHistory() {
        System.out.println("**************************** Transactions ****************************\n");
        for (CurrencyTranslation currencyTranslation : transaction) {
            System.out.println(currencyTranslation);
        }
        System.out.println("**********************************************************************");
    }

    public void saveAFile() {
        try {
            FileWriter file = new FileWriter("history.json");
            file.write(gson.toJson(transaction));
            file.close();

        } catch (IOException e) {
            System.out.println("It happened just an error with: ");
            System.out.println(e.getMessage());
        }

    }
}
