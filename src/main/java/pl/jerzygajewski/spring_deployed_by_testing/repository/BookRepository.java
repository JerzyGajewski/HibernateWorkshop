package pl.jerzygajewski.spring_deployed_by_testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jerzygajewski.spring_deployed_by_testing.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findOneByTitle(String title);

    Book findOneById(Long id);
}
