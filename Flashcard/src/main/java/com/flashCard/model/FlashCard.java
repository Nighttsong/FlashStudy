package com.flashCard.model;

public class FlashCard {

	//model for each flashcard
	String name;
	String privacy;
	String front;
	String back;
	int id;
	public FlashCard() {
		
	}
	public FlashCard(String name,String front, String back, int id) {
		super();
		this.name = name;
		this.front = front;
		this.back = back;
		this.id = id;
	}
	
	public FlashCard(String name, String privacy, String front, String back, int id) {
		super();
		this.name = name;
		this.privacy = privacy;
		this.front = front;
		this.back = back;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getFront() {
		return front;
	}
	public void setFront(String front) {
		this.front = front;
	}
	public String getBack() {
		return back;
	}
	public void setBack(String back) {
		this.back = back;
	}
}
