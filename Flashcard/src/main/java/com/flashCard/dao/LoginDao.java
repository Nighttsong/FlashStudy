package com.flashCard.dao;


import java.util.List;

import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet;
import com.flashCard.model.User;

public interface LoginDao {

	public String saveLogin(User user);
	public User validateLogin(User login);
	public void creatFlashCards(FlashCard sets,String user, int setNumber);
	 public int getNextNumberSet();
	 public List<FlashCardSet> getFlashcards(String user);
	 public List<FlashCardSet> getPublicFlashcards(String pri);
	 public List<FlashCard> getStudyFlashSet(int id);
}
