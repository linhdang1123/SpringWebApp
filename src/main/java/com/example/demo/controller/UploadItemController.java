package com.example.demo.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Model.ItemDetails;
import com.example.demo.bean.Item;
import com.example.demo.dao.ItemDAO;
import com.example.demo.form.ItemForm;
import com.example.demo.pagination.PaginationResult;

@Controller
@Transactional
public class UploadItemController {
	@Autowired
	ItemDAO itemDAO;
	@RequestMapping(value = {"/uploadItem"})
	public String registrationForm(Model model) {
		ItemForm form = new ItemForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("itemForm", form);
		return "uploadItem";
	}
	@RequestMapping(value = { "/item_success" }, method = RequestMethod.POST)
	 public String productSave(Model model, //
	    @ModelAttribute("itemForm") @Validated ItemForm itemForm, HttpServletResponse response) throws UnsupportedEncodingException {
		System.out.println(itemForm);
	    try {
	         itemDAO.save(itemForm);
	    } catch (Exception e) {
	         Throwable rootCause = ExceptionUtils.getRootCause(e);
	         String message = rootCause.getMessage();
	         model.addAttribute("errorMessage", message);
	         System.out.println("error");
	         return "uploadItem"; 
	   }
	    int code=itemForm.getCode();
	    Item item=itemDAO.findItem(code);
	    byte[] encode = Base64.getEncoder().encode(item.getImage());
	    model.addAttribute("image", new String(encode, "UTF-8"));
	    model.addAttribute("item",item);
	    return "item_success";
	   }
	@RequestMapping(value ={ "/productlist" })
	public String displayItem(Model model, //
	         @RequestParam(value = "name", defaultValue = "") String likeName,
	         @RequestParam(value = "page", defaultValue = "1") int page, HttpServletRequest request,@ModelAttribute("cartEmpty") String message) {
		System.out.println("likeName : " +likeName + ", page :" + page);
	    final int maxResult = 8;
	    final int maxNavigationPage = 100;
	    System.out.println("uploadItem Controller");
	    PaginationResult<ItemDetails> result = itemDAO.queryProducts(page, //
	    maxResult, maxNavigationPage);
	    model.addAttribute("paginationItems", result);
	    model.addAttribute("pageNumber",page);

	    return "productlist";
	}
	@RequestMapping(value = {"/itemImage"}, method = RequestMethod.GET)
	public void itemImage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("code") int code) throws IOException {
		Item item = null;
		if(code !=  0) item = this.itemDAO.findItem(code);
		if(item != null && item.getImage() != null) {
			response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
			response.getOutputStream().write(item.getImage());
		}
		response.getOutputStream().close();	
	}
	@RequestMapping(value = {"/item"}, method = RequestMethod.GET)
	public String showItem(Model model, @RequestParam("itemcode") int code) {
		ItemDetails itemDetails = this.itemDAO.getItemDetails(code);
		if(itemDetails == null) itemDetails = new ItemDetails();
		model.addAttribute("itemDetails",itemDetails);
		return "item";
	}
	
/*	@RequestMapping(value = {"/item_success"})
	public String itemSuccess(Model model) {
		ItemForm form = new ItemForm();
		model.addAttribute("errorMessage", "");
		model.addAttribute("itemForm", form);
		return "uploadItem";
	}*/
	
 //   @Autowired
//    private FileUploadDAO fileUploadDao;
 
/*    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showUploadForm(HttpServletRequest request) {
        return "Upload";
    }*/
     
 /*   @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
          
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){
                  
                System.out.println("Saving file: " + aFile.getOriginalFilename());
                 
                Item item = new Item();
                item.setFileName(aFile.getOriginalFilename());
                item.setData(aFile.getBytes());
                fileUploadDao.save(item);               
            }
        }
  
        return "Success";
    } */

}
