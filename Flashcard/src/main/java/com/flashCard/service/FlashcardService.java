package com.flashCard.service;

import com.flashCard.model.FlashCardSet;
import com.flashCard.model.User;

public interface FlashcardService {

	 public void saveLogin(FlashCardSet set);
	 public void addCreateFlashcard(FlashCardSet set, String user);
}
