package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public  class Query {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rt");

//    public static void Query1() {
//        EntityManager entityManager = emf.createEntityManager();
//
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Root<Book> root = cq.from(Book.class);
//        cq.select(root).where(cb.greaterThan(root.get("price"), 500));
//        TypedQuery<Book> query = entityManager.createQuery(cq);
//        List<Book> books = query.getResultList();
//        for (Book b : books) {
//            System.out.println("Name: " + b.getName());
//            System.out.println("Price: " + b.getPrice());
//            System.out.println("------------------------");
//        }
//
//
//
//    }

    public static void Query2() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        TypedQuery<Book> query = entityManager.createQuery(cq);
        List<Book> books = query.getResultList();

        entityManager.getTransaction().commit();

        for (Book b : books) {

            System.out.println("NAME:" + b.getName());
            System.out.println("PUBLISHER:" + b.getPublishername());
            System.out.println("------------------------");
        }
        System.out.println("");
    }

//    public static void Query3() {
//
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Root<Book> root = cq.from(Book.class);
//        cq.select(root).where(cb.between(root.get("price"), 200, 400));
//        List<Book> books = entityManager.createQuery(cq).getResultList();
//
//        for (Book b : books) {
//
//            System.out.println("NAME:" + b.getName());
//            System.out.println("PRICE:" + b.getPrice());
//            System.out.println("------------------------");
//        }
//        System.out.println("");
//    }

    public static List<Book> getBooksByPriceGreaterThan(int price) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);

        cq.select(root).where(cb.greaterThan(root.<Comparable>get("price"),price));
        TypedQuery<Book> query = entityManager.createQuery(cq);

        List<Book> resultList = query.getResultList();
        for(Book book :resultList){
            System.out.println(book.getId()+" : "+book.getPrice()+" : "+book.getName());
        }


        entityManager.getTransaction().commit();
        entityManager.close();

        return resultList;
    }


    public static void getpriceinBetween()
    {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Book>cq= cb.createQuery(Book.class);
        Root<Book>root= cq.from(Book.class);

        cq.select(root).where(cb.between(root.<Comparable>get("price"),200,500));
        TypedQuery<Book>query=em.createQuery(cq);
        List<Book>resultlist=query.getResultList();
        for(Book book:resultlist)
        {
            System.out.println(book.getId()+""+book.getName()+""+book.getPrice());

        }
        em.getTransaction().commit();
        em.close();
    }





}