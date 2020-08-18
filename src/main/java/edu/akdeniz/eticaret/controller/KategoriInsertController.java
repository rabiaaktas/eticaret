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
import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class KategoriInsertController {

	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value="/admin/kategoriEkle",method = RequestMethod.GET)
	public String getKategoriInsert(Locale locale,Model model) {	
		return "kategoriInsert";
	}
	
	@RequestMapping(value="/admin/kategoriEkle", method= RequestMethod.POST)
	public String postKategoriInsert(@ModelAttribute("kategoriInsertModel") KategoriModel kategoriInsertModel,BindingResult result, Model model) {
		IslemSonucModel ýslemSonuc=new IslemSonucModel();
		eticaretService.insertKategori(kategoriInsertModel);
		model.addAttribute("ýslemSonuc",ýslemSonuc);
		return "redirect:/admin/kategoriList";
		
	}
	

}
