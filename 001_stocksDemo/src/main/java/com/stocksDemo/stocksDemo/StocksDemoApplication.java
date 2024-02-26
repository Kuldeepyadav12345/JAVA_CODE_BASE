package com.stocksDemo.stocksDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.stocksDemo.stocksDemo.route.fetchStockData;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.stocksDemo.stocksDemo.model"})  // scan JPA entities
public class StocksDemoApplication {

	public static void main(String[] args) {
		System.out.println("started");
		SpringApplication.run(StocksDemoApplication.class, args);
		fetchStockData.fetchStockDataApi(args);
		System.out.println("ended");
	}

}
