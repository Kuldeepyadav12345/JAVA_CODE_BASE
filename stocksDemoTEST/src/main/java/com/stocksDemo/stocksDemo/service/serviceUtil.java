package com.stocksDemo.stocksDemo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.stocksDemo.stocksDemo.constants.stockConstant;

public class serviceUtil {

	public static String extractStockCode() {
        String pattern = "/FNO/([^/]+)/latest";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(stockConstant.API_URL_BANKNIFTY);

        if (matcher.find() && !stockConstant.API_URL_BANKNIFTY.isEmpty()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
