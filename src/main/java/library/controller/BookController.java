package library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import library.dto.BookDto;
import library.dto.LibraryDto;
import library.dto.MypageRentalDto;
import library.dto.RentalDto;
import library.dto.StatusDto;
import library.form.BookForm;
import library.form.RentalForm;
import library.form.UserForm;
import library.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    
    //図書登録 重複確認　既に登録されています
    @RequestMapping(value = "/bookRegister", method = RequestMethod.GET)
    public String bookInsert(Model model) {
        BookForm form = new BookForm();
        //各図書館の名前を持ってくる
        List<LibraryDto> library = bookService.library();
        model.addAttribute("bookForm", form);
        model.addAttribute("Library", library);
        return "bookRegister";
    }
    
    @RequestMapping(value = "/bookRegister", method = RequestMethod.POST)
    public String bookInsert(@ModelAttribute BookForm form, Model model) {

        List<LibraryDto> library = bookService.library();
        BookForm bookForm = new BookForm();
        model.addAttribute("Library", library);
        model.addAttribute("bookForm", form);
        /*	if (result.hasErrors()) {
    	
            return "bookRegister";
    	} else */{

	    		BookDto dto = new BookDto();
	    		BeanUtils.copyProperties(form, dto);
	    		List<String> messages = bookService.bookCheck(dto);
	    		if (messages.size() == 0) {
	    			bookService.insert(dto);
	    			model.addAttribute("bookForm", bookForm);
	    		}
  
    		model.addAttribute("messages", messages);
    		return "bookRegister";
    	}
    }
    
    
    
    //返却
    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String returnBook(Model model) {
    	RentalForm form = new RentalForm();//rentalテーブル以外
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        return "returnBook";
    }
    
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(@ModelAttribute RentalForm form, Model model) {

    	List<LibraryDto> library = bookService.library();
    	model.addAttribute("Library", library);
    	RentalDto dto = new RentalDto();
		
    	BeanUtils.copyProperties(form, dto);

    	//入力した本があるか
    	for (int i = 0; i < dto.getIsbn().length; i++) {
	    	BookDto lend = bookService.lendConfirm(dto, dto.getIsbn()[i]);
	    	if (lend == null) {
	    		model.addAttribute("messages", "図書が見つかりません");
	    		return "returnBook";
	    	}
	    	if (lend.getStatusId() != 2) {
	    		model.addAttribute("messages", "返却済みです");
	    		return "returnBook";
	    	}
    	}

    	//返却実行(複数)
    	 
    	 bookService.returnBook(dto, dto.getIsbn().length);
    	 //bookテーブルのステータスを3に
    	 bookService.updateStatus(3, dto, dto.getIsbn().length);
    	 model.addAttribute("messages", "返却完了しました");
    	return "redirect:/returnBook";
    }
    
    //ステータス変更
    @RequestMapping(value = "/changeStatus", method = RequestMethod.GET)
    public String changeStatus(Model model) {
    	BookForm form = new BookForm();
    	List<StatusDto> status = bookService.status();
    	List<LibraryDto> library = bookService.library();
    	model.addAttribute("Status", status);
    	model.addAttribute("Library", library);
    	model.addAttribute("bookForm", form);
        return "changeStatus";
    }
    
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public String changeStatus(@ModelAttribute BookForm form, Model model) {
    	BookDto dto = new BookDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = new ArrayList<String>();
    	
    	bookService.changeStatus(dto);
    	
    	messages.add("ステータスを変更しました");
    	BookForm nextForm = new BookForm();
    	List<StatusDto> status = bookService.status();
    	List<LibraryDto> library = bookService.library();
    	model.addAttribute("Status", status);
    	model.addAttribute("Library", library);
    	model.addAttribute("bookForm", nextForm);
    	model.addAttribute("messages", messages);
    	return "changeStatus";
    }
    
    //時間変更
    @RequestMapping(value = "/changeTime", method = RequestMethod.GET)
    public String changeTime(Model model) {
    	UserForm form = new UserForm();
    	model.addAttribute("userForm", form);
        return "changeTime";
    }
    
    //本管理
    @RequestMapping(value = "/bookManagement", method = RequestMethod.GET)
    public String bookManagement(Model model) {
        List<BookDto> book = bookService.bookManagement();
        List<MypageRentalDto> rental = bookService.rentalManagement();
    	RentalForm rentalForm = new RentalForm();
        model.addAttribute("rentalForm", rentalForm);
        model.addAttribute("Books", book);
        model.addAttribute("Rental", rental);
        return "bookManagement";
    }
    
    @RequestMapping(value = "/bookManagement", method = RequestMethod.POST)
    public String bookManagement(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	bookService.changeDate(dto);
    	
    	return "redirect:/bookManagement";
    }
 
}
