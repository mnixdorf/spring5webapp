package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) { //gets injected in by spring
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors") //if action against url /authors, this method is invoked
    public String getAuthors(Model model) { //view gets copy of model

        model.addAttribute("authors", authorRepository.findAll()); //if /authors is called, getBooks is called and provides a model object to it
        return "authors/list"; //looks for books in the template/authors/list file
    }
}
