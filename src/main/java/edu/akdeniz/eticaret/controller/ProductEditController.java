package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.akdeniz.eticaret.helper.model.IslemSonucModel;
import edu.akdeniz.eticaret.model.KategoriModel;
import edu.akdeniz.eticaret.model.StokModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class ProductEditController {

	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/admin/urunler", method = RequestMethod.GET)
	public String getProduct(@RequestParam("pageId") Integer pageId,Locale locale, Model model) {
		 Integer noOfPages=eticaretService.getProductCount();
		 model.addAttribute("currentPage", pageId);
		 Integer total = 2;
		 double a = (double)noOfPages / (double)total;
		 noOfPages = (int) Math.ceil(a);		 
		 if(pageId==1) {
			 
		 }
		 else {
			 pageId = (pageId-1)*total+1;
		 }
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
		 model.addAttribute("noOfPages", noOfPages);
		 model.addAttribute("urunList", urunList);
		 return "productList";
	}
	
	
	@RequestMapping(value = "/admin/urunler", method = RequestMethod.POST)
	public String postProductEdit(BindingResult result, Model model) {
		return "urunler?pageId=1";             
	}
	
	@RequestMapping(value = "/admin/searchUrun" , method = RequestMethod.GET)
	public String getSearchProduct(@RequestParam("searchVal") String searchVal,@RequestParam("pageId") Integer pageId,Model model) {
		int total = 2;
		model.addAttribute("currentPage", pageId);
		Integer noOfPages = eticaretService.getSearchedProductCount(searchVal);
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<UrunModel> urunList = eticaretService.searchProduct(searchVal,pageId,total);
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
		model.addAttribute("searchVal", searchVal);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("urunList", urunList);
		return "productListSearch";
		
	}
	
	@RequestMapping(value = "/admin/searchUrun" , method = RequestMethod.POST)
	public String postSearchProduct(@RequestParam("searchVal") String searchVal,@RequestParam("pageId") Integer pageId,Model model) {
//		int total = 2;
//		model.addAttribute("currentPage", pageId);
//		Integer noOfPages = eticaretService.getSearchedProductCount(searchVal);
//		double a = (double)noOfPages / (double)total;
//		noOfPages = (int) Math.ceil(a);
//		if(pageId==1) {
//			
//		}
//		else {
//			 pageId = (pageId-1)*total+1;
//		}
//		List<UrunModel> urunList = eticaretService.searchProduct(searchVal,pageId,total);
//		for (UrunModel i : urunList) {
//			try {
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
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("urunList", urunList);
		return "redirect:/admin/searchUrun?searchVal="+searchVal+"&pageId=1";
		
	}
	
	@RequestMapping(value = "/admin/urunDuzenle/{UrunID}", method = RequestMethod.GET) 
	public String productEdit(Model model,@PathVariable("UrunID") Integer UrunID) {
		List<KategoriModel> kategoriList=eticaretService.getKategoriList();
		model.addAttribute("kategoriList", kategoriList);
		UrunModel urunBilgileri=eticaretService.getProduct(UrunID);
		model.addAttribute("urunBilgileri", urunBilgileri);
		return "productEdit";
	}
	@RequestMapping(value = "/admin/urunDuzenle/{UrunID}", method = RequestMethod.POST) 
	public String productEditPost(@ModelAttribute("urunler") UrunModel urunler,BindingResult result, Model model) {
		eticaretService.productUpdate(urunler);
		return "redirect:/admin/urunler?pageId=1";
	}
	
	@RequestMapping(value="/admin/deleteProduct", method=RequestMethod.GET)
	public String productDelete(Integer UrunID) {
		eticaretService.productDelete(UrunID);
		return "redirect:/admin/urunler?pageId=1";
	}
	
	@RequestMapping(value = "/getUrunResim", method = RequestMethod.GET)
	public @ResponseBody String getUrunResim(@RequestParam String ResimDosyaId){
		String DosyaStringl = null;
		Integer dosyaId=Integer.valueOf(ResimDosyaId);
		try {
			System.out.println("dosyaId "+dosyaId);
			byte[] dosyaresim = eticaretService.getUrunResim(dosyaId).get(0);
			StringBuilder sb = new StringBuilder();
			sb.append("data:image/png;base64,");
			sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(dosyaresim, false)));
			DosyaStringl = sb.toString();
			if (DosyaStringl.length() < 30) {
				DosyaStringl = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DosyaStringl;
	}
	
	@RequestMapping(value = "/getUrunResimThumb", method = RequestMethod.GET)
	public @ResponseBody String getUrunResimThumb(@RequestParam String ResimDosyaId){
		String DosyaStringl = null;
		Integer dosyaId=Integer.valueOf(ResimDosyaId);
		try {
			System.out.println("dosyaId "+dosyaId);
			byte[] dosyaresim = eticaretService.getUrunResimThumb(dosyaId).get(0);
			StringBuilder sb = new StringBuilder();
			sb.append("data:image/png;base64,");
			sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(dosyaresim, false)));
			DosyaStringl = sb.toString();
			if (DosyaStringl.length() < 30) {
				DosyaStringl = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return DosyaStringl;
	}
	
	@RequestMapping(value = "/admin/stokUpdate",method = RequestMethod.GET)
	public String getStokUpdate(Model model,@RequestParam("UrunId") Integer UrunId) {
		StokModel adet = null;
		try {
			adet = eticaretService.getStokAdet(UrunId);

		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		model.addAttribute("adet",adet);
		return "";
	}
	
	@RequestMapping(value = "/admin/stokUpdate",method = RequestMethod.POST)
	public String postStokUpdate(@ModelAttribute("stokModel") StokModel stokModel, Model model) {
		eticaretService.stokUpdate(stokModel);
		return "redirect:/admin/urunler?pageId=1";
	}
	
//	@RequestMapping(value = "/stokInsert",method = RequestMethod.GET)
//	public String getStokInsert(Model model,@RequestParam("UrunId") Integer UrunId) {
//		return "productList";
//	}
	@RequestMapping(value = "/admin/stokInsert",method = RequestMethod.POST)
	public String postStokInsert(@ModelAttribute("stokmodel") StokModel stokModel, Model model) {
		IslemSonucModel sonuc=new IslemSonucModel();
		eticaretService.stokInsert(stokModel);
		model.addAttribute("sonuc", sonuc);		
		return "redirect:/admin/urunler?pageId=1";
	}
	

	
}