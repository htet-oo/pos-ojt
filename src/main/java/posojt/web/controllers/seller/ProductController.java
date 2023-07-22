package posojt.web.controllers.seller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.bytebuddy.matcher.ModifierMatcher.Mode;
import posojt.bl.dto.CategoryDTO;
import posojt.bl.dto.ProductDTO;
import posojt.bl.dto.ProductPhotoDTO;
import posojt.bl.dto.SubCategoryDTO;
import posojt.bl.services.category.CategoryService;
import posojt.bl.services.product.ProductService;
import posojt.bl.services.productPhoto.ProductPhotoService;
import posojt.bl.services.subcategory.SubCategoryService;
import posojt.persistence.entity.Category;
import posojt.persistence.entity.ProductPhoto;
import posojt.persistence.entity.SubCategory;
import posojt.web.form.ProductImage;
import posojt.web.form.ProductRegister;
import posojt.web.form.ShopRegister;

@Controller
public class ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductPhotoService productPhotoService;
	
	@RequestMapping("/seller/productCreate")
	public ModelAndView createProduct(@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerProductCreate");
		ProductRegister productRegister = new ProductRegister();
		productRegister.setShopId(shopId);
		mv.addObject("productCreate", productRegister);
		List<CategoryDTO> categoryList = categoryService.getAllCategories();
		List<SubCategoryDTO> subCategoryList = subCategoryService.getAllSubCategories();
		mv.addObject("categories", categoryList);
		mv.addObject("subcategories", subCategoryList);
		return mv;
	}
	
	@RequestMapping(value = "/seller/productCreate/save", method = RequestMethod.POST)
	public ModelAndView createProductSave(@ModelAttribute("productCreate") @Valid  ProductRegister productRegister,HttpServletRequest request,
									 BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("sellerProductCreate");
			return mv;
		}
		productService.saveProduct(productRegister);
		mv.setViewName("redirect:/seller/shopList");
		return mv;
	}
	
	@RequestMapping("/seller/productList")
	public ModelAndView productList(@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerProductList");
		List<ProductDTO> productDtoList = productService.findProductByShop(shopId);
		mv.addObject("shopId", shopId);
		mv.addObject("productList", productDtoList);
		return mv;
	}
	
	@RequestMapping("/seller/product/addImage")
	public ModelAndView productAddImage(@RequestParam int productId,@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerProductAddImage");
		ProductImage productImage = new ProductImage();
		productImage.setProduct_id(productId);
		productImage.setShopId(shopId);
		mv.addObject("productImage", productImage);
		return mv;
	}
	
	@RequestMapping(value = "/seller/product/addImage/save", method = RequestMethod.POST)
	public ModelAndView addImageSave(@ModelAttribute("productImage") @Valid ProductImage productImage,HttpServletRequest request,
									 BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("sellerProductAddImage");
			return mv;
		}
		
		var image = productImage.getPhoto();
	    if (!image.isEmpty()) {
	        String productImagePath = request.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources" + File.separator + "img" + File.separator + "productImage" + File.separator;
	        String productImageFileName = image.getOriginalFilename();
	        System.out.println(productImagePath);
	        saveFile(image, productImagePath, productImageFileName);
	    }
		productPhotoService.saveImage(productImage);
		mv.addObject("shopId", productImage.getShopId());
		mv.setViewName("redirect:/seller/productList");
		return mv;
	}
	
	@RequestMapping("/product/productDetails")
	public ModelAndView productDetails(@RequestParam int productId,@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerProductDetails");
		ProductDTO productDTO = productService.findProductByProductId(productId);
		List<ProductPhotoDTO> productPhotoDTOList = productPhotoService.findProductPhotoById(productId);
		mv.addObject("product", productDTO);
		mv.addObject("productPhotoList", productPhotoDTOList);
		mv.addObject("shopId", shopId);
		mv.addObject("productId",productId);
		return mv;
	}
	
	@RequestMapping("/product/productEdit")
	public ModelAndView productEdit(@RequestParam int productId,@RequestParam int shopId) {
		ModelAndView mv = new ModelAndView("sellerProductEdit");
		ProductDTO productDTO = productService.findProductByProductId(shopId);
		List<ProductPhotoDTO> productPhotoDTOList = productPhotoService.findProductPhotoById(productId);
		mv.addObject("productPhotoList", productPhotoDTOList);
		mv.addObject("productEdit", new ProductRegister(productDTO));
		mv.addObject("shopId", shopId);
		mv.addObject("productId",productId);
		return mv;
	}
	
	@RequestMapping(value = "/product/productEdit/save", method = RequestMethod.POST)
	public ModelAndView productEditSave(@ModelAttribute("productEdit") @Valid ProductRegister productRegister,HttpServletRequest request,
									 BindingResult result) throws IOException {
		ModelAndView mv = new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("sellerProductEdit");
			return mv;
		}
		mv.setViewName("redirect:/seller/productList");
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
