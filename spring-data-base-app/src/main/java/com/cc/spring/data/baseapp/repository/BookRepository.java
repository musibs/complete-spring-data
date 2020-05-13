package com.cc.spring.data.baseapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.cc.spring.data.baseapp.model.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

}
