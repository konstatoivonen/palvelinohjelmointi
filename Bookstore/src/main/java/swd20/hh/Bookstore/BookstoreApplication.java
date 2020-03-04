package swd20.hh.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import swd20.hh.Bookstore.domain.Book;
import swd20.hh.Bookstore.domain.BookRepository;
import swd20.hh.Bookstore.domain.Category;
import swd20.hh.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			
			log.info("Create categories");
			categoryRepository.save(new Category("Action"));
			categoryRepository.save(new Category("Horror"));
			
			log.info("save a couple of books");
			bookRepository.save(new Book("testi", "testi", 1920, 20202020, 17, categoryRepository.findByName("Horror")));
			bookRepository.save(new Book("testi2", "testi2", 1921, 20202021, 18, categoryRepository.findByName("Action")));
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}
	
	

}
