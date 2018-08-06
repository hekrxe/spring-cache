package com.simple.main;

import com.simple.dao.BookDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * User: tanhuayou
 * Date: 2018/7/28
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.simple.dao", "com.simple.config"})
public class SpringCacheMain implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringCacheMain.class);
    @Autowired
    private BookDAO bookDAO;


    public static void main(String[] args) {
        SpringApplication.run(SpringCacheMain.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 3; ++i) {
            logger.info(".... Fetching books ...." + i);
            fetch();
        }
    }

    private void fetch() {
        System.out.println(bookDAO.getDataObject("isbn-12341"));
        System.out.println(bookDAO.getDataObject("isbn-45672"));
        System.out.println(bookDAO.getDataObject("isbn-12343"));
        System.out.println(bookDAO.getDataObject("isbn-45674"));
        System.out.println(bookDAO.getDataObject("isbn-12345"));
        System.out.println(bookDAO.getDataObject("isbn-12346"));
    }
}
