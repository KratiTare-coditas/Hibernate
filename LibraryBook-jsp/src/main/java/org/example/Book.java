package org.example;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String publishername;
    private int price;
    private String publicationdate;

    @ManyToOne
    private Library library;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishername() {
        return publishername;
    }

    public void setPublishername(String publishername) {
        this.publishername = publishername;
    }

    public String getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(String publicationdate) {
        this.publicationdate = publicationdate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }




    public Book()
    {

    }

    public Book(int id, String name, String publishername, int price, String publicationdate, Library library) {
        this.id = id;
        this.name = name;
        this.publishername = publishername;
        this.price = price;
        this.publicationdate = publicationdate;
        this.library = library;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishername='" + publishername + '\'' +
                ", price=" + price +
                ", publicationdate='" + publicationdate + '\'' +
                ", library=" + library +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
