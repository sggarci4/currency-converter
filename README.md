
# Conversor de monedas

![Badge FINISHED](https://img.shields.io/badge/STATUS-FINISHED-green)
![Badge Language](https://img.shields.io/badge/Language-JAVA-yellow)
[![Badge API](https://img.shields.io/badge/API-Exchange_Rate_API-blue.svg)](https://www.exchangerate-api.com)

This project is a currency conversion application that uses the [Exchange Rate API](https://www.exchangerate-api.com/). The application allows users to convert various currencies, keeps a record of all transactions performed, and displays a summary at the end of the session.

## Features

- **Currency Conversion**: Converts between a wide range of foreign currencies using real-time data provided by the Exchange Rate API.

![App Screenshot](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/currencies.png?raw=true)
![App Screenshot](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/currency-translation.png?raw=true)

![App Screenshot](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/conversions.png?raw=true)

- **Transaction Logging**: Maintains a detailed record of each conversion, including the source and target currencies, the converted amount, and the date and time of the transaction.
- **Transaction Summary**: Displays a summary of all conversions performed during the session upon completion.

![App Screenshot](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/history.png?raw=true)

![App Screenshot](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/transactions.png?raw=true)



## API Reference
![Logo](https://github.com/sggarci4/currency-converter/blob/main/src/com/gustavogarcia/currencyconverter/assets/logo.png?raw=true)


#### Standard Requests

```http
GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD
```
| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `YOUR-API-KEY` | `string` | **Required**. Your API key. |
| `USD` | `string` | **Required**. The code you want to use as a base currency. |

This will return the exchange rates from your base code to all the other currencies.

#### Pair Conversion Requests

```http
GET https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/EUR/GBP/AMOUNT
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `YOUR-API-KEY` | `string` | **Required**. Your API key. |
| `EUR` | `string` | **Required**. The code you want to use as a base currency. | 
| `GBP` | `string` | **Required**. the code you want to use as a target currency.| 
| `AMOUNT`      | `double` | **Optional**. The quantity to be converted.|

Without `AMOUNT`:
This will return the exchange rate from your base code to the other currency you supplied.

With `AMOUNT`:
This will return the exchange rate from your base code to the target currency you supplied, as well as a conversion of the amount you supplied.



## Run Locally

Clone the project

```bash
  git clone https://github.com/sggarci4/currency-converter.git
```

Go to the project directory

```bash
  cd currency-converter
```

Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm run start
```


## Feedback

If you have any feedback, please reach out to me at gustavogarciamaqueda@gmail.com

