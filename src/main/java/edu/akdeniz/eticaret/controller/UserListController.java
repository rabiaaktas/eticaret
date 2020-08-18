package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.UserInfModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class UserListController {
	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value= "/admin/kullanicilar" , method = RequestMethod.GET)
	public String getUserList(@RequestParam("pageId") Integer pageId,Locale locale,Model model) {
		Integer total = 2;
		model.addAttribute("currentPage", pageId);
		Integer noOfPages = eticaretService.getUserCount();
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<UserInfModel> userList= eticaretService.getUserList(pageId,total);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("userList",userList);
		return "userList";
	}
	
	@RequestMapping(value="/admin/kullanicilar" , method = RequestMethod.POST)
	public String postUserList(BindingResult result,Model model) {
		return "userList";
	}
	
	@RequestMapping(value = "/deactivateUser" , method = RequestMethod.GET)
	public String deActivateUser(@RequestParam("kullaniciID") Integer kullaniciID,Model model) {
		eticaretService.deactivateUser(kullaniciID);
		return "redirect:/admin/kullanicilar?pageId=1";		
	}
	
	@RequestMapping(value = "/activateUser" , method = RequestMethod.GET)
	public String ActivateUser(@RequestParam("kullaniciID") Integer kullaniciID,Model model) {
		eticaretService.activateUser(kullaniciID);
		return "redirect:/admin/kullanicilar?pageId=1";		
	}
	
	@RequestMapping(value="/makeAdmin", method=RequestMethod.GET)
	public String makeAdmin(@RequestParam("kullaniciID") Integer kullaniciID,Model model){
		eticaretService.setUserAsAdmin(kullaniciID);
		return "redirect:/admin/kullanicilar?pageId=1";
			
	}
	
	@RequestMapping(value="/makeUser", method = RequestMethod.GET)
	public String makeUser(@RequestParam("kullaniciID") Integer kullaniciID) {
		eticaretService.setUserAsUser(kullaniciID);
		return "redirect:/admin/kullanicilar?pageId=1";
		
	}
	
	@RequestMapping(value = "/admin/searchUser" , method = RequestMethod.GET)
	public String getUserSearch(@RequestParam("searchVal") String searchVal,@RequestParam("pageId") Integer pageId,Model model) {
		int total = 2;
		model.addAttribute("currentPage", pageId);
		Integer noOfPages = eticaretService.getSearchedUserCount(searchVal);
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<UserInfModel> userList=eticaretService.searchUser(searchVal, pageId, total);
		model.addAttribute("searchVal", searchVal);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("userList",userList);
		return "userListSearch";
		
	}
	
	@RequestMapping(value = "/admin/searchUser" , method = RequestMethod.POST)
	public String postUserSearch(@RequestParam("searchVal") String searchVal,@RequestParam("pageId") Integer pageId,Model model) {
//		int total = 2;
//		model.addAttribute("currentPage", pageId);
//		Integer noOfPages = eticaretService.getSearchedUserCount(searchVal);
//		double a = (double)noOfPages / (double)total;
//		noOfPages = (int) Math.ceil(a);
//		if(pageId==1) {
//			
//		}
//		else {
//			 pageId = (pageId-1)*total+1;
//		}
//		List<UserInfModel> userList=eticaretService.searchUser(searchVal, pageId, total);
////		model.addAttribute("searchVal", searchVal);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("userList",userList);
		return "redirect:/admin/searchUser?searchVal="+searchVal+"&pageId=1";
		
	}
}
