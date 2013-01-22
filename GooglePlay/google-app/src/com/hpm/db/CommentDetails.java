package com.hpm.db;

import java.sql.Date;

public class CommentDetails {
	private String Username,Title, Device ,Comment;
	private Date date;
	private Double Rating;
	private int appId;

public CommentDetails(String Username,String Title,String  Device ,Double Rating , String Comment,Date date,int appId)

{
	this.Comment=Comment;
	this.Username=Username;
	this.Device=Device;
	this.Rating=Rating;
	this.Title=Title;
	this.appId=appId;
	this.date=date;
}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}


	public String getDevice() {
		return Device;
	}

	public void setDevice(String device) {
		Device = device;
	}

	public Double getRating() {
		return Rating;
	}

	public void setRating(Double rating) {
		Rating = rating;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
}
