package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class SearchController {

	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/searchProduct", method = RequestMethod.GET)
	public String searchedProductsGet(@RequestParam("searchVal") String searchVal,@RequestParam("pageId") Integer pageId,Locale locale,Model model) {
		Integer noOfPages=eticaretService.getSearchedProductCount(searchVal);
		 model.addAttribute("currentPage", pageId);
		 Integer total = 2;
		 double a = (double)noOfPages / (double)total;
		 noOfPages = (int) Math.ceil(a);		 
		 if(pageId==1) {
			 
		 }
		 else {
			 pageId = (pageId-1)*total+1;
		 }
		List<UrunModel> urunList = eticaretService.searchProduct(searchVal, pageId, total);
		for (UrunModel i : urunList) {
			try {
				if(i.getDosyaThumb() == null) {
					System.out.println("Boþþþþ"+ i);
				}
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
		model.addAttribute("searchVal", searchVal);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("urunList", urunList);
		return "searchResult";
		
	}
	
	@RequestMapping(value = "/searchProduct", method = RequestMethod.POST)
	public String searchedProducts(@RequestParam("searchVal") String searchVal,Locale locale,Model model) {
		 Integer noOfPages=eticaretService.getSearchedProductCount(searchVal);
		 Integer pageId = 1;
		 Integer total = 2;
//		 model.addAttribute("currentPage", pageId);
//		 double a = (double)noOfPages / (double)total;
//		 noOfPages = (int) Math.ceil(a);		 
//		 if(pageId==1) {
//			 
//		 }
//		 else {
//			 pageId = (pageId-1)*total+1;
//		 }
//		List<UrunModel> urunList = eticaretService.searchProduct(searchVal, 1, 5);
//		for (UrunModel i : urunList) {
//			try {
//				if(i.getDosyaThumb() == null) {
//					System.out.println("Boþþþþ"+ i);
//				}
//				StringBuilder sb = new StringBuilder();
//				sb.append("data:image/png;base64,");
//				sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(i.getDosyaThumb(), false)));
//				i.setDosyaThumbString(sb.toString());
//				if(i.getDosyaThumbString().length()<30){
//					i.setDosyaThumbString(null);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		model.addAttribute("searchVal", searchVal);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("urunList", urunList);
		return "redirect:/searchProduct?searchVal="+searchVal+"&pageId=1";
		
	}
}
