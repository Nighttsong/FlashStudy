package com.flashCard.controllers;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
			mav.addObject("flashCardSet", new FlashCardSet());
		}else {
			mav = new ModelAndView("login");
		}
		return mav;
	}
	
	@RequestMapping(value = "/createProcess", method = RequestMethod.POST)
	public ModelAndView saveCreate(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") User login) {
		ModelAndView mav = null;
		//This is where the Starts the process of saving. 
		//send the flashcard list into this service
		flashcardService.addCreateFlashcard();
		return mav;
	}
	
	
}
