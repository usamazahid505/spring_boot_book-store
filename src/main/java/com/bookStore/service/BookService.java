package com.bookStore.service;

import com.bookStore.entity.Book;
import com.bookStore.reposiotry.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book book){
        bRepo.save(book);
    }

    public List<Book> getAllBooks(){
        return  bRepo.findAll();
    }

}
