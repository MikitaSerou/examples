import config.AppConfig;
import data.entity.Author;
import data.entity.Book;
import data.service.AbstractService;
import data.service.AuthorService;
import data.service.BookService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


    AbstractService bookService = context.getBean("bs", BookService.class);
        AbstractService authorService = context.getBean("as", AuthorService.class);

        System.out.println(bookService.findOne(1L));
        System.out.println(authorService.findOne(1L));




        List<Book> books = bookService.list();
        for (Book book : books) {
            System.out.println("Id = "+book.getId());
            System.out.println("Authors = " + book.getAuthors());
        }


        List<Author> authors = authorService.list();
        for (Author author : authors) {
            System.out.println("Id = "+author.getId());
            System.out.println("Books = "+author.getBooks());

        }
//
//        List<Book> booksByName = bookService.findByName("faiRy taLes");
//        for (Book book : booksByName) {
//            System.out.println("Id = "+book.getId());
//            System.out.println("Name: " + book.getName());
//            System.out.println("Authors = " + book.getAuthors());
//        }
//
//        List<Author> authorsByName = authorService.findByName("j. oRuEl");
//        for (Author a : authorsByName) {
//            System.out.println("Id = "+a.getId());
//            System.out.println("Name: " + a.getName());
//            System.out.println("Books = " + a.getBooks());
//        }
//        context.close();
    }
}
