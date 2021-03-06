package swd20.hh.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import swd20.hh.Bookstore.domain.BookRepository;
import swd20.hh.Bookstore.domain.CategoryRepository;
import swd20.hh.Bookstore.domain.Book;
import swd20.hh.Bookstore.domain.Category;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String index() {
		return "redirect:/booklist";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}

	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getBookList(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@RequestMapping(value="books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>)bookRepository.findAll();
	}
	
	@RequestMapping(value="/newbook", method = RequestMethod.GET)
	public String getNewBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value="/deletebook/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
		
		
	}
	
	 @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return bookRepository.findById(bookId);
	    } 

	

}
