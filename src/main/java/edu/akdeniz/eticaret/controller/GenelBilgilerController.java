package edu.akdeniz.eticaret.controller;

import java.util.Locale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class GenelBilgilerController {
	
	@RequestMapping(value = "/hakkimizda", method = RequestMethod.GET)
	public String hakkimizda(Locale locale, Model model) {
		return "hakkimizda";   
	}
}