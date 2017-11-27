package com.flashCard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashCard.dao.FlashcardDao;
import com.flashCard.dao.LoginDao;
import com.flashCard.model.FlashCardSet;
import com.flashCard.service.FlashcardService;

@Service("flashcardService")
public class FlashcardServiceImpl implements FlashcardService {

	//@Autowired
	//FlashcardDao flashcardDao;
	
	 public void saveLogin(FlashCardSet set) {
		 
		 
	 }

	@Override
	public void addCreateFlashcard(FlashCardSet set, String user) {
		// flashcardDao.addCreateFlashcard(set, user);
		
	}
}
