package edu.akdeniz.eticaret.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class LoginController {
	
//	public void configure(HttpSecurity httpSecurity) throws Exception{
////		httpSecurity.authorizeRequests().antMatchers("/**").hasRole("").and().formLogin();
////		httpSecurity.sessionManagement();
//		
//		
//	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(@RequestParam(value = "error" , required = false) String error,
			@RequestParam(value = "logout" , required = false) String logout,
			ModelMap modelMap) {
		return "statik/login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/user/login?logout";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied(Authentication authentication, ModelMap modelMap) {
		if(authentication != null) {
			modelMap.put("msg", "Hi " + authentication.getName() + ", you do not have permission to access this page!");
		} else {
			modelMap.put("msg", "You do not have permission to access this page!");
		}
		return "/accessDenied";
	}
}
