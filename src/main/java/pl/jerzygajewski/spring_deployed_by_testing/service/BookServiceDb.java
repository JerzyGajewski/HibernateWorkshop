package pl.jerzygajewski.spring_deployed_by_testing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jerzygajewski.spring_deployed_by_testing.entity.Book;
import pl.jerzygajewski.spring_deployed_by_testing.repository.BookRepository;
import pl.jerzygajewski.spring_deployed_by_testing.service.interfaces.BookService;

import java.util.List;

@Service
public class BookServiceDb implements BookService {

    private BookRepository bookRepository;
@Autowired
    public BookServiceDb(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findOneByTitle(String title) {
        return bookRepository.findOneByTitle(title);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public Book findOneById(Long id) {
        return this.bookRepository.findOneById(id);
    }

    @Override
    public void delete(Book book) {

    }
}
