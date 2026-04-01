package com.ui.pojos;

public class Environment {
	private String url;
	private int MAX_NUMBER_OF_ATTEMPTS;
	public int getMax_Number_Of_Attempts() {
		return MAX_NUMBER_OF_ATTEMPTS;
	}

	public void setMax_Number_Of_Attempts(int max_Number_Of_Attempts) {
		MAX_NUMBER_OF_ATTEMPTS = max_Number_Of_Attempts;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
