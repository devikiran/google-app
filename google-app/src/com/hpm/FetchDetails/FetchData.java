package com.hpm.FetchDetails;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.hpm.db.AppDetails;
import com.hpm.db.CommentDetails;
import com.hpm.db.serviceImp;
import com.hpm.db.serviceInf;

public class FetchData {

	Helper helper = new Helper();
	AppDetails appDetails;
	CommentDetails commentDetails;;
	static String appName;
	serviceInf servcInf = new serviceImp();
	static FetchData fetchData = new FetchData();
	int AppID;
	

	public static void main(String[] args) throws InterruptedException {

		try {
			 WebElement beforEle;
			 WebElement after;
			WebDriver driver = new FirefoxDriver();
			// appName="com.july.cricinfo";
			// appName="com.trimble.allsportle";
			// appName="porpra.euroleague";
			// appName="air.mobileplayer.novisign.com";
			// appName="com.july.lpgaandroid";
			 //appName="com.july.cbssports.activity";
			//appName = "com.july.tru";
			// appName="com.july.bru";
			// appName="com.july.pacsun";
			// appName="com.july.indya";
			 appName="com.justdial.search";
			// appName="com.twoergo.espn";
			// -----------------------------------------

			fetchData.call(driver, appName);

			WebElement Details1 = null;
			Thread.sleep(2000);
			
			 
			 

		
			  int afterval=0;
			  int beforeVal=0;
			 do
			 {
				 Thread.sleep(2000);
				 
				  fetchData.getComments(driver);
				  WebElement footer=driver.findElement(By.className("num-pagination-control"  ));
				  Details1=footer.findElement(By.cssSelector( ".num-pagination-page-button.num-pagination-next.goog-inline-block"));
				  
				  beforEle=driver.findElement(By.cssSelector(".num-pagination-page-button.goog-inline-block.num-pagination-page-selected"));
				  
				   beforeVal=Integer.parseInt(beforEle.getText());
				  
				   
				  System.out.println(beforeVal+"before clicking ");
				  if(Details1.isDisplayed())
				  {				  
				  Details1.click(); 
				  
				  driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				  Thread.currentThread();
				Thread.sleep(2000);
				  
				   after=driver.findElement(By.cssSelector(".num-pagination-page-button.goog-inline-block.num-pagination-page-selected"));
				   
				    afterval=Integer.parseInt(after.getText());
				    
				    System.out.println(afterval+"after clicking ");
				  }
				    
			 }while(afterval!=beforeVal);
			 

		} catch (ElementNotFoundException e) {
			System.out.println("Reached end of the comments page");

		} catch (Exception mainException) {
			mainException.printStackTrace();
		}

	}

	public void call(WebDriver driver, String appName)
			throws InterruptedException {

		driver.get("https://play.google.com/store/apps/details?id=" + appName
				+ "&feature=search_result#");
		fetchData.getappDetials(driver);
		Thread.sleep(1000);
		WebElement UserReviews = driver.findElement(By
				.partialLinkText("User Reviews"));
		UserReviews.click();

	}

