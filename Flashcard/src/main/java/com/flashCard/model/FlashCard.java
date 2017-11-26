package com.flashCard.model;

public class FlashCard {
	public Integer id;
	public String category;
	public String name;
	public String privacy;
	
	
	
	public FlashCard(Integer id, String category, String name, String privacy) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.privacy = privacy;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	
	
}
