package edu.akdeniz.eticaret.controller;


import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class KategoriController {
	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/kategori/kitap", method = RequestMethod.GET)
	public String kitap(@RequestParam("pageId") Integer pageId,Locale locale, Model model) {
		Integer noOfPages=eticaretService.getProductCount();
		 model.addAttribute("currentPage", pageId);
		int total = 8;
		 double a = (double)noOfPages / (double)total;
		 noOfPages = (int) Math.ceil(a);		 
		 if(pageId==1) {
			 
		 }
		 else {
			 pageId = (pageId-1)*total+1;
		 }
		 KategoriModel kategori = null;
		 List<UrunModel> urunList=eticaretService.getProductList(pageId,total);
	
		for (UrunModel i : urunList) {
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("data:image/png;base64,");
				sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(i.getDosyaThumb(), false)));
				i.setDosyaThumbString(sb.toString());
				if(i.getDosyaThumbString().length()<30){
					i.setDosyaThumbString(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("kategori", kategori);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("urunList",urunList);
		List<KategoriModel> kategoriList=eticaretService.getKategoriList();
		model.addAttribute("kategoriList", kategoriList);
		return "kitap";                               
	}
	
	
	@RequestMapping(value="/kategori/kitap/{ignored}/{KategoriId}",method=RequestMethod.GET)
	public String getCategorizedBooks(@RequestParam("pageId") Integer pageId,@PathVariable("KategoriId") Integer KategoriId
			,@PathVariable("ignored") String ignored,Model model) {
		 Integer noOfPages=eticaretService.getCategorizedProductCount(KategoriId);
		 model.addAttribute("currentPage", pageId);
		 Integer total = 4;
		 double a = (double)noOfPages / (double)total;
		 noOfPages = (int) Math.ceil(a);		 
		 if(pageId==1) {
			 
		 }
		 else {
			 pageId = (pageId-1)*total+1;
		 }	
		 KategoriModel kategori = eticaretService.getKategoriID(KategoriId);
   		 List<UrunModel> urunList=eticaretService.getCategorizedProduct(KategoriId,pageId,total);
		for (UrunModel i : urunList) {
			try {
				StringBuilder sb = new StringBuilder();
				sb.append("data:image/png;base64,");
				sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(i.getDosyaThumb(), false)));
				i.setDosyaThumbString(sb.toString());
				if(i.getDosyaThumbString().length()<30){
					i.setDosyaThumbString(null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	    List<KategoriModel> kategoriList=eticaretService.getKategoriList();
	    model.addAttribute("kategori", kategori);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("urunList", urunList);
		model.addAttribute("kategoriAdi", ignored);
		model.addAttribute("KategoriId", KategoriId);
		model.addAttribute("kategoriList", kategoriList);
		return "kitapCategorized";
		
	}
}
