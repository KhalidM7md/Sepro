package edu.qu.entities;

public class Comment {
	
	private String text; 
	private String ID; 
	private int NoOfAnnotators; 
	private String sentiment; 
	private double confidenceScore; 
	private int dislikes; 
	private int likes; 
	private String pageTitle; 
	private boolean IsItTestQuestion;
	private String PageURL; 
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getNoOfAnnotators() {
		return NoOfAnnotators;
	}
	public void setNoOfAnnotators(int noOfAnnotators) {
		NoOfAnnotators = noOfAnnotators;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public double getConfidenceScore() {
		return confidenceScore;
	}
	public void setConfidenceScore(double confidenceScore) {
		this.confidenceScore = confidenceScore;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public String getPageTitle() {
		return pageTitle;
	}
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	public boolean isIsItTestQuestion() {
		return IsItTestQuestion;
	}
	public void setIsItTestQuestion(boolean isItTestQuestion) {
		IsItTestQuestion = isItTestQuestion;
	}
	public String getPageURL() {
		return PageURL;
	}
	public void setPageURL(String pageURL) {
		PageURL = pageURL;
	}

}
