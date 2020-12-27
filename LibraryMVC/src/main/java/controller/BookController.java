package controller;


import data.entity.Book;
import data.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.NoResultException;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public String bookForm(Model model) {
        model.addAttribute("books", bookService.list());
        return "book/mainForm";
    }

    @GetMapping("/showBook")
    public String getBookId(@RequestParam("bookId") long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("selectedBook", book);
        if (book.getId() == null) {
            return "library";
        } else {
            return "book/showBook";
        }
    }

    @GetMapping("/showBookByName")
    public String getBookName(@RequestParam("bookName") String name, Model model) {
        try {
            Book book = bookService.findByName(name);
            model.addAttribute("selectedBook", book);
        }catch (NoResultException e){
            return "book/haveNoResult";
        }
        return "book/showBook";
    }
}
