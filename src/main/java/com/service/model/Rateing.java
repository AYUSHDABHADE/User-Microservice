package com.service.model;

public class Rateing {
	private int rateingId;
	private String userId;
	private String hotelId;
	private int rateing;
	private String feedBack;
	private Hotel hotel;
	

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public int getRateingId() {
		return rateingId;
	}

	public void setRateingId(int rateingId) {
		this.rateingId = rateingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRateing() {
		return rateing;
	}

	public void setRateing(int rateing) {
		this.rateing = rateing;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public Rateing(int rateingId, String userId, String hotelId, int rateing, String feedBack) {
		super();
		this.rateingId = rateingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rateing = rateing;
		this.feedBack = feedBack;
	}

	public Rateing() {
		super();
		// TODO Auto-generated constructor stub
	}

}
