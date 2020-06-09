package com.springframework.springwebapp.repositories;

import com.springframework.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Long> {

}
