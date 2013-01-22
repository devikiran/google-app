package com.market.review;

import com.gc.android.market.api.MarketSession;
import com.gc.android.market.api.MarketSession.Callback;
import com.gc.android.market.api.model.Market.CommentsRequest;
import com.gc.android.market.api.model.Market.CommentsResponse;
import com.gc.android.market.api.model.Market.ResponseContext;

public class AndroidMarketReview {

	public static void main(String args[]) {
		MarketSession session = new MarketSession();
		session.login("ravi.eng.it@gmail.com", "%sai123%");

		CommentsRequest commentsRequest = CommentsRequest.newBuilder()
				.setAppId("7065399193137006744").build();

		session.append(commentsRequest, new Callback<CommentsResponse>() {
			@Override
			public void onResult(ResponseContext context,
					CommentsResponse response) {
				System.out.println("Response : " + response);
			}
		});

		session.flush();

	}
}