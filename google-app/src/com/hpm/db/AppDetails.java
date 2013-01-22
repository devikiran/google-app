package com.hpm.db;

import java.sql.Date;

public class AppDetails {
private String Name,Version,Size,Downloads,ReviewCount,Category,ContentRating,Price;
private Double Rating;
private 	java.sql.Date UpdatedDate = null;
private int AppID;



public AppDetails(int AppID,String Name,Date UpdatedDate,String Version,String Size,String Downloads,String ReviewCount,String Category,String ContentRating,String Price,Double Rating)
{
	this.AppID=AppID;
	this.Category=Category;
	this.ContentRating=ContentRating;
	this.Downloads=Downloads;
	this.Name=Name;
	this.Price=Price;
	this.Rating=Rating;
	this.ReviewCount=ReviewCount;
	this.Size=Size;
	this.UpdatedDate=UpdatedDate;
	this.Version=Version;
}
public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public Double getRating() {
	return Rating;
}

public void setRating(Double rating) {
	Rating = rating;
}

public Date getUpdatedDate() {
	return UpdatedDate;
}

public void setUpdatedDate(Date updatedDate) {
	UpdatedDate = updatedDate;
}

public String getVersion() {
	return Version;
}

public void setVersion(String version) {
	Version = version;
}

public String getSize() {
	return Size;
}

public void setSize(String size) {
	Size = size;
}

public String getDownloads() {
	return Downloads;
}

public void setDownloads(String downloads) {
	Downloads = downloads;
}

public String getReviewCount() {
	return ReviewCount;
}

public void setReviewCount(String reviewCount) {
	ReviewCount = reviewCount;
}

public String getCategory() {
	return Category;
}

public void setCategory(String category) {
	Category = category;
}

public String getContentRating() {
	return ContentRating;
}

public void setContentRating(String contentRating) {
	ContentRating = contentRating;
}

public String getPrice() {
	return Price;
}

public void setPrice(String price) {
	Price = price;
}

public int getAppID() {
	return AppID;
}

public void setAppID(int appID) {
	AppID = appID;
}
}
