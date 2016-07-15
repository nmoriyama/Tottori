package library.controller;

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
import library.dto.RentalDto;
import library.form.BookForm;
import library.form.RentalForm;
import library.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    
    //図書登録
    @RequestMapping(value = "/bookRegister", method = RequestMethod.GET)
    public String bookInsert(Model model) {
        BookForm form = new BookForm();
        model.addAttribute("bookForm", form);
        List<LibraryDto> library = bookService.library();
        model.addAttribute("Library", library);
        //model.addAttribute("message", "");
        return "bookRegister";
    }
    
    @RequestMapping(value = "/bookRegister", method = RequestMethod.POST)
    public String bookInsert(@ModelAttribute BookForm form, Model model) {
    	BookDto dto = new BookDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = bookService.insert(dto);
    	model.addAttribute("bookForm", form);
        //model.addAttribute("message", "");
        return "bookRegister";
    }
    
    //貸出
    @RequestMapping(value = "/lendBook", method = RequestMethod.GET)
    public String lendBook(Model model) {
    	RentalForm form = new RentalForm();
        
        List<LibraryDto> library = bookService.library();
        model.addAttribute("rentalForm", form);
        model.addAttribute("Library", library);
        //model.addAttribute("message", "");
        return "lendBook";
    }
    
    @RequestMapping(value = "/lendBook", method = RequestMethod.POST)
    public String lendBook(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = bookService.rental(dto);
    	model.addAttribute("bookForm", form);
        //model.addAttribute("message", "");
        return "redirect:/lendBook";
    }
    
    //返却
    @RequestMapping(value = "/returnBook", method = RequestMethod.GET)
    public String returnBook(Model model) {
    	RentalForm form = new RentalForm();//rentalテーブル以外
        List<LibraryDto> library = bookService.library();
        model.addAttribute("Library", library);
        model.addAttribute("rentalForm", form);
        //model.addAttribute("message", "");
        return "returnBook";
    }
    
    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public String returnBook(@ModelAttribute RentalForm form, Model model) {
    	RentalDto dto = new RentalDto();
    	BeanUtils.copyProperties(form, dto);
    	List<String> messages = bookService.returnBook(dto);
        //model.addAttribute("message", "");
        return "redirect:/returnBook";
    }
}
