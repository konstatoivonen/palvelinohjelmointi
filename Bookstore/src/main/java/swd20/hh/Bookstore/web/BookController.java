package swd20.hh.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import swd20.hh.Bookstore.domain.BookRepository;
import swd20.hh.Bookstore.domain.Book;

@Controller
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String listBooks() {
		return "";
	}

	
	@RequestMapping(value="/booklist", method = RequestMethod.GET)
	public String getBookList(Model model) {
		List<Book> books = (List<Book>) bookRepository.findAll();
		model.addAttribute("books", books);
		return "booklist";
	}
	
	@RequestMapping(value="/newbook", method= RequestMethod.GET)
	public String getNewBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/savebook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, Model model) {
		model.addAttribute("book", book);
		return "booklist";
	}

	

}
