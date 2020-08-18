package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class KategoriListController {
	@Autowired EticaretService eticaretService;
	@RequestMapping(value="/admin/kategoriler" , method=RequestMethod.GET)
	public String getKategoriList(Locale locale,Model model) {
		List<KategoriModel> kategoriList = eticaretService.getKategoriList();
		model.addAttribute("kategoriList",kategoriList);
		return "kategoriList";
		
	}
	
	@RequestMapping(value="/admin/kategoriler" , method=RequestMethod.POST)
	public String postKategoriList(BindingResult result,Model model) {
		return "kategoriList";
	}
	
	@RequestMapping(value="/admin/kategoriDuzenle/{KategoriID}" , method=RequestMethod.GET)
	public String getKategoriEdit(@PathVariable("KategoriID") Integer KategoriID,Model model) {
		List<KategoriModel> kategoriList = eticaretService.getKategoriList();
		model.addAttribute("kategoriList",kategoriList);
		KategoriModel kategoriBilgileri = eticaretService.getKategoriID(KategoriID);
		model.addAttribute("kategoriBilgileri",kategoriBilgileri);
		return "kategoriEdit";
	}
	
	@RequestMapping(value="/admin/kategoriDuzenle/{KategoriID}" , method=RequestMethod.POST)
	public String postKategoriEdit(@ModelAttribute("kategori") KategoriModel kategori, BindingResult result,Model model) {
		eticaretService.kategoriUpdt(kategori);
		return "redirect:/admin/kategoriler";
	}
	@RequestMapping(value="/admin/kategoriDelete", method= RequestMethod.GET)
	public String postKategoriDelete(@RequestParam("KategoriID") Integer KategoriID,Model model) {
		eticaretService.kategoriDel(KategoriID);
		return "redirect:/admin/kategoriler";
	}
	
	@RequestMapping(value="/admin/searchKategori", method=RequestMethod.POST)
	public String postKategoriSearch(@RequestParam("searchVal") String searchVal,Model model) {
		List<KategoriModel> kategoriList = eticaretService.searchKategori(searchVal);
		if(kategoriList != null) {
			System.out.println("kategori search");
		}
		model.addAttribute("kategoriList", kategoriList);
		return "kategoriList";
		
	}
}
