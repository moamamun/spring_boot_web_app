package com.springframework.springwebapp.bootstrap;

import com.springframework.springwebapp.model.Author;
import com.springframework.springwebapp.model.Book;
import com.springframework.springwebapp.model.Publisher;
import com.springframework.springwebapp.repositories.AuthorRepo;
import com.springframework.springwebapp.repositories.BookRepo;
import com.springframework.springwebapp.repositories.PubRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


// Spring managed component
@Component

// implements the run method (author, book)
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;
    private final PubRepo pubRepo;

    public BootStrapData(AuthorRepo authorRepo, BookRepo bookRepo, PubRepo pubRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.pubRepo = pubRepo;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher pub = new Publisher();
        pub.setName("Vaughn Vernon");
        pub.setState("NY");
        pub.setCity("New York City");

        pubRepo.save(pub);
        System.out.println("Publisher Count: " + pubRepo.count());
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBook().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPub(pub);
        pub.getBooks().add(ddd);



        //Using repo to save them (using hibernate to save them in memory h2a)
        authorRepo.save(eric);
        bookRepo.save(ddd);
        pubRepo.save(pub);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23452341");
        rod.getBook().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPub(pub);
        pub.getBooks().add(noEJB);

        authorRepo.save(rod);
        bookRepo.save(noEJB);
        pubRepo.save(pub);

        System.out.println("Number of Books: " + bookRepo.count());
        System.out.println("Publishers: " + pub.getBooks().size());
    }
}
