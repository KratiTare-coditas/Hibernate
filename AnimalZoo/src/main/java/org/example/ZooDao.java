package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZooDao {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("rt");

    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

    public static void createZoo() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Zoo zoo=new Zoo();
        System.out.println("Enter zoo name");
        String name=sc.readLine();
        zoo.setName(name);

        System.out.println("Enter city of zoo");
        String city=sc.readLine();
        zoo.setCity(city);
        em.persist(zoo);
        em.getTransaction().commit();
        em.close();

        System.out.println("Insertion done of zoo");

    }

    public static void deletezoo() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter zoo id::");
        int id=Integer.parseInt(sc.readLine());
        Zoo zoo=em.find(Zoo.class,id);

        em.remove(zoo);

        em.getTransaction().commit();
        em.close();
        System.out.println("Deletion done!!");


    }

    public static void updatezoo() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter zoo id");
        int id=Integer.parseInt(sc.readLine());
        System.out.println("Enter zoo name");
        String name=sc.readLine();


        Zoo zoo=em.find(Zoo.class,id);

        zoo.setName(name);
        em.merge(zoo);

        em.getTransaction().commit();
        em.close();



    }

}
