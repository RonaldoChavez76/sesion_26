package mx.utng.s26.sesion26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import mx.utng.s26.sesion26.model.entity.Book;
import mx.utng.s26.sesion26.model.service.IBookService;

@Controller
@SessionAttributes("book")
public class BookController {
    @Autowired
    private IBookService service;

    @GetMapping({"/book", "/book/", "/book/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de libros");
        model.addAttribute("books", service.list());
        return "book-list";
    }

    @GetMapping("/book/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de libros");
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/book/form")
    public String save(@Valid Book book, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de libros");
            return "book-form";
        }
        service.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/book/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Book book = null;
        if(id>0){
            book = service.getById(id);
        }else{
            return "redirect:/book/list";
        }
        model.addAttribute("title", "Editar libro");
        model.addAttribute("book", book);
        return "book-form";
    }

    @GetMapping("/book/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            service.delete(id);
        }
        return "redirect:/book/list";
    }
    
}
