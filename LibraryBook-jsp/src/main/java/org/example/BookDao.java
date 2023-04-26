package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("rt");
    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

    public static void create() throws IOException {

        EntityManager em= emf.createEntityManager();
       Book book=new Book();

        em.getTransaction().begin();
        System.out.println("Enter library id");
       int libid= Integer.parseInt(sc.readLine());
       // library.setId(libid);

        System.out.println("Enter book name");
        String bookname=sc.readLine();
        book.setName(bookname);

        System.out.println("Enter book price");
        int price=Integer.parseInt(sc.readLine());
        book.setPrice(price);

        System.out.println("Enter publication name");
        String pubname=sc.readLine();
        book.setPublishername(pubname);

        System.out.println("Enter publication date");
        String pubdate=sc.readLine();
        book.setPublicationdate(pubdate);

        Library library = em.find(Library.class,libid);

        List<Book> books = new ArrayList<Book>();

        book.setLibrary(library);
        library.setBooks(books);
        em.persist(book);

        em.getTransaction().commit();
        em.close();

    }


    public static void retrieve(){

        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Book> books = entityManager.createQuery("Select b from Book b",Book.class).getResultList();

        entityManager.getTransaction().commit();

        for(Book b:books){

            System.out.println("ID:"+b.getId());
            System.out.println("NAME:" + b.getName());
            System.out.println("PRICE: Rs."+b.getPrice());
            System.out.println("PUBLISHER:"+b.getPublishername());
            System.out.println("------------------------");
        }
        System.out.println("");
    }

    public static void update() throws IOException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter book id");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter u want to update in book(name,price,publishername");
        String attribute = sc.readLine();
        switch (attribute.toLowerCase()) {

            case "name":
                System.out.println("Enter name to be updated");
                String newname = sc.readLine();
                String jpql = "UPDATE Book b SET b.name = :newName WHERE b.id = :id";
                Query query = em.createQuery(jpql);
                query.setParameter("newName", newname);
                query.setParameter("id", id);
                query.executeUpdate();
                em.getTransaction().commit();
                em.close();
                System.out.println("Updation done!");
                break;
            case "price":
                System.out.println("Enter new price");
                int price=Integer.parseInt(sc.readLine());
                String jpql1="UPDATE BOOK SET b.price=:price where b.id=:id";
                Query query1=em.createQuery(jpql1);
                query1.setParameter("price",price);
                query1.setParameter("id",id);
                query1.executeUpdate();
                em.getTransaction().commit();
                em.close();
                System.out.println("Updation done");

                break;
        }
    }

        public static void delete() throws IOException {

            EntityManager em=emf.createEntityManager();
            em.getTransaction().begin();
            System.out.println("Enter book id");
            int id=Integer.parseInt(sc.readLine());
            Book book=em.find(Book.class,id);

            em.remove(book);
            em.getTransaction().commit();
            em.close();


        }
    }

