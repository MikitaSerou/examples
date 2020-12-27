package controller;

import data.entity.Author;
import data.entity.Book;
import data.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.NoResultException;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String authorForm(Model model) {
        model.addAttribute("authors", authorService.list());
        return "author/mainForm";
    }

    @GetMapping("/showAuthor")
    public String getAuthorId (@RequestParam("authorId") long id, Model model){
        Author author = authorService.findOne(id);
        model.addAttribute("selectedAuthor", author);

        return "author/showAuthor";
    }

    @GetMapping("/showAuthorByName")
    public String getAuthorName(@RequestParam("authorName") String name, Model model) {
        try {
            Author author = authorService.findByName(name);
            model.addAttribute("selectedAuthor", author);
        }catch (NoResultException e){
            return "author/haveNoResult";
        }
        return "author/showAuthor";
    }
}
