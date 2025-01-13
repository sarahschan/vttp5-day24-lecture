package sg.edu.nus.iss.paf_day24l.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf_day24l.models.Book;
import sg.edu.nus.iss.paf_day24l.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
    

    @Autowired
    BookRepository bookRepository;


    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBookings(){
        
        List<Book> bookings = bookRepository.getAllBooks();
        return ResponseEntity.ok().body(bookings);

    }


    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBookById(@PathVariable("book-id") int bookId) {
        
        Book foundBook = bookRepository.getBookById(bookId);
        return ResponseEntity.ok().body(foundBook);

    }


    @PostMapping("/statusupdate/{book-id}")
    public ResponseEntity<Boolean> updateBookStatus(@PathVariable("book-id") int bookId, @RequestBody Book book) {
        Boolean updateSuccessful = bookRepository.updateBookStatus(book);

        return ResponseEntity.ok().body(updateSuccessful);
    }
}
