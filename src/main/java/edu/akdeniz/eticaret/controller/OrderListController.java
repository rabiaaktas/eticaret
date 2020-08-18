package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.OrderModel;
import edu.akdeniz.eticaret.model.UrunModel;
import edu.akdeniz.eticaret.model.UserInfModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class OrderListController {
	
	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/admin/siparisler", method = RequestMethod.GET)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public String getOrderList(@RequestParam("pageId") Integer pageId,Locale locale,Model model) {
		Integer total = 2;
		model.addAttribute("currentPage", pageId);
		Integer noOfPages = eticaretService.getOrderListCount()	;
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<OrderModel> orderList = eticaretService.getOrderList(pageId,total);
		List<OrderModel> stateList = eticaretService.getOrderStates();
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("orderList", orderList);
		model.addAttribute("stateList", stateList);
		return "orderList";
		
	}
	
	@RequestMapping(value = "/admin/searchOrder" , method = RequestMethod.GET)
	public String getUserSearch(@RequestParam("searchVal") String searchVal,Model model) {
		Integer pageId = 1;
		int total = 2;
		Integer noOfPages = eticaretService.getOrderListCount();
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<OrderModel> orderList=eticaretService.searchOrder(searchVal,pageId,total);
		model.addAttribute("searchVal", searchVal);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("orderList",orderList);
		return "orderListSearch";
		
	}
	
	@RequestMapping(value = "/admin/searchOrder" , method = RequestMethod.POST)
	public String postUserSearch(@RequestParam("searchVal") String searchVal,Model model) {
//		Integer pageId = 1;
//		int total = 2;
//		Integer noOfPages = eticaretService.getOrderListCount();
//		double a = (double)noOfPages / (double)total;
//		noOfPages = (int) Math.ceil(a);
//		if(pageId==1) {
//			
//		}
//		else {
//			 pageId = (pageId-1)*total+1;
//		}
//		List<OrderModel> orderList=eticaretService.searchOrder(searchVal);
////		model.addAttribute("searchVal", searchVal);
//		model.addAttribute("noOfPages", noOfPages);
//		model.addAttribute("orderList",orderList);
		return "redirect:/admin/searchOrder?searchVal="+searchVal+"&pageId=1";
		
	}
	
	@RequestMapping(value = "/admin/updateState/{siparisId}", method = RequestMethod.POST)
	public String updateState(@ModelAttribute("orderModel") OrderModel orderModel,@PathVariable("siparisId") Integer SiparisID,Model model) {
		eticaretService.orderStateUpdate(orderModel,SiparisID);
		return "redirect:/admin/siparisler?pageId=1";
		
	}

	
	@RequestMapping(value = "/admin/orderProducts", method = RequestMethod.GET)
	public String getOrderProduct(@RequestParam("SiparisID") Integer SiparisID,Model model) {
		List<OrderModel> products = eticaretService.getOrderProducts(SiparisID);
		for (OrderModel i : products) {
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
		model.addAttribute("products", products);
		return "orderProducts";
		
	}
}
