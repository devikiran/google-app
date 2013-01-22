package com.hpm.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoImp implements DaoInf{

	@Override
	public void fetchAppinfo(AppDetails appinfo_obj) throws SQLException,
			IllegalArgumentException {
		
	
	}
	

	@Override
	public void insertComments(CommentDetails commnts_obj) throws SQLException,
			IllegalArgumentException {
		
		Connection con=null;
		ResultSet rs=null;
		//SELECT postedDate FROM `commentdetails` WHERE postedDate> '2013-01-17';
		
		
		try {
			 con = ConnectionGetter.get();
			
			String select="SELECT postedDate FROM `commentdetails` WHERE postedDate> '2013-01-17";
			System.out.println(select+ " select query");
			PreparedStatement validCheck=con.prepareStatement(select);
			
			
			//rs=validCheck.executeQuery();
			
			//if(rs.next())
			//{
			 
			 String commnts ="insert into commentdetails(Username,commentTitle, device ,Comment ,AppId,postedDate,Rating) values (?,?,?,?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(commnts);
			 
			 stmt.setString(1, commnts_obj.getUsername());
			 stmt.setString(2, commnts_obj.getTitle());
			 stmt.setString(3, commnts_obj.getDevice());
			 stmt.setString(4, commnts_obj.getComment());
			 stmt.setInt(5, commnts_obj.getAppId());
			 stmt.setDate(6, commnts_obj.getDate());
			 stmt.setDouble(7, commnts_obj.getRating());
			
			 stmt.executeUpdate();
			 stmt.close();
		//	}
			
		} catch (IllegalArgumentException e) {
			
			throw e;
			
		} catch (SQLException e) {
			throw e;
		} finally
		{
			
			try {
				if( con != null)
						con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public CommentDetails fetchComments(String authorname) {

		Connection con=null;
		ResultSet rs=null;
		int rating,creationTime;
		String authorName,authorId,text;
		CommentDetails commObj=null;
		
		try
		{
		con=ConnectionGetter.get();
				
		String select="select * from comments where authorName=?";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,authorname);
		
		rs=stmt.executeQuery();
		
		while( rs.next())
		{
			
		    rating=rs.getInt(1);
			creationTime=rs.getInt(2);
			authorname=rs.getString(3);
			text=rs.getString(4);
			authorId=rs.getString(5);
			//commObj=new Comments(authorname, text, authorId, rating, creationTime);
		}
		
		rs.close();
		stmt.close();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return commObj;
	}

	@Override
	public void updateComm(String updatecommnts) {
		
		Connection con=null;
		ResultSet rs=null;
		String comm=null;
		try
		{
		con=ConnectionGetter.get();
				
		String str ="update comments set text= ?";
		 PreparedStatement stmt = con.prepareStatement(str);
		 stmt.setString(1,updatecommnts);
		 int ra = stmt.executeUpdate();
		 stmt.close();
		 
		 if( ra > 0 )
			 System.out.println("updated successfully");
		 else
			 throw new IllegalArgumentException("find it out");
		 
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void insertAppinfo(AppDetails appinfo) throws SQLException {
		
		Connection con=null;
		ResultSet rs=null;
		try {
			
			 con = ConnectionGetter.get();
			 
			
				
				String select="select * from appdetails where Name='"+appinfo.getName()+"'";
				System.out.println(select+ " select query");
				PreparedStatement validCheck=con.prepareStatement(select);
				
				
				rs=validCheck.executeQuery();
				
				if( rs.next())
				{
					System.out.println("in the ");
					Statement stmt = con.createStatement();
					
					 String appUpdate ="update appdetails set Rating='"+appinfo.getRating()+"',"
							 								+"Name='"+appinfo.getName()+"',"
							 								+"Version='"+appinfo.getVersion()+"',"
							 								+ "Size='"+appinfo.getSize()+"',"
							 								+"Downloads='"+appinfo.getDownloads()+"',"
							 								+"ReviewCount='"+appinfo.getReviewCount()+"',"
							 								+"Category='"+appinfo.getCategory()+"'," 
							 								+"ContentRating='"+appinfo.getContentRating()+"',"
							 								+"UpdatedDate='"+appinfo.getUpdatedDate()+"',"
							 								+"Price='"+appinfo.getPrice()+"'"+"where AppID='"+appinfo.getAppID()+"'";
					 
					 
					 
					 System.out.println(appUpdate);
					
					 stmt.executeUpdate(appUpdate);
					 
					 /*stmt.setString(1, appinfo.getRating());
					 stmt.setString(2, appinfo.getTitle());
					 stmt.setInt(3,appinfo.getRatingsCount());
					 stmt.setString(4, appinfo.getCreator());
					 stmt.setString(5, appinfo.getAppType());
					// stmt.setString(6, appinfo.getID());
					 stmt.setString(6, appinfo.getPackageName());
					 stmt.setString(7, appinfo.getVersion());
					 stmt.setInt(8, appinfo.getVersionCode());
					 stmt.setString(9, appinfo.getCreatorId());*/
					
					 
					 stmt.close();
				}
				else
				{
					System.out.println();
			 String commnts ="insert into appdetails(Name,Size,Downloads,ReviewCount,Category,ContentRating,Price,AppID,Rating,Version,UpdatedDate) values (?,?,?,?,?,?,?,?,?,?,?)";
			 PreparedStatement stmt = con.prepareStatement(commnts);
			 
			 stmt.setString(1, appinfo.getName());
			 stmt.setString(2, appinfo.getSize());
			 stmt.setString(3,appinfo.getDownloads());
			 stmt.setString(4, appinfo.getReviewCount());
			 stmt.setString(5, appinfo.getCategory());
			 stmt.setString(6, appinfo.getContentRating());
			 stmt.setString(7, appinfo.getPrice());
			 stmt.setInt(8, appinfo.getAppID());
			 stmt.setDouble(9, appinfo.getRating());
			 stmt.setString(10, appinfo.getVersion());
			 stmt.setDate(11, appinfo.getUpdatedDate());
			 
				
			 stmt.executeUpdate();
			 stmt.close();
				}
			
		} catch (IllegalArgumentException e) {
			
			throw e;
			
		} catch (SQLException e) {
			throw e;
		} finally
		{
			
			try {
				if( con != null)
						con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public AppDetails fetchAppInfo(String iD) {
		
		Connection con=null;
		ResultSet rs=null;
		 String Name,Version,Size,Downloads,ReviewCount,Category,ContentRating,Price;
		 Double Rating;
		 	java.sql.Date UpdatedDate;
		  int AppID;
		AppDetails appinfoObj=null;
		
		try
		{
		con=ConnectionGetter.get();
				
		String select="select * from appinfo where ID=?";
		PreparedStatement stmt=con.prepareStatement(select);
		stmt.setString(1,iD);
		
		rs=stmt.executeQuery();
		
		/*while( rs.next())
		{
			
			rating=rs.getString(1);
			title=rs.getString(2);
			ratingsCount=rs.getInt(3);
			creator=rs.getString(4);
			appType=rs.getString(5);
			ID=rs.getString(6);
			packageName=rs.getString(7);
			version=rs.getString(8);
			versionCode=rs.getInt(9);
			creatorId=rs.getString(10);
			
			appinfoObj=new AppInfo(rating, title, creator, appType, ID, packageName, version, creatorId, ratingsCount, versionCode);
		}*/
		
		rs.close();
		stmt.close();
		}
		catch(IllegalArgumentException e)
		{
			e.printStackTrace();
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return appinfoObj;
		
	}

}
