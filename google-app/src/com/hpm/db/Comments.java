package com.hpm.db;

public class Comments {

	private String authorName, text, authorId;
	private int rating,creationTime;
	
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAuthorId() {
		return authorId;
	}
	@Override
	public String toString() {
		return "Comments [authorName=" + authorName + ", text=" + text
				+ ", authorId=" + authorId + ", rating=" + rating
				+ ", creationTime=" + creationTime + "]";
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getCreationTime() {
		return creationTime;
	}
	public Comments(String authorName, String text, String authorId,
			int rating, int creationTime) {
		super();
		this.authorName = authorName;
		this.text = text;
		this.authorId = authorId;
		this.rating = rating;
		this.creationTime = creationTime;
	}
	public void setCreationTime(int creationTime) {
		this.creationTime = creationTime;
	}
	 

}
