package com.example.Bookstore;

import com.example.Bookstore.controller.APIController;
import com.example.Bookstore.controller.BookController;
import com.example.Bookstore.controller.UserController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookstoreApplicationTests {

	@Autowired
	private APIController apiController;

	@Autowired
	private BookController bookController;

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		assertThat(apiController).isNotNull();
		assertThat(bookController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
