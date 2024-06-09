package com.gustavogarcia.currencyconverter.models;

public enum Currency {
    MXN("Mexican Peso"), 
    USD("United States Dollar"),
    BRL("Brazilian Real"),
    EUR("Euro"),
    AUD("Australian Dollar"),
    CAD("Canadian Dollar"),
    CLP("Chilean Peso"),
    COP("Colombian Peso"),
    ARS("Argentine Peso"),
    JPY("Japanese Yen"),
    PHP("Philippine Peso");

    private final String currencyName;
    Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
