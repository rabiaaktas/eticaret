package edu.akdeniz.eticaret.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.StokModel;
import edu.akdeniz.eticaret.service.EticaretService;

public class StokController {

	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/admin/stokUpdate",method = RequestMethod.GET)
	public String getStokUpdate(Model model,@RequestParam("UrunId") Integer UrunId) {
		StokModel adet = eticaretService.getStokAdet(UrunId);
		model.addAttribute("adet",adet);
		return "stokUpdate";
	}
	
	@RequestMapping(value = "/admin/stokUpdate",method = RequestMethod.POST)
	public String postStokUpdate(@ModelAttribute("stokModel") StokModel stokModel) {
		eticaretService.stokUpdate(stokModel);
		return "redirect:/admin/productList";
		
	}
}
