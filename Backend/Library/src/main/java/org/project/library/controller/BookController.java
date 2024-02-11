package org.project.library.controller;

import org.project.library.entity.Book;
import org.project.library.responsemodels.ShelfCurrentLoansResponse;
import org.project.library.service.BookService;
import org.project.library.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://localhost:3000")
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @PutMapping("/secure/checkout")
    public Book checkoutBook(@RequestHeader(value = "Authorization")String token,@RequestParam Long bookId) throws Exception{
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        return bookService.checkoutBook(userEmail,bookId);
    }
    @GetMapping("/secure/currentloans")
    public List<ShelfCurrentLoansResponse> currentLoans(@RequestHeader(value = "Authorization")String token) throws Exception{
        String userEmail =ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        return bookService.currentLoans(userEmail);
    }
    @GetMapping("/secure/ischeckedout/byuser")
    public Boolean checkoutBookByUser(@RequestHeader(value = "Authorization")String token,@RequestParam Long bookId){
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        return bookService.checkoutBookByUser(userEmail,bookId);
    }
    @GetMapping("/secure/currentloans/count")
    public int currentLoansCount(@RequestHeader(value = "Authorization")String token){
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        return bookService.currentLoansCount(userEmail);
    }
    @PutMapping("/secure/return")
    public void returnBook(@RequestHeader(value = "Authorization")String token,
                           @RequestParam Long bookId) throws Exception{
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        bookService.returnBook(userEmail,bookId);
    }
    @PutMapping("/secure/renew/loan")
    public void renewLoan(@RequestHeader(value = "Authorization")String token,
                          @RequestParam Long bookId) throws Exception{
        String userEmail = ExtractJWT.payLoadJWTExtraction(token,"\"sub\"");
        bookService.renewLoan(userEmail,bookId);
    }
}
