package com.example.demo.model;

import com.example.demo.ResetDatabase;
import com.example.demo.daos.BookDao;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookTest extends ResetDatabase {

    @Autowired
    private BookDao bookDao;
    Logger logger = LoggerFactory.getLogger(ResetDatabase.class);
    @Test
    void createSuccess() {
        logger.info("book 생성 테스트");
        Book book = new Book();
        long id = 1L;
        book.setId(id);
        book.setName("Flyway 정복하기");
        book.setAuthor("구태균");
        bookDao.save(book);

        Book findBook = bookDao.findById(id).orElseThrow(IllegalArgumentException::new);

        assertThat(findBook.getId()).isEqualTo(book.getId());
        assertThat(findBook.getName()).isEqualTo(book.getName());
        assertThat(findBook.getAuthor()).isEqualTo(book.getAuthor());
    }
}
