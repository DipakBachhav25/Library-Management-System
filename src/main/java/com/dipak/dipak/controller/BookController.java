package com.dipak.dipak.controller;

import com.dipak.dipak.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dipak.dipak.service.BookService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookByID(@PathVariable int id){
        Optional<Book> bookOpt = bookService.getBookByID(id);
        if(bookOpt.isEmpty()){
            Map<String, Object> errRes = new HashMap<>();
            errRes.put("message", "Book ID not found");
            errRes.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
        }
        return ResponseEntity.ok(bookOpt.get());
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        if(book.getTitle() == null || book.getTitle().isEmpty()){
            Map<String, Object> errRes = new HashMap<>();
            errRes.put("message", "Book title can't be empty");
            errRes.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errRes);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id){
        Optional<Book> bookOpt = bookService.getBookByID(id);
        if(bookOpt.isEmpty()){
            Map<String, Object> errRes = new HashMap<>();
            errRes.put("message", "Book ID not found");
            errRes.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
        }
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<?> updateAvailability(@PathVariable int id, @RequestBody Boolean available){
        Optional<Book> bookOpt = bookService.getBookByID(id);
        if(bookOpt.isEmpty()){
            Map<String, Object> errRes = new HashMap<>();
            errRes.put("message", "Book ID not found");
            errRes.put("status", HttpStatus.NOT_FOUND.value());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errRes);
        }
        return ResponseEntity.ok(bookService.updateBookAvailability(id, available));
    }

}
