package com.hpm.db;

public class AppInfo {

	private String rating, title, creator, appType, ID, packageName, version, creatorId;
	private int ratingsCount,versionCode;
	@Override
	public String toString() {
		return "AppInfo [rating=" + rating + ", title=" + title + ", creator="
				+ creator + ", appType=" + appType + ", ID=" + ID
				+ ", packageName=" + packageName + ", version=" + version
				+ ", creatorId=" + creatorId + ", ratingsCount=" + ratingsCount
				+ ", versionCode=" + versionCode + "]";
	}
	public AppInfo(String rating, String title, String creator, String appType,
			String iD, String packageName, String version, String creatorId,
			int ratingsCount, int versionCode) {
		super();
		this.rating = rating;
		this.title = title;
		this.creator = creator;
		this.appType = appType;
		ID = iD;
		this.packageName = packageName;
		this.version = version;
		this.creatorId = creatorId;
		this.ratingsCount = ratingsCount;
		this.versionCode = versionCode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreatorId() {
		return creatorId;
	}
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}
	public int getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	public int getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(int versionCode) {
		this.versionCode = versionCode;
	}

	
	
}
