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
import swd20.hh.Bookstore.domain.User;
import swd20.hh.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository urepository) {
		return (args) -> {
			
			
			log.info("Create categories");
			categoryRepository.save(new Category("Action"));
			categoryRepository.save(new Category("Horror"));
			
			log.info("save a couple of books");
			bookRepository.save(new Book("testi", "testi", 1920, 20202020, 17, categoryRepository.findByName("Horror")));
			bookRepository.save(new Book("testi2", "testi2", 1921, 20202021, 18, categoryRepository.findByName("Action")));
			
			User user1 = new User("user", "$2a$10$qBepAmt6i9ZWjoWuuiQI1eH6MsMKgPRHQjuUXqYU5CCHr.Ik3.0bC", "USER");
			User user2 = new User("admin", "$2a$10$wJTcqkU0a5CWtbZJbHbWr.9/evo/OHICOEBXY.vTVVQoeoi0iSVyG", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		
		};
	}

}
