package com.flashCard.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet;
import com.flashCard.model.User;
import com.flashCard.service.FlashcardService;

@Controller
public class CreateFlashcardController {

	@Autowired
	FlashcardService flashcardService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		ModelAndView mav = null;
		if(user != null) {
			mav = new ModelAndView("create");
			// TODO: Load the users' saved flashcards and show them...
			mav.addObject("flashCardSet", new FlashCardSet());
		}else {
			mav = new ModelAndView("login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/createProcess", method = RequestMethod.POST)
	public ModelAndView saveCreate(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("name") String name, @RequestParam("privacy") String privacy, @RequestParam("questions[]") List<String> questions) {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		ModelAndView mav = null;


		if(user == null) {
			mav = new ModelAndView("login");
			return mav;
		}
		
		//go thru the responses
		List<FlashCard> flashCards = new ArrayList<FlashCard>();
		for (int i=0; i < questions.size(); i++) {
			FlashCard flashCard = new FlashCard();
			flashCard.setFront(questions.get(i++));
			flashCard.setBack(questions.get(i));
			//add each card to the set
			if (flashCard.getFront().length() > 0) {
				flashCards.add(flashCard);
			}
		}
		FlashCardSet set = new FlashCardSet();
		set.setFlashcards(flashCards);
		
		//save the set? not sure......

		//This is where the Starts the process of saving. 
		//send the flashcard list into this service
		flashcardService.addCreateFlashcard();
		
		
		return mav;
	}
	
	
}
