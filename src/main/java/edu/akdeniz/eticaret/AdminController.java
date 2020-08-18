package edu.akdeniz.eticaret;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("admin")
public class AdminController {
	
	
	@RequestMapping(value = "/",method=RequestMethod.GET)
	public String adminhome(Locale locale,Model model) {
		return "statik/adminIndex";
	}

}
