package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) { //gets injected in by spring
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") //if action against url /books, this method is invoked
    public String getBooks(Model model){ //view gets copy of model

        model.addAttribute("books", bookRepository.findAll()); //if /books is called, getBooks is called and provides a model object to it
        return "books/list";
    }
}
