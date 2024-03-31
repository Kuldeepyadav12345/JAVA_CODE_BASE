
package com.stocksDemo.stocksDemo.route;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.stocksDemo.stocksDemo.chart.RealtimeChart;
import com.stocksDemo.stocksDemo.chart.RealtimeChart_test2;
import com.stocksDemo.stocksDemo.chart.linearChart_1;
import com.stocksDemo.stocksDemo.constants.stockConstant;
import com.stocksDemo.stocksDemo.service.stockDataFormating;
import com.stocksDemo.stocksDemo.service.stockDataFormatingNifty;

import ch.qos.logback.classic.Level;

public class fetchStockDataBankNifty {
	private static final Logger LOGGER = Logger.getLogger(fetchStockDataBankNifty.class.getName());

	public static void fetchStockDataApi(String[] args, String bankNifty) {
		System.out.println("asdasdasdasd");
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		linearChart_1 chart = new linearChart_1();
		scheduler.scheduleAtFixedRate(() -> callApi(bankNifty,chart), 0, 1, TimeUnit.SECONDS);
		
	}

	private static void callApi(String apiUrl, linearChart_1 chart) {
		try {
			HttpClient httpClient = HttpClient.newHttpClient();
			HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
			HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

			// Process the API response (you may want to do something with the response)
			String responseBody = response.body();
			stockConstant.API_URL_BANKNIFTY=apiUrl;
            System.out.println("API Response: " + responseBody);
			stockDataFormating.formatJsonData(responseBody,chart);

		} catch (Exception e) {
			// e.printStackTrace();
			LOGGER.log(java.util.logging.Level.INFO, e.toString());
			LOGGER.log(java.util.logging.Level.INFO, apiUrl);

		}
	}
}