	public void getappDetials(WebDriver driver) {
		String Version;

		double ratingVal;
		java.sql.Date UpdatedDate = null;

		WebElement ele = driver.findElement(By
				.cssSelector(".ratings.goog-inline-block"));
		String rating = ele.getAttribute("title");
		System.out.println(rating);

		ratingVal = helper.generateRating(rating);

		System.out.println(ratingVal + "actual value is ");

		System.out.println(driver.findElement(By.tagName("time")).getText());
		WebElement version = driver.findElement(By
				.cssSelector("dd[itemprop='softwareVersion']"));
		System.out.println("version is " + version.getText());

		Version = version.getText();

		WebElement downLoads = driver.findElement(By
				.cssSelector("span[itemprop='ratingCount']"));

		String reviewCount = downLoads.getAttribute("content");
		System.out.println("Review count is " + reviewCount);

		WebElement numberOFDownloads = driver.findElement(By
				.cssSelector("dd[itemprop='numDownloads']"));
		System.out
				.println("number of downloads " + numberOFDownloads.getText());
		String downloadCount = numberOFDownloads.getText();
		System.out.println("download count is " + downloadCount);

		WebElement fileSize = driver.findElement(By
				.cssSelector("dd[itemprop='fileSize']"));

		System.out.println("filesize " + fileSize.getText());
		String size = fileSize.getText();
		System.out.println("file size is " + size);

		WebElement mainCategory = driver.findElement(By
				.cssSelector(".doc-metadata-list"));

		String categoryApp = mainCategory.findElement(By.tagName("a"))
				.getText();
		System.out.println("category of app is " + categoryApp);

		String updatedDateele = mainCategory.findElement(By.tagName("time"))
				.getText();
		System.out.println("value of date from the wp" + updatedDateele);
		UpdatedDate = helper.getDate(updatedDateele);
		System.out.println(UpdatedDate);

		WebElement ContentRatingele = driver.findElement(By
				.cssSelector("dd[itemprop='contentRating']"));
		System.out.println(ContentRatingele.getText());
		String contentRating = ContentRatingele.getText();
		System.out.println("content rating " + contentRating);

		WebElement price = driver.findElement(By
				.cssSelector("dd[itemprop='offers']"));
		System.out.println(price.getText());
		String priceval = price.getText();
		System.out.println("price val is " + priceval);

		AppID = helper.generateAppId();

		servcInf.addAppInfo(new AppDetails(AppID, appName, UpdatedDate,Version, size, downloadCount, reviewCount, categoryApp,contentRating, priceval, ratingVal));

	}

	public void getComments(WebDriver driver) {
		String Username = null;
		String Title = null;
		String Device = "";
		Double Ratingval = null;
		String Comment = null;
		Date coomentdate = null;
		int appid = 0;

		try {
			WebElement main = driver.findElement(By
					.cssSelector(".doc-user-reviews-list"));
			List<WebElement> MainHook = new ArrayList<WebElement>();
			MainHook = main.findElements(By
					.cssSelector(".doc-user-reviews-page"));

			for (WebElement temp : MainHook) {
				for (WebElement ele : temp.findElements(By
						.cssSelector(".doc-review"))) {
					WebElement secondhead = ele
							.findElement(By
									.cssSelector("div[class='review-body-column goog-inline-block']"));

					if (secondhead.getText() != null
							&& secondhead.getText().trim().length() > 0) {

						String data = secondhead.getText();

						String[] commentInfo = helper.commentDetials(data);
						String[] userDetials = helper
								.userDeatilsplit(commentInfo[0]);

						Username = userDetials[0].trim();
						Title = commentInfo[1];
						if (userDetials.length>2 ) {
							Device = userDetials[2];
						}
						Comment = commentInfo[2];
						System.out.println("");
						coomentdate = helper.getDate(userDetials[1]);

						System.out.println(coomentdate + " date is   ");

						WebElement ratingEle = ele.findElement(By
								.cssSelector(".doc-review-ratings-line"));
						WebElement ratingdata = ratingEle.findElement(By
								.cssSelector(".ratings.goog-inline-block"));

						System.out.println("rating "
								+ ratingdata.getAttribute("title"));
						System.out
								.println("-------------------------------------------------------");
						String Rating = ratingdata.getAttribute("title");
						Ratingval = helper.generateRating(Rating);

						appid = helper.getAppID(appName);

						servcInf.addComments(new CommentDetails(Username,
								Title, Device, Ratingval, Comment, coomentdate,
								appid));

					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void clickNext(WebDriver driver) {
		WebElement footer = driver.findElement(By
				.className("num-pagination-control"));
		WebElement Details1 = footer
				.findElement(By
						.cssSelector(".num-pagination-page-button.num-pagination-next.goog-inline-block"));
		Details1.click();
	}

}
