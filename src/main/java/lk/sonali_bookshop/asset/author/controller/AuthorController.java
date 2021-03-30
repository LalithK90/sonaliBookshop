package lk.sonali_bookshop.asset.author.controller;


import lk.sonali_bookshop.asset.author.entity.Author;
import lk.sonali_bookshop.asset.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping( "/author" )
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private String commonMethod(Model model, boolean addStatus, Author author) {
        model.addAttribute("author", author);
        model.addAttribute("addStatus", addStatus);
        return "author/addAuthor";
    }

    @GetMapping
    public String authorPage(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "author/author";
    }


    @GetMapping( "/edit/{id}" )
    public String edit(@PathVariable( "id" ) Integer id, Model model) {
        return commonMethod(model, false, authorService.findById(id));
    }

    @GetMapping( "/add" )
    public String form(Model model) {
        return commonMethod(model, true, new Author());
    }

    // Above method support to send data to front end - All List, update, edit
    //Bellow method support to do back end function save, delete, update, search

    @PostMapping( value = {"/save", "/update"} )
    public String addAuthor(@Valid @ModelAttribute Author author,
                                          BindingResult result, Model model) {
        if ( result.hasErrors() ) {
            return commonMethod(model, true, author);
        }
        authorService.persist(author);
        return "redirect:/author";
    }


    @RequestMapping( value = "/delete/{id}", method = RequestMethod.GET )
    public String delete(@PathVariable Integer id) {
        authorService.delete(id);
        return "redirect:/author";
    }


}
