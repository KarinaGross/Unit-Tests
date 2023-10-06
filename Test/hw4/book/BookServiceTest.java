package hw4.book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BookServiceTest {
    //    У вас есть класс BookService, который использует интерфейс BookRepository для получения
//    информации о книгах из базы данных. Ваша задача написать unit-тесты для BookService,
//    используя Mockito для создания мок-объекта BookRepository.

    private BookService bookService;
    private BookRepository mockBookRepository;

    @BeforeEach
    public void setUp() {
        mockBookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(mockBookRepository);
    }

    @Test
    public void testFindBookById() {
        Book mockBook = new Book("1", "MockBook", "MockAuthor");

        when(mockBookRepository.findById("1")).thenReturn(mockBook);

        Book foundBook = bookService.findBookById("1");

        assertNotNull(foundBook);
        assertEquals(mockBook.getId(), foundBook.getId());
        assertEquals(mockBook.getTitle(), foundBook.getTitle());
        assertEquals(mockBook.getAuthor(), foundBook.getAuthor());
    }

    @Test
    public void testFindAllBooks() {
        List<Book> mockBooks = Arrays.asList(
                new Book("1", "MockBook1", "MockAuthor1"),
                new Book("2", "MockBook2", "MockAuthor2")
        );

        when(mockBookRepository.findAll()).thenReturn(mockBooks);

        List<Book> foundBooks = bookService.findAllBooks();

        assertNotNull(foundBooks);
        assertEquals(2, foundBooks.size());
        assertEquals(mockBooks, foundBooks);
    }
}