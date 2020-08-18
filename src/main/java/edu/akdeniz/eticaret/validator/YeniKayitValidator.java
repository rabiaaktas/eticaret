package edu.akdeniz.eticaret.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import edu.akdeniz.eticaret.model.KayitModel;

@Component
public class YeniKayitValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		KayitModel kayitModel=(KayitModel) target;
		
		if (!errors.hasFieldErrors("Sifre") && !errors.hasFieldErrors("SifreTekrar")) {
			if (kayitModel.getSifre().length() < 5 || kayitModel.getSifre().length() > 16) {
				errors.rejectValue("Sifre", "label.sifrekisa");
			} else if(!kayitModel.getSifre().equals(kayitModel.getSifreTekrar())) {
				errors.rejectValue("SifreTekrar", "label.sifreeslesmiyor");				
			} else if(!errors.hasFieldErrors("Sifre")) {
				boolean valid = kayitModel.getSifre().matches("^[\u0000-\u0080]+$");
				if(!valid) {            
					errors.rejectValue("Sifre", "label.turkcekarakter"); 
				}
			}
			
		}                                         
		 if(!errors.hasFieldErrors("Sifre")) {
			 Boolean passhavewhitespace=false; 
			 for(int i = 0; i < kayitModel.getSifre().length(); i++){
		            if(Character.isWhitespace(kayitModel.getSifre().charAt(i))){
		            	passhavewhitespace=true;
		            }
		      }
			 if(passhavewhitespace==true){
				 errors.rejectValue("Sifre", "label.bosluk");
			 }	
		 }
		
			if (!errors.hasFieldErrors("KullaniciAdi")) {
				if (kayitModel.getKullaniciAdi().length() < 5 || kayitModel.getKullaniciAdi().length() > 30){
					errors.rejectValue("KullaniciAdi", "label.kullaniciadikisa");
				}else if(!errors.hasFieldErrors("KullaniciAdi")){                             
					boolean valid = kayitModel.getKullaniciAdi().matches("^[\u0000-\u0080]+$");
					if(!valid){
						errors.rejectValue("KullaniciAdi", "label.turkcekarakter"); 
					}
				} 
			}

			if(!errors.hasFieldErrors("KullaniciAdi")) {
				Boolean havewhitespace=false; 
				 for(int i = 0; i < kayitModel.getKullaniciAdi().length(); i++){
			            if(Character.isWhitespace(kayitModel.getKullaniciAdi().charAt(i))){
			            	havewhitespace=true;
			            }
			        }
				 if(havewhitespace==true){
					 errors.rejectValue("KullaniciAdi", "label.bosluk");
				 }				 
			}
		}
}
