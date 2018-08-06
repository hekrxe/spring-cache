package com.simple.dao;

import com.simple.model.Book;
import com.simple.model.DataObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * User: tanhuayou
 * Date: 2018/7/28
 */
@Component
public class BookDAO {

    @Cacheable(cacheNames = "books:protostuff", key = "#isbn")
    public Book getByIsbn(String isbn) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Book(isbn, "Some book" + isbn);
    }

    @Cacheable(cacheNames = "dataObject:protostuff", key = "#id")
    public DataObject getDataObject(String id) {
        DataObject dataObject = DataObject.buildOne();
        dataObject.setStr(id);
        try {
            Thread.sleep(1000);
            System.out.println("from device");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dataObject;
    }

}
