package com.hpm.db;

public interface serviceInf {
	
	public void getAppinfo(AppDetails appinfo_obj);
	//public void insertAppinfo(AppInfo appinfo_obj);
	public void addComments(CommentDetails appinfo_obj);
	public CommentDetails getComments(String string);
	public void updateComments(String string);
	public void addAppInfo(AppDetails appinfo);
	public AppDetails getAppInfo(String ID);
	


}
