package com.flashCard.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.flashCard.model.FlashCard;
import com.flashCard.model.FlashCardSet;
import com.flashCard.model.User;
import com.flashCard.service.FlashcardService;
import com.google.gson.Gson;

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
			flashCard.setName(name);
			flashCard.setPrivacy(privacy);
			//add each card to the set
			if (flashCard.getFront().length() > 0) {
				flashCards.add(flashCard);
			}
		}
		
		flashcardService.addCreateFlashcard(flashCards, user);
		mav = new ModelAndView("userMainPage");
		List<FlashCardSet> flashcardList = new ArrayList<FlashCardSet>();
		flashcardList = flashcardService.getFlashcards(user);
		//flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
		mav.addObject("FlashCardList", flashcardList);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/study/{id}", method = RequestMethod.GET)
	public ModelAndView study(HttpServletRequest request, HttpServletResponse response,
			@PathVariable int id) {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		ModelAndView mav = null;
		Gson gson = new Gson();
		mav = new ModelAndView("study");
		List<FlashCard> flashcards = new ArrayList<FlashCard> ();
		flashcards = flashcardService.getStudyFlashSet(id);
		String send =  gson.toJson(flashcards);
		send = send.replaceAll("\"", "'");
		mav.addObject("FlashCardList", send);
		return mav;
	}
	
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response,
			@PathVariable int id) {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		ModelAndView mav = null;
		mav = new ModelAndView("view");
		List<FlashCard> flashcards = new ArrayList<FlashCard> ();
		flashcards = flashcardService.getStudyFlashSet(id);
		mav.addObject("FlashCardList", flashcards);
		mav.addObject("name", flashcards.get(0).getName() );
		return mav;
	}
	
}
