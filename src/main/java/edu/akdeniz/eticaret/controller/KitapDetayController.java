package edu.akdeniz.eticaret.controller;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class KitapDetayController {

	@Autowired EticaretService eticaretService;
	@RequestMapping(value="/{ignored2}",method=RequestMethod.GET)
	public String getUrunDetay(@PathVariable("ignored2") String ignored2,
			@RequestParam("UrunID") Integer UrunID,Model model) {
		UrunModel urunm = eticaretService.getProductDetails(UrunID);
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("data:image/png;base64,");
			sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(urunm.getDosya(), false)));
			urunm.setDosyaString(sb.toString());
			if(urunm.getDosyaString().length()<30){
				urunm.setDosyaString(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<KategoriModel> kategoriList = eticaretService.getKategoriList();
		model.addAttribute("kategoriList", kategoriList);
		model.addAttribute("urunm", urunm);
		return "kitapDetay";
		
	}
}
