package com.flashCard.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.flashCard.model.FlashCard;
import com.flashCard.model.User;
import com.flashCard.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new User());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") User login) {
		ModelAndView mav = null;
		User user = loginService.validateLogin(login);
		if (null != user) {
			mav = new ModelAndView("userMainPage");
			HttpSession session = request.getSession();
			session.setAttribute("user", login.getUsername());
			session.setAttribute("nickname", login.getNickname());
			mav.addObject("nickname", user.getNickname());
			mav.addObject("user", user.getUsername());
			ArrayList<FlashCard> flashcardList = new ArrayList<FlashCard>();
			flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
			mav.addObject("FlashCardList", flashcardList);
		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		return mav;
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView registerProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User login) {
		ModelAndView mav = null;
		String didItWork = loginService.saveLogin(login);
		if(didItWork.equals("success")) {
			mav = new ModelAndView("userMainPage");
			HttpSession session = request.getSession();
			session.setAttribute("user", login.getUsername());
			session.setAttribute("nickname", login.getNickname());
			mav.addObject("nickname", login.getNickname());
			mav.addObject("user", login.getUsername());
			ArrayList<FlashCard> flashcardList = new ArrayList<FlashCard>();
			flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
			mav.addObject("FlashCardList", flashcardList);
		}else{
			  mav = new ModelAndView("register");
			  mav.addObject("user", new User());
            mav.addObject("message", didItWork);
		}
		return mav;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User reg) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("user", new User());
		return mav;
	}
	
	@RequestMapping(value = "*", method = RequestMethod.GET)
	public ModelAndView defaultMainPage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mainPublicPage");
		ArrayList<FlashCard> flashcardList = new ArrayList<FlashCard>();
		flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
		mav.addObject("FlashCardList", flashcardList);
		return mav;
	}
	
	@RequestMapping(value = "/mainPublicPage", method = RequestMethod.GET)
	public ModelAndView mainPublicPageGet(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("mainPublicPage");
		ArrayList<FlashCard> flashcardList = new ArrayList<FlashCard>();
		flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
		mav.addObject("FlashCardList", flashcardList);
		return mav;
	}
	
	@RequestMapping(value = "/userMainPage", method = RequestMethod.GET)
	public ModelAndView userMainPageGet(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		ModelAndView mav = null;
		if(user != null) {
			mav = new ModelAndView("userMainPage");
			ArrayList<FlashCard> flashcardList = new ArrayList<FlashCard>();
			flashcardList.add(new FlashCard(1, "exampleCat", "examplename", "Y"));
			mav.addObject("FlashCardList", flashcardList);
		}else {
			mav = new ModelAndView("login");
			mav.addObject("login", new User());
		}
		return mav;
	}
	
}