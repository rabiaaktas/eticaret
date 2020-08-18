package edu.akdeniz.eticaret.controller;

import java.util.List;
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
public class ProductInsertController {
	
	@Autowired EticaretService eticaretService;

	@RequestMapping(value = "/admin/urunEkle", method = RequestMethod.GET)
	public String getUrunInsert(Locale locale, Model model) {
    List<KategoriModel> kategoriList=eticaretService.getKategoriList();
    model.addAttribute("kategoriList", kategoriList);
	 return "productInsert";
	}
	
	@RequestMapping(value = "/admin/urunEkle", method = RequestMethod.POST)
	public String postUrunInsert(@ModelAttribute("urunInsertModel") UrunModel urunInsertModel,BindingResult result, Model model) {
	 IslemSonucModel sonuc=new IslemSonucModel();
	 eticaretService.insertUrun(urunInsertModel);
	 List<KategoriModel> kategoriList=eticaretService.getKategoriList();
	 model.addAttribute("kategoriList", kategoriList);
	 model.addAttribute("sonuc", sonuc);
	 return "redirect:/admin/urunler?pageId=1";             
	}
}                      