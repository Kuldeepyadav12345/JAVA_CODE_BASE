package com.stocksDemo.stocksDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

import com.stocksDemo.stocksDemo.route.fetchStockDataBankNifty;



@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.stocksDemo.stocksDemo.model"})  // scan JPA entities
public class StocksDemoApplication {

	public static void main(String[] args) {
		System.out.println("started");
		String bankNifty = "https://groww.in/v1/api/stocks_fo_data/v1/tr_live_prices/exchange/NSE/segment/FNO/BANKNIFTY2440347100CE/latest";
		String nifty50 = "https://groww.in/v1/api/stocks_fo_data/v1/tr_live_prices/exchange/NSE/segment/FNO/NIFTY2430722400CE/latest";
		SpringApplicationBuilder builder = new SpringApplicationBuilder(StocksDemoApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
		System.out.println("Hello");
		
		fetchStockDataBankNifty.fetchStockDataApi(args,bankNifty);
		System.out.println("ended");
	}

}
