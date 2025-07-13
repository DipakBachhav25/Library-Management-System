package com.dipak.dipak.service;

import com.dipak.dipak.DAO.BookDao;
import com.dipak.dipak.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDao bookrepo;

    // Fetch all the books
    public List<Book> getAllBooks(){
        return bookrepo.findAll();
    }

    // Find the specific book by book ID
    public Optional<Book> getBookByID(int id){
        return bookrepo.findById(id);
    }

    // Add the book details
    public Book addBook(Book book){
        return bookrepo.save(book);
    }

    // Delete the book by book ID
    public void deleteBook(int id){
        bookrepo.deleteById(id);
    }

    public Book updateBookAvailability(int id, Boolean available){
        Optional<Book> optBook = bookrepo.findById(id);
        if(optBook.isPresent()){
            Book book = optBook.get();
            book.setAvailable(available);
            return bookrepo.save(book);
        }
        else{
            throw new RuntimeException("Book not found..");
        }
    }
}
