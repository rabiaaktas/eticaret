package edu.akdeniz.eticaret.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.akdeniz.eticaret.helper.model.IslemSonucModel;
import edu.akdeniz.eticaret.mapper.KayitMapper;
import edu.akdeniz.eticaret.model.KayitModel;
import edu.akdeniz.eticaret.service.EticaretService;
import edu.akdeniz.eticaret.validator.YeniKayitValidator;

@Controller
public class YeniKayitController {
	
	@Autowired KayitMapper kayitMapper;
	@Autowired EticaretService eticaretService;
	@Autowired YeniKayitValidator yeniKayitValidator;
	
	@RequestMapping(value = "/kayitOl", method = RequestMethod.GET)
	public String yeniKayit(Locale locale, Model model) {
		return "kayit";                               
	}
	
	@RequestMapping(value = "/kayitOl", method = RequestMethod.POST)
	public String yeniKayitPost(@ModelAttribute("kayitModel") KayitModel kayitModel,BindingResult result, Model model) {
		IslemSonucModel sonuc=new IslemSonucModel();
		yeniKayitValidator.validate(kayitModel, result);
		if(result.hasErrors()){
			model.addAttribute("kayitModel", kayitModel);
		}
		else{
			sonuc=eticaretService.insertKayit(kayitModel);
			model.addAttribute("kayitModel", kayitModel);
			model.addAttribute("sonuc",sonuc);
		}
				              
		return "kayit";                               
	}
}
