package com.flashCard.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.flashCard.dao.impl.FlashcardDaoImpl;
import com.flashCard.model.FlashCardSet;

public class FlashcardDao {
	@Autowired
	FlashcardDaoImpl flashcardDaoImpl;
	public void addCreateFlashcard(FlashCardSet set, String user) {
		flashcardDaoImpl.addCreateFlashcard(set, user);
	}
}	
