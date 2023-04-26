package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libraryname;

    @OneToMany(mappedBy = "library")
    private List<Book> books;
    public Library()
    {

    }

    public Library(int id, String libraryname, List<Book> books) {
        this.id = id;
        this.libraryname = libraryname;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibraryname() {
        return libraryname;
    }

    public void setLibraryname(String libraryname) {
        this.libraryname = libraryname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", libraryname='" + libraryname + '\'' +
                ", books=" + books +
                '}';
    }
}
