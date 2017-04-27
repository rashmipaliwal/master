package com.gl.h2o.pojos;

import java.math.BigDecimal;
import java.util.ArrayList;

public class JsonPOJO {
	
	private ArrayList<BigDecimal> curSevenDayUsage;
	private ArrayList<BigDecimal> prevSevenDayUsage;
	private ArrayList<BigDecimal> monthlyData;
	private BigDecimal  last7Day;
	private BigDecimal  prev7Day;
	private BigDecimal  avg30Days;
	private BigDecimal  curConsumption;
	private BigDecimal  usgDelta;
	private BigDecimal  unbilledAmt;
	private BigDecimal  lastBill;
	private BigDecimal  predictedBill;
	private ArrayList<Alert> alerts;
	

	public ArrayList<BigDecimal> getCurSevenDayUsage() {
		return curSevenDayUsage;
	}
	public void setCurSevenDayUsage(ArrayList<BigDecimal> curSevenDayUsage) {
		this.curSevenDayUsage = curSevenDayUsage;
	}
	public ArrayList<BigDecimal> getPrevSevenDayUsage() {
		return prevSevenDayUsage;
	}
	public void setPrevSevenDayUsage(ArrayList<BigDecimal> prevSevenDayUsage) {
		this.prevSevenDayUsage = prevSevenDayUsage;
	}
	public ArrayList<BigDecimal> getMonthlyData() {
		return monthlyData;
	}
	public void setMonthlyData(ArrayList<BigDecimal> monthlyData) {
		this.monthlyData = monthlyData;
	}
	public BigDecimal getLast7Day() {
		return last7Day;
	}
	public void setLast7Day(BigDecimal last7Day) {
		this.last7Day = last7Day;
	}
	public BigDecimal getPrev7Day() {
		return prev7Day;
	}
	public void setPrev7Day(BigDecimal prev7Day) {
		this.prev7Day = prev7Day;
	}
	public BigDecimal getAvg30Days() {
		return avg30Days;
	}
	public void setAvg30Days(BigDecimal avg30Days) {
		this.avg30Days = avg30Days;
	}
	public BigDecimal getCurConsumption() {
		return curConsumption;
	}
	public void setCurConsumption(BigDecimal curConsumption) {
		this.curConsumption = curConsumption;
	}
	public BigDecimal getUsgDelta() {
		return usgDelta;
	}
	public void setUsgDelta(BigDecimal usgDelta) {
		this.usgDelta = usgDelta;
	}
	public BigDecimal getUnbilledAmt() {
		return unbilledAmt;
	}
	public void setUnbilledAmt(BigDecimal unbilledAmt) {
		this.unbilledAmt = unbilledAmt;
	}
	public BigDecimal getLastBill() {
		return lastBill;
	}
	public void setLastBill(BigDecimal lastBill) {
		this.lastBill = lastBill;
	}
	public BigDecimal getPredictedBill() {
		return predictedBill;
	}
	public void setPredictedBill(BigDecimal predictedBill) {
		this.predictedBill = predictedBill;
	}
	public ArrayList<Alert> getAlerts() {
		return alerts;
	}
	public void setAlerts(ArrayList<Alert> alerts) {
		this.alerts = alerts;
	}
	
	

	
	/*
	 * Sample json below
	 * 
	"curSevenDayUsage" : [1000,2067,2298,1020,3040,2000,1000],
	"prevSevenDayUsage" : [2000,1067,1298,3020,2040,1000,2000],
	"monthlyData" : [2000,1067,1298,3020,2040,1000,2000,3020,2040,1043],
	last7Day :  2345,
	prev7Day : 1735,
	avg30Days : 323,
	curConsumption : "1,250",
	usgDelta : "30",//in percentage
	unbilledAmt : 456,
	lastBill : 444,
	predictedBill : 657,
	"alerts" : [
	 	{"message" : "Overflow","detail" : "Bathroom : Running water detected from bathroom tap for last 40 min.Please check!!!<div style='padding-top:15px;'>Would you like to shut water supply</div>"},
		{"message" : "Broken Pipe","detail" : "Possible leak detected Your garden sprinkler is consuming 20 Liters per minute.More than usual!!!!<div style='padding-top:15px;'>Check for broken pipe in lawn irrigation system.</div>"}
		*/
}
