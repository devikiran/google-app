package com.hpm.db;

import java.sql.SQLException;

public class serviceImp implements serviceInf {

	DaoInf daoinf=new DaoImp();
	@Override
	public void getAppinfo(AppDetails appinfo_obj) {
		
		
	}

	public void addComments(CommentDetails comments_obj) {
			
			try {
				
				daoinf.insertComments(comments_obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		
	}

	@Override
	public CommentDetails getComments(String authorname) {
		
		CommentDetails commnts=daoinf.fetchComments(authorname);
		return commnts;
	}

	@Override
	public void updateComments(String updatecommnts) {
		
		daoinf.updateComm(updatecommnts);
		
	}

	@Override
	public void addAppInfo(AppDetails appinfo) {
		
		try {
			daoinf.insertAppinfo(appinfo);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public AppDetails getAppInfo(String ID) {
		
		AppDetails appinfo=daoinf.fetchAppInfo(ID);
		return appinfo;
	}

	

}
