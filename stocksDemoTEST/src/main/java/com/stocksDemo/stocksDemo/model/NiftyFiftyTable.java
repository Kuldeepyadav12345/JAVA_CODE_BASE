package com.stocksDemo.stocksDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="NIFTYFIFTY")
@Data
@NoArgsConstructor
public class NiftyFiftyTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;		
	private String symbol;		
	private String tsInMillis;	
	private String open;		
	private String high;		
	private String low;			
	private String close;			
	private String ltp;			
	private String dayChange;	
	private String dayChangePerc;	
	private String lowPriceRange;	
	private String highPriceRange;
	private String volume;		
	private String lowTradeRange;
	private String highTradeRange;	
	private String totalBuyQty;	
	private String totalSellQty;
	private String openInterest;
	private String prevOpenInterest;
	private String oiDayChange;
	private String oiDayChangePerc;
	private String lastTradeQty;
	private String lastTradeTime;
	private String time;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getTsInMillis() {
		return tsInMillis;
	}
	public void setTsInMillis(String tsInMillis) {
		this.tsInMillis = tsInMillis;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getClose() {
		return close;
	}
	public void setClose(String close) {
		this.close = close;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getDayChange() {
		return dayChange;
	}
	public void setDayChange(String dayChange) {
		this.dayChange = dayChange;
	}
	public String getDayChangePerc() {
		return dayChangePerc;
	}
	public void setDayChangePerc(String dayChangePerc) {
		this.dayChangePerc = dayChangePerc;
	}
	public String getLowPriceRange() {
		return lowPriceRange;
	}
	public void setLowPriceRange(String lowPriceRange) {
		this.lowPriceRange = lowPriceRange;
	}
	public String getHighPriceRange() {
		return highPriceRange;
	}
	public void setHighPriceRange(String highPriceRange) {
		this.highPriceRange = highPriceRange;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getLowTradeRange() {
		return lowTradeRange;
	}
	public void setLowTradeRange(String lowTradeRange) {
		this.lowTradeRange = lowTradeRange;
	}
	public String getHighTradeRange() {
		return highTradeRange;
	}
	public void setHighTradeRange(String highTradeRange) {
		this.highTradeRange = highTradeRange;
	}
	public String getTotalBuyQty() {
		return totalBuyQty;
	}
	public void setTotalBuyQty(String totalBuyQty) {
		this.totalBuyQty = totalBuyQty;
	}
	public String getTotalSellQty() {
		return totalSellQty;
	}
	public void setTotalSellQty(String totalSellQty) {
		this.totalSellQty = totalSellQty;
	}
	public String getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(String openInterest) {
		this.openInterest = openInterest;
	}
	public String getPrevOpenInterest() {
		return prevOpenInterest;
	}
	public void setPrevOpenInterest(String prevOpenInterest) {
		this.prevOpenInterest = prevOpenInterest;
	}
	public String getOiDayChange() {
		return oiDayChange;
	}
	public void setOiDayChange(String oiDayChange) {
		this.oiDayChange = oiDayChange;
	}
	public String getOiDayChangePerc() {
		return oiDayChangePerc;
	}
	public void setOiDayChangePerc(String oiDayChangePerc) {
		this.oiDayChangePerc = oiDayChangePerc;
	}
	public String getLastTradeQty() {
		return lastTradeQty;
	}
	public void setLastTradeQty(String lastTradeQty) {
		this.lastTradeQty = lastTradeQty;
	}
	public String getLastTradeTime() {
		return lastTradeTime;
	}
	public void setLastTradeTime(String lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "bankNiftyTable [id=" + id + ", type=" + type + ", symbol=" + symbol + ", tsInMillis=" + tsInMillis
				+ ", open=" + open + ", high=" + high + ", low=" + low + ", close=" + close + ", ltp=" + ltp
				+ ", dayChange=" + dayChange + ", dayChangePerc=" + dayChangePerc + ", lowPriceRange=" + lowPriceRange
				+ ", highPriceRange=" + highPriceRange + ", volume=" + volume + ", lowTradeRange=" + lowTradeRange
				+ ", highTradeRange=" + highTradeRange + ", totalBuyQty=" + totalBuyQty + ", totalSellQty="
				+ totalSellQty + ", openInterest=" + openInterest + ", prevOpenInterest=" + prevOpenInterest
				+ ", oiDayChange=" + oiDayChange + ", oiDayChangePerc=" + oiDayChangePerc + ", lastTradeQty="
				+ lastTradeQty + ", lastTradeTime=" + lastTradeTime + ", time=" + time + "]";
	}

	
	
	
	
}
