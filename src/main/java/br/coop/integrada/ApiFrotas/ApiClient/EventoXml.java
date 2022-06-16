package br.coop.integrada.ApiFrotas.ApiClient;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EventoXml implements Serializable{
	
	private String captureTime;
	private String plateNumber;
	private String picName;
	private String country;
	private String laneNo;
	private String direction;
	private String matchingResult;
	
	public String getCaptureTime() {
		return captureTime;
	}
	public void setCaptureTime(String captureTime) {
		this.captureTime = captureTime;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLaneNo() {
		return laneNo;
	}
	public void setLaneNo(String laneNo) {
		this.laneNo = laneNo;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getMatchingResult() {
		return matchingResult;
	}
	public void setMatchingResult(String matchingResult) {
		this.matchingResult = matchingResult;
	}
	
	public EventoXml(String captureTime, String plateNumber, String picName, String country, String laneNo, String direction, String matchingResult) {
		super();
		this.captureTime = captureTime;
		this.plateNumber = plateNumber;
		this.picName = picName;
		this.country = country;
		this.laneNo = laneNo;
		this.direction = direction;
		this.matchingResult = matchingResult;
	}	

}
