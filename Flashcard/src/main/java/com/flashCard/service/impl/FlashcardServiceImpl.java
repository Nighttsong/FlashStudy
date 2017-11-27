package com.flashCard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flashCard.dao.FlashcardDao;
import com.flashCard.dao.LoginDao;
import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet;
import com.flashCard.service.FlashcardService;

@Service("flashcardService")
public class FlashcardServiceImpl implements FlashcardService {

	@Autowired
	LoginDao userDao;
	
	 public void saveLogin(FlashCardSet set) {
		 
		 
	 }
	 
	 public void addCreateFlashcard(List<FlashCard> set, String user) {
		 int number = userDao.getNextNumberSet() + 1;
		 for(int i=0; i<set.size(); i++) {
			 userDao.creatFlashCards(set.get(i), user, number);
		 }
	 }
	 
	 public List<FlashCardSet> getFlashcards(String user) { 
		 
		 return userDao.getFlashcards(user);
	 }
	 
	 public List<FlashCardSet> getPublicFlashcards(String pri) {
		 return userDao.getPublicFlashcards(pri);
	 }
}
