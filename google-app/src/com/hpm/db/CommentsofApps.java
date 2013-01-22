package com.hpm.db;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.CommentsRequest;
import com.gc.android.market.api.model.Market.CommentsResponse;
import com.gc.android.market.api.model.Market.ResponseContext;

public class CommentsofApps {

	
	public static void main(String[] args) {
		
		String applicationId="-3447168864682891906";
		getComments(applicationId);
		
	}
	public static void getComments(String appId)
	{
	
		final serviceInf servcInf=new serviceImp();
				
		MarketSession session = new MarketSession();
		String email="ravi.eng.it@gmail.com";
		String password="%sai123%";
		session.login(email,password);
	
	 
		CommentsRequest commentsRequest = CommentsRequest.newBuilder().setAppId(appId).build();

		session.append(commentsRequest, new Callback<CommentsResponse>() 
				{
		@Override
		public void onResult(ResponseContext context, CommentsResponse response)
		{System.out.println(response);
				for(int i=0;i<response.getCommentsList().size();i++)
				{
					int commentsRatings=response.getComments(i).getRating();
					String commentsAuthorName=response.getComments(i).getAuthorName();
					String commentsText=response.getComments(i).getText();
					long CreationTime=response.getComments(i).getCreationTime();
					int commentCreationTime=(int)CreationTime;
					String CommentsAUthorId=response.getComments(i).getAuthorId(); 
					
		 
					//servcInf.addComments(new Comments(commentsAuthorName,commentsText,CommentsAUthorId,commentsRatings,commentCreationTime));
				}
	 
		}
				} 			);
		
	 session.flush();



	}
}