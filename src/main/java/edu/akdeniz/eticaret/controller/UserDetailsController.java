package edu.akdeniz.eticaret.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.UserInfModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class UserDetailsController {
	@Autowired EticaretService eticaretService;

	@RequestMapping(value="/admin/userDetails", method=RequestMethod.GET)
	public String getUserDetails(@RequestParam("kullaniciID") Integer kullaniciID,Locale locale,Model model) {
		UserInfModel user=eticaretService.getUserById(kullaniciID);
		model.addAttribute("user",user);
		return "userDetails";
	}
	
	@RequestMapping(value="/admin/userDetails", method=RequestMethod.POST)
	public String postUserDetails(@ModelAttribute("user") UserInfModel user,Locale locale,Model model) {
		return "userDetails";
	}
	
	
	
}
