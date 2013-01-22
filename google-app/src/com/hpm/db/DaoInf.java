package com.hpm.db;

import java.sql.SQLException;

public interface DaoInf {
	
	 public void fetchAppinfo(AppDetails appinfo_obj) throws SQLException, IllegalArgumentException;
	 public void insertComments(CommentDetails appinfo_obj) throws SQLException, IllegalArgumentException;
	public CommentDetails fetchComments(String authorname);
	public void updateComm(String updatecommnts);
	public void insertAppinfo(AppDetails appinfo) throws SQLException;
	public AppDetails fetchAppInfo(String iD);

}
