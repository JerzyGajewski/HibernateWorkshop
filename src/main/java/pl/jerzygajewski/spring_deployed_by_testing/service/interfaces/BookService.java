package pl.jerzygajewski.spring_deployed_by_testing.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jerzygajewski.spring_deployed_by_testing.entity.Book;

import java.util.List;

public interface BookService{

    Book findOneByTitle(String title);

    List<Book> findAll();

    void save(Book book);

    Book findOneById(Long id);

    void delete(Book book);
}
