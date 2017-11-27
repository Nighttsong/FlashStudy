package com.flashCard.service;

import java.util.ArrayList;
import java.util.List;

import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet; 

public interface FlashcardService {

	 public void saveLogin(FlashCardSet set);
	 public void addCreateFlashcard(List<FlashCard> set, String user);
	 public List<FlashCardSet> getFlashcards(String user);
	 public List<FlashCardSet> getPublicFlashcards(String pri);
}
