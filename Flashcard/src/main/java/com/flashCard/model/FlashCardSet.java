package com.flashCard.model;

import java.util.List;

public class FlashCardSet {
	
	private String name;
	private String privacy;
	private List<FlashCard> flashcards;
	private int id;
	//List of all flashcards in one set
	//Not sure if this will work, testing is a must!

	public FlashCardSet() {
		
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public FlashCardSet(int id, String name, String privacy) {
		this.id = id;
		this.name = name;
		this.privacy = privacy;
	}
	public FlashCardSet(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	
	public List<FlashCard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(List<FlashCard> flashcards) {
		this.flashcards = flashcards;
	}
	
	
}
