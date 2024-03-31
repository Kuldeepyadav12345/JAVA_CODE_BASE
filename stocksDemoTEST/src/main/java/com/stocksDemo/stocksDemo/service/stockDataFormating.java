package com.stocksDemo.stocksDemo.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stocksDemo.stocksDemo.chart.RealtimeChart;
import com.stocksDemo.stocksDemo.chart.RealtimeChart_test2;
import com.stocksDemo.stocksDemo.chart.linearChart_1;
import com.stocksDemo.stocksDemo.model.bankNiftyTable;
import com.stocksDemo.stocksDemo.repository.stockDataRepository;

import javazoom.jl.decoder.JavaLayerException;



@Service
public class stockDataFormating {
	
	private static stockDataRepository sDR = null;
	private static final Logger LOGGER = Logger.getLogger( stockDataFormating.class.getName());
	private static final Logger logger = Logger.getLogger(stockDataFormating.class.getName());
	public static Double stopLossPrice=0.0;
	public static int countSellNotification=0;
	public static int testActialPrice=500;
	public static int testStopLoss=490;

	@Autowired
	public stockDataFormating(stockDataRepository stockDataRepository) {
		stockDataFormating.sDR = stockDataRepository;
	}
	

	public static void formatJsonData(String responseBody, linearChart_1 chart)throws JsonMappingException, JsonProcessingException, ParseException, JavaLayerException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(responseBody);
		logger.finest("formatJsonData" +jsonNode);
		
		bankNiftyTable data = new bankNiftyTable();
		data.setType(jsonNode.get("type").toString());
		data.setSymbol(jsonNode.get("symbol").toString());
		data.setTsInMillis(jsonNode.get("tsInMillis").toString());
		data.setOpen(jsonNode.get("open").toString());
		data.setHigh(jsonNode.get("high").toString());
		data.setLow(jsonNode.get("low").toString());
		data.setClose(jsonNode.get("close").toString());
		data.setLtp(jsonNode.get("ltp").toString());
		data.setDayChange(jsonNode.get("dayChange").toString());
		data.setDayChangePerc(jsonNode.get("dayChangePerc").toString());
		data.setLowPriceRange(jsonNode.get("lowPriceRange").toString());
		data.setHighPriceRange(jsonNode.get("highPriceRange").toString());
		data.setVolume(jsonNode.get("volume").toString());
		data.setLowTradeRange(jsonNode.get("lowTradeRange").toString());
		data.setHighTradeRange(jsonNode.get("highTradeRange").toString());
		data.setTotalBuyQty(jsonNode.get("totalBuyQty").toString());
		data.setTotalSellQty(jsonNode.get("totalSellQty").toString());
		data.setOpenInterest(jsonNode.get("openInterest").toString());
		data.setPrevOpenInterest(jsonNode.get("prevOpenInterest").toString());
		data.setOiDayChange(jsonNode.get("oiDayChange").toString());
		data.setOiDayChangePerc(jsonNode.get("oiDayChangePerc").toString());
		data.setLastTradeQty(jsonNode.get("lastTradeQty").toString());
		data.setLastTradeTime(jsonNode.get("lastTradeTime").toString());
		data.setTime(setDate(data));
		
		if(stopLossPrice<=1)
		{
			System.out.println("stopLossPrice <1");
			System.out.println("stopLossPrice <1");
			System.out.println("stopLossPrice <1");
			stopLossPrice=Double.parseDouble(data.getLtp())-10;
		}
		data.setOptionChainVal(serviceUtil.extractStockCode());	
		sendBuySignalToUser(data,chart);
		setNewStopLossPrice(data);
		sendSellSignal(data);
		
		                                                                                  

		chart.displayChart(chart);                                                             
		sDR.save(data);
	}

	private static void sendBuySignalToUser(bankNiftyTable data, linearChart_1 chart) {
		logger.finest("Started sendBuySignal method");
		Double actualPrice=Double.parseDouble(data.getLtp());
		chart.updateData(actualPrice);
		Double TOTAL_BUY_QTY = Double.parseDouble(data.getTotalBuyQty());
		Double TOTAL_SELL_QTY = Double.parseDouble(data.getTotalSellQty());
		Double buySellNumerator= TOTAL_BUY_QTY - TOTAL_SELL_QTY;
		Double buySellDenominator= (TOTAL_BUY_QTY + TOTAL_SELL_QTY)/2;
		Double buySellPercentage= (buySellNumerator/buySellDenominator)*100;	
		System.out.println("actualPrice = "+actualPrice +"  stopLossPrice = " + stopLossPrice +"  TOTAL_BUY_QTY = " +TOTAL_BUY_QTY 
				+"   TOTAL_SELL_QTY = " +TOTAL_SELL_QTY  +"       LAST_TRADE_QTY = " + Double.parseDouble(data.getLastTradeQty()));
		System.out.println("Buy Sell percentage =" +buySellPercentage +" "+"%" );
		if(buySellPercentage>1)
		{
			AudioNotification.playBuyAudio();
		}
		data.setBuySellPercentage(buySellPercentage.toString());
		
	}

	public static String setDate(bankNiftyTable data) throws ParseException {

		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		String strDate = sdf.format(cal.getTime());
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		sdf1.applyPattern("dd/MM/yyyy HH:mm:ss.SS");
		Date date = sdf1.parse(strDate);
		String string = sdf1.format(date);
		logger.finest("Current date in String Format: " + strDate);
		return string;

	}
	
	public static void sendSellSignal(bankNiftyTable data)  {
	
		Double actualPrice=Double.parseDouble(data.getLtp());
		if(actualPrice<stopLossPrice)
		{
			System.out.println("Sell");
			System.out.println("Sell");
			System.out.println("Sell");
			System.out.println("countSellNotification " +countSellNotification);
			AudioNotification.playSellAudio();
			countSellNotification++;
			
		}
		logger.finest("Ends sendBuySignal method");
	}
	
	public static void setNewStopLossPrice(bankNiftyTable data)  {
		//Send notification to sell the stock repeatedly and after that set new stopLossPrice
		if(countSellNotification>50)
		{
			stopLossPrice=Double.parseDouble(data.getLtp())-10;
			System.out.println("New stopLossPrice" +stopLossPrice);
			System.out.println("New stopLossPrice" +stopLossPrice);
			System.out.println("New stopLossPrice" +stopLossPrice);
			System.out.println("New stopLossPrice" +stopLossPrice);
			countSellNotification=0;
		}
	}
	
	public static void testPriceData()  {
		testActialPrice++;
	}
	
	
	
	
}
