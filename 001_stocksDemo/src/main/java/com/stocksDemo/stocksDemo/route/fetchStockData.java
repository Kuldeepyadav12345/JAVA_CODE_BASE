
package com.stocksDemo.stocksDemo.route;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.stocksDemo.stocksDemo.service.stockDataFormating;

import ch.qos.logback.classic.Level;



public class fetchStockData {
	private static final Logger LOGGER = Logger.getLogger( fetchStockData.class.getName() );

    public static void fetchStockDataApi(String[] args) {
    	System.out.println("asdasdasdasd");
        // Create a scheduled executor service
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Replace "https://api.example.com/your-endpoint" with the actual REST API endpoint
        String apiUrl = "https://groww.in/v1/api/stocks_fo_data/v1/tr_live_prices/exchange/NSE/segment/FNO/BANKNIFTY24FEB48200CE/latest";

        // Schedule the task to run every second
        scheduler.scheduleAtFixedRate(() -> callApi(apiUrl), 0, 1, TimeUnit.SECONDS);
    }

    private static void callApi(String apiUrl) {
        try {
            // Create an HttpClient
            HttpClient httpClient = HttpClient.newHttpClient();

            // Create an HTTP request
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            // Send the HTTP request and retrieve the response
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Process the API response (you may want to do something with the response)
            String responseBody = response.body();
//            System.out.println("API Response: " + responseBody);
            stockDataFormating.formatJsonData(responseBody);

        } catch (Exception e) {
           // e.printStackTrace();
        	LOGGER.log(java.util.logging.Level.INFO, apiUrl);
        }
    }
}
