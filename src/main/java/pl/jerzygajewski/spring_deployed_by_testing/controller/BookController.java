package pl.jerzygajewski.spring_deployed_by_testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.jerzygajewski.spring_deployed_by_testing.entity.Book;
import pl.jerzygajewski.spring_deployed_by_testing.service.interfaces.BookService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private Validator validator;

    @Autowired
    public BookController(BookService bookService, Validator validator) {
        this.bookService = bookService;
        this.validator = validator;
    }

    @GetMapping()
    @Transactional
    public String allBooks(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "book/list";

    }

    @GetMapping("/new")
    public String bookForm(Model model) {
        Book book = new Book();
        model.addAttribute("books", book);
        return "book/form";
    }

    @PostMapping("/save")
    public String saveBook(@Valid Book book, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "book/form";
        }
        bookService.save(book);
        return "redirect:/book";
    }

    @GetMapping("/create/{name}/{surname}/{isbn}")
    @ResponseBody
    public String test(@PathVariable String name, @PathVariable String surname, @PathVariable String isbn) {
        Book person = new Book();
        person.setTitle(name);
        person.setAuthor(surname);
        person.setIsbn(isbn);
        bookService.save(person);
        return "Saved";
    }

    @GetMapping("/delete")
    @Transactional
    public String allBooksToDelete(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "book/delete";

    }
    @GetMapping("/delete/{id}")
    public String bookDelete(@PathVariable Long id, Model model,
                             @RequestParam(required = false, defaultValue = "false") boolean accept) {
        Book book = bookService.findOneById(id);
        if (!accept) {
            model.addAttribute("book", book);
            return "book/deleteForm";
        }
        bookService.delete(book);
        return "redirect:/book";
    }
}
