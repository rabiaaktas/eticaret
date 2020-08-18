package edu.akdeniz.eticaret.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.akdeniz.eticaret.model.OrderModel;
import edu.akdeniz.eticaret.service.EticaretService;

@Controller
public class OrderDoneController {

	@Autowired EticaretService eticaretService;
	
	@RequestMapping(value = "/admin/tamamlananSiparisler" , method = RequestMethod.GET)
	public String getOrderDone(@RequestParam("pageId") Integer pageId , Locale locale,Model model) {
		Integer total = 2;
		model.addAttribute("currentPage", pageId);
		Integer noOfPages = eticaretService.getOrdersDoneCount();
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<OrderModel> orderList = eticaretService.getOrderListDone(pageId, total);
		model.addAttribute("noOfPages", noOfPages);
		model.addAttribute("orderList", orderList);
		return "orderDoneList";
	}
	
	@RequestMapping(value = "/admin/orderProductsDone", method = RequestMethod.GET)
	public String getOrderProduct(@RequestParam("SiparisID") Integer SiparisID,Model model) {
		List<OrderModel> products = eticaretService.getOrderProductsDone(SiparisID);
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
	
	
//	@RequestMapping(value = "/admin/updateState/{SiparisID}",method = RequestMethod.POST)
//	public String updateCargoState(@ModelAttribute("orderCargoModel") OrderModel orderCargoModel,
//			@PathVariable("SiparisID") Integer SiparisID,Locale  locale,Model model) {
//		eticaretService.orderStateUpdate(orderCargoModel, SiparisID);		
//		return "redirect:/admin/ordersDoneList?pageId=1";
//		
//	}
	
	@RequestMapping(value = "/admin/searchDoneOrders",method = RequestMethod.GET)
	public String getsearchCargoOrders(@RequestParam("searchVal") String searchVal,Model model) {
		Integer pageId = 1;
		int total = 2;
		Integer noOfPages = eticaretService.getOrdersDoneCount();
		double a = (double)noOfPages / (double)total;
		noOfPages = (int) Math.ceil(a);
		if(pageId==1) {
			
		}
		else {
			 pageId = (pageId-1)*total+1;
		}
		List<OrderModel> orderList = eticaretService.searchDoneOrders(searchVal,pageId,total);
		model.addAttribute("searchVal", searchVal);
		model.addAttribute("orderList", orderList);
		model.addAttribute("noOfPages", noOfPages);
		return "orderDoneList";
		
	}
	
	@RequestMapping(value = "/admin/searchDoneOrders",method = RequestMethod.POST)
	public String searchCargoOrders(@RequestParam("searchVal") String searchVal,Model model) {
//		Integer pageId = 1;
//		int total = 2;
//		Integer noOfPages = eticaretService.getOrdersDoneCount();
//		double a = (double)noOfPages / (double)total;
//		noOfPages = (int) Math.ceil(a);
//		if(pageId==1) {
//			
//		}
//		else {
//			 pageId = (pageId-1)*total+1;
//		}
//		List<OrderModel> orderList = eticaretService.searchDoneOrders(searchVal);
//		model.addAttribute("orderList", orderList);
//		model.addAttribute("noOfPages", noOfPages);
		return "redirect:/admin/searchDoneOrders?searchVal="+searchVal+"&pageId=1";
		
	}
	
}
