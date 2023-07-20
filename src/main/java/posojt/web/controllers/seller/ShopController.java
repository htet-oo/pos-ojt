package posojt.web.controllers.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import posojt.bl.dto.ShopDTO;
import posojt.bl.services.shop.ShopService;
import posojt.web.form.ShopRegister;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;
	
	@RequestMapping("/seller/shopList")
	public ModelAndView sellerUserList() {
		ModelAndView mv = new ModelAndView("sellerShopList");
		List<ShopDTO> shopList = shopService.getAllShops();
		mv.addObject("shopList", shopList);
		return mv;
	}
	
	@RequestMapping("/seller/createShop")
	public ModelAndView shopCreate() {
		ModelAndView mv = new ModelAndView("sellerShopCreate");
		mv.addObject("createShop", new ShopRegister());
		return mv;
	}
	
	
	@RequestMapping(value = "/seller/createShop/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("createShop") @Valid ShopRegister shopRegister,HttpServletRequest request,
								 BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("sellerShopCreate");
			return mv;
		}
		var logoImage = shopRegister.getLogo();
		var coverPhoto = shopRegister.getCoverPhoto();
		
	    // Save logo image
	    if (!logoImage.isEmpty()) {
	        String logoImagePath = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "img" + File.separator + "shopLogo" + File.separator;
	        String logoImageFileName = logoImage.getOriginalFilename();
	        saveFile(logoImage, logoImagePath, logoImageFileName);

	    }
	    
	    // Save cover photo
	    if (!coverPhoto.isEmpty()) {
	        String coverPhotoPath = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "img" + File.separator + "shopCoverPhoto" + File.separator;
	        String coverPhotoFileName = coverPhoto.getOriginalFilename();
	        saveFile(coverPhoto, coverPhotoPath, coverPhotoFileName);
	        
	    }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        shopRegister.setEmail(username);
	    shopService.saveShop(shopRegister);
	    mv.setViewName("redirect:/seller/shopList");
		return mv;
	}
	
	@RequestMapping("/seller/shopEdit")
	public ModelAndView shopEdit(@RequestParam int shopId) {
		System.out.println("This is from details" + shopId);
		ModelAndView mv = new ModelAndView("sellerShopEdit");
		ShopDTO shopDTO = this.shopService.searchShopById(shopId);
		ShopRegister shopRegister = new ShopRegister(shopDTO);
		mv.addObject("shopEdit", shopRegister);
		System.out.println(shopRegister.getLogo());
		System.out.println("this is forom contorller" + shopDTO.getId());
		return mv;
	}
	
	@RequestMapping(value = "/seller/shopEdit/save", method = RequestMethod.POST)
	public ModelAndView saveEditSave(@ModelAttribute("shopEdit") @Valid ShopRegister shopRegister,HttpServletRequest request,
									 BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("sellerShopDetails");
			return mv;
		}
		var logoImage = shopRegister.getLogo();
		var coverPhoto = shopRegister.getCoverPhoto();
		
	    // Save logo image
	    if (!logoImage.isEmpty()) {
	        String logoImagePath = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "img" + File.separator + "shopLogo" + File.separator;
	        String logoImageFileName = logoImage.getOriginalFilename();
	        saveFile(logoImage, logoImagePath, logoImageFileName);

	    }
	    
	    // Save cover photo
	    if (!coverPhoto.isEmpty()) {
	        String coverPhotoPath = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "img" + File.separator + "shopCoverPhoto" + File.separator;
	        String coverPhotoFileName = coverPhoto.getOriginalFilename();
	        saveFile(coverPhoto, coverPhotoPath, coverPhotoFileName);
	        
	    }
	    System.out.println("Hello from controller");
		shopService.editShop(shopRegister);
		mv.setViewName("redirect:/seller/shopList");
		return mv;
	}
	
	
	@RequestMapping("/seller/shopDetails")
	public ModelAndView shopDetails(@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerShopDetails");
		ShopDTO shopDTO = this.shopService.searchShopById(shopId);
		mv.addObject("shop", shopDTO);
		System.out.println(shopDTO.getAddress());
	
		return mv;
	}
	
	
	private void saveFile(MultipartFile file, String directoryPath, String fileName) throws IOException {
	    byte[] fileBytes = file.getBytes();
	    String filePath = directoryPath + fileName;
	    try {
	        FileOutputStream fos = new FileOutputStream(filePath);
	        fos.write(fileBytes);
	        fos.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
