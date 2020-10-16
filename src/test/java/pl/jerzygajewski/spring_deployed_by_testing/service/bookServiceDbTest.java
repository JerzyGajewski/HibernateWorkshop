package pl.jerzygajewski.spring_deployed_by_testing.service;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import pl.jerzygajewski.spring_deployed_by_testing.entity.Book;
import pl.jerzygajewski.spring_deployed_by_testing.service.interfaces.BookService;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@ComponentScan
public class bookServiceDbTest {

    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private BookService bookService;

//    @Before
//    public Book setUp() {
//        Book book = new Book();
//        book.setTitle("Java");
//        book.setIsbn("1234");
//        book.setAuthor("adam nowak");
//        return book;
//    }

    @Test
    public void shouldBeAbleToCreateBook() {
        Book book = new Book();
        book.setTitle("Java");
        book.setIsbn("1234");
        book.setAuthor("adam nowak");
        assertNotNull(book);
    }

private List<Book> bookList;

    @Before
    public void setUp(){
         bookList = List.of(new Book("The return", "1234567", "Nicholas Sparks"),
                new Book("A Time For Mercy", "7654321", "John Grisham"),
                new Book("The Searcher", "9876543", "Tana French"),
                new Book("Leave the word behind", "9201837", "Rumaan Alam"));

    }
    @Test
    public void shouldBeAbleToFindBookByTitle() {
        bookList.forEach(book -> testEntityManager.persist(book));
        Book book = bookService.findOneByTitle("The Searcher");

        assertTrue(bookList.contains(book));
    }

    @Test(expected = NullPointerException.class)
    public void shouldNotBeAbleToFindBookWithWrongTitle(){
        bookList.forEach(book -> testEntityManager.persist(book));

        Book book = bookService.findOneByTitle("rearcher");

        assert(bookList.contains(book));

    }
}
