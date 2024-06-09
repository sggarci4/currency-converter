package com.gustavogarcia.currencyconverter.models;

import java.io.IOException;
import java.util.*;

public class OptionsMenu {
    private int i = 0;
//        for (Currency currency : Currency.values()) {
//            currencies.add(currency);
//        }
//        Others way to do this process
//        currencies.addAll(Arrays.asList(Currency.values()));
//        This block code does the same
    private final List<Currency> currencies = new ArrayList<>(Arrays.asList(Currency.values()));
    private StringBuilder sb = new StringBuilder();
    private String optionsMenu;
    private Scanner scanner = new Scanner(System.in);
    private int inputClient;
    private double amount;
    private String result;
    CurrencyTranslation currencyTranslation;
    History history = new History();
    public String getOptionsMenu() {

        return optionsMenu;
    }

    public void showOptionsMenu() {

        sb.append("Welcome to Currency Converter!\n");
        sb.append("*******************************************\n");
        sb.append("\n");
        for (int j = 1; j < 11; j++) {
            i++;
            sb.append(i).append(") ");
            sb.append(currencies.get(0).getCurrencyName());
            sb.append(" ----> ");
            sb.append(currencies.get(j).getCurrencyName()).append("\n");
            i++;
            sb.append(i).append(") ");
            sb.append(currencies.get(j).getCurrencyName());
            sb.append(" ----> ");
            sb.append(currencies.get(0).getCurrencyName()).append("\n");
        }
        sb.append(i + 1).append(") Exit");
        this.optionsMenu = sb.toString();
    }
    

    public void runApp() throws IOException, InterruptedException {
        //try {
            showOptionsMenu();
            while (true) {
                try {
                    System.out.println(optionsMenu);
                    inputClient = scanner.nextInt();
                    if (inputClient <= 20 && inputClient != 0) {
                        System.out.println("Enter the amount: ");
                        amount = scanner.nextDouble();
                        if (inputClient % 2 != 0) {
                            inputClient = (inputClient + 1) / 2;
                            currencyTranslation = new CurrencyTranslation(currencies.get(0).toString(),currencies.get(inputClient).toString(), amount);
                            result = "%,.2f [%s] ----> %,.2f [%s]"
                                    .formatted(amount, currencies.get(0).toString(), currencyTranslation.getConversionResult(), currencies.get(inputClient).toString());

                        } else {
                            inputClient /= 2;
                            currencyTranslation = new CurrencyTranslation(currencies.get(inputClient).toString(),currencies.get(0).toString(), amount);
                            result = "%,.2f [%s] ----> %,.2f [%s]".formatted(amount, currencies.get(inputClient).toString(), currencyTranslation.getConversionResult(), currencies.get(0).toString());
                        }
                        System.out.println("Result: " + result);
                        history.savetransactions(currencyTranslation);
                        pause(scanner);
                    } else if (inputClient == 21) {
                        System.out.println("Thanks for used this app.\n");
                        history.printHistory();
                        history.saveAFile();
                        break;
                    }else {
                        System.out.println("Option not validate, try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input, Please enter a number");
                    scanner.next();
                    pause(scanner);
                }

            }



        //} catch (InputMismatchException e) {
          //  System.out.println(e.getMessage());
        //}


    }
    public void pause(Scanner scanner) {
        System.out.println("Presione Enter para continuar...");
        try {
            System.in.read();
            scanner.nextLine(); // Consumir el Enter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

