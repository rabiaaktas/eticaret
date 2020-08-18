package edu.akdeniz.eticaret.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.akdeniz.eticaret.model.ItemModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
@RequestMapping("sepet")
public class CartController {
	
	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/urunler" , method = RequestMethod.GET )
	public String cartProducts() {
			return "statik/sepet";
	}
	
	@RequestMapping(value = "buy/{id}" , method = RequestMethod.GET)
	public String buy(@PathVariable("id") String id,HttpSession session) {
		UrunModel urun = new UrunModel();
		Integer idUrun = Integer.valueOf(id);
		if(session.getAttribute("cart") == null) {
			List<ItemModel> cart = new ArrayList<ItemModel>();
			cart.add(new ItemModel(eticaretService.getProduct(idUrun),1));
			session.setAttribute("cart", cart);
		}
		else {
			List<ItemModel> cart = (List<ItemModel>) session.getAttribute("cart");
			int index = this.exists(id, cart);
			if(index == -1) {
				cart.add(new ItemModel(eticaretService.getProduct(idUrun),1));
			}
			else {
				int quantity = cart.get(index).getQuantity() + 1;
				cart.get(index).setQuantity(quantity);
			}
			session.setAttribute("cart", cart);
		}
		return "redirect:/sepet/urunler";
	}
	
	@RequestMapping(value = "remove/{id}" , method = RequestMethod.GET)
	public String remove(@PathVariable("id") String id , HttpSession session) {
		UrunModel urun = new UrunModel();
		List<ItemModel> cart = (List<ItemModel>) session.getAttribute("cart");
		int index = this.exists(id, cart);
		cart.remove(index);
		session.setAttribute("cart", cart);
		return "redirect:/sepet/urunler";
		
	}

	private int exists(String id,List<ItemModel> cart) {
		int idUrun = Integer.valueOf(id);
		for (int i = 0 ; i < cart.size() ; i++) {
			if(cart.get(i).getUrunModel().getUrunID() == idUrun ) {
				return i;
			}
		}
		return -1;
	}
	
	@RequestMapping(value = "/getSepetResim", method = RequestMethod.GET)
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
}
