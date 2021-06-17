package com.example.demo.controllers;

import com.example.demo.daos.BookDao;
import com.example.demo.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @RequestMapping(value = "/create")
    public Book create() {
        var book = new Book();
        book.setId(1L);
        book.setName("Flyway 정복하기");
        book.setAuthor("구태균");

        bookDao.save(book);

        return book;
    }
}
