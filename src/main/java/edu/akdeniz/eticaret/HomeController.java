package edu.akdeniz.eticaret;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import edu.akdeniz.eticaret.mapper.ProductMapper;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired ProductMapper urunMapper;
	@Autowired EticaretService eticaretService;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
//		List<UrunModel> urunler=urunMapper.getProductList();
		List<UrunModel> son1 = eticaretService.getProductListSonEklenen1();
		List<UrunModel> son2 = eticaretService.getProductListSonEklenen2();
		for (UrunModel i : son1) {
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
		for (UrunModel i : son2) {
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
//		for (UrunModel i : urunler) {
//			try {
//				StringBuilder sb = new StringBuilder();
//				sb.append("data:image/png;base64,");
//				sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(i.getDosya(), false)));
//				i.setDosyaString(sb.toString());
//				if(i.getDosyaString().length()<30){
//					i.setDosyaString(null);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		model.addAttribute("urunler", urunler);
		model.addAttribute("son1", son1);
		model.addAttribute("son2", son2);


		return "statik/index";                               
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET,headers = "Accept=application/json")
	@ResponseBody
	public  List<UrunModel> search(@RequestParam("term") String query){
//		return eticaretService.search(request.getParameter("term")); HttpServletRequest request
		List<UrunModel> products = new ArrayList<UrunModel>(); //except arraylist it can not return as a json object 
		products= eticaretService.search(query);
		return products;
	}
}