package edu.akdeniz.eticaret.helpers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

public class PngByteImageGenerator {

	public byte[] doit(MultipartFile multipartimage) throws Exception{
		byte[] image=null;
				
		if(multipartimage.getContentType().equals("image/png")){
			image=multipartimage.getBytes();
		}else{
			InputStream in = new ByteArrayInputStream(multipartimage.getBytes());
			BufferedImage bimage = ImageIO.read(in);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bimage, "png", baos);
			image=baos.toByteArray();
		}		
		return image;
	}
	
}
