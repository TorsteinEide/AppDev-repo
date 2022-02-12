package no.ntnu.Connectionjdbc.controllers;

import no.ntnu.Connectionjdbc.Book;
import no.ntnu.Connectionjdbc.JdbcConnection;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class represents a book controller
 */
@RestController
public class BookController
{
    private Book book;
    private JdbcConnection connection;

    public BookController()
    {
        this.connection = JdbcConnection.getInstance();
    }

    /**
     * Sends the entire register of books
     */
    @GetMapping("/books")
    public ResponseEntity<List<String>> getBooks()
    {
        ResponseEntity<List<String>> response;
        try{
            response = new ResponseEntity<>(this.connection.getBooks("SELECT * FROM books"), HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    /**
     * adds a book to the database
     */
    @PostMapping("/books")
    public void addBook(int bookID, String title, String publisher, String releaseDate, int isbn, int branchID)
    {
        this.connection.addBook(bookID, title, publisher, releaseDate, isbn, branchID);
    }
}
