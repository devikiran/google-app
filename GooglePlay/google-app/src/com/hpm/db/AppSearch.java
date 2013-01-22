package com.hpm.db;
import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.AppsRequest;
import com.gc.android.market.api.model.Market.AppsResponse;
import com.gc.android.market.api.model.Market.ResponseContext;

public class AppSearch {
	
	
	public static void main(String[] args) {

		final serviceInf servcInf=new serviceImp();
	MarketSession session = new MarketSession();
	String email="ravi.eng.it@gmail.com";
	String password="%sai123%";
	session.login(email,password);

	
	
	
	
	
	AppsRequest appsRequest = AppsRequest.newBuilder()
			.setQuery("Toshiba")
			
			.setStartIndex(0).setEntriesCount(10)
            .setWithExtendedInfo(false)
            
            .build();
	
	session.append(appsRequest, new Callback<AppsResponse>() {
         @Override
         public void onResult(ResponseContext context, AppsResponse response) {
        	System.out.println(response);
        	 System.out.println("App size  "+response.getAppList().size());
        	 for(int i=0;i<response.getAppList().size();i++)
        	 {
        	 String appRating=response.getApp(0).getRating();
        	 String appTitle=response.getApp(i).getTitle();
        	 String appCreator=response.getApp(i).getCreator();
        	 String appType=response.getApp(i).getAppType().toString();
        	 String appId=response.getApp(i).getId();
        	 String appPackageName=response.getApp(i).getPackageName();
        	 String appVersion=response.getApp(i).getVersion();
        	 String CreatorId=response.getApp(i).getCreatorId();
        	 int appRatingCount=response.getApp(i).getRatingsCount();
        	 int appVersionCode=response.getApp(i).getVersionCode();
        	 
        	 //servcInf.addAppInfo(new AppInfo(appRating, appTitle, appCreator, appType, appId, appPackageName, appVersion, CreatorId, appRatingCount, appVersionCode));
        	 
        	 }
        	 
         }
	});  session.flush();
}
}
