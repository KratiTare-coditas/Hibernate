package org.example;

import javax.persistence.*;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class LibraryDao {
    public static EntityManagerFactory emf= Persistence.createEntityManagerFactory("rt");

    public static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
    public static void createlib() throws IOException {
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();
        Library library=new Library();

        System.out.println("Enter library name");
        String name=sc.readLine();
        library.setLibraryname(name);

        em.persist(library);
        em.getTransaction().commit();
        em.close();

    }
    public static void update() throws IOException {
        EntityManager em=emf.createEntityManager();
        System.out.println("Enter lib id");
        int id=Integer.parseInt(sc.readLine());

        System.out.println("Enter new lib name");
        String name=sc.readLine();

        Query query=em.createQuery("UPDATE Library SET l.name=:name where l.id=:id");
        query.executeUpdate();

        em.getTransaction().commit();
        em.close();
        System.out.println("Updation done!!");

    }

    public static void delete() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter id");
        int id=Integer.parseInt(sc.readLine());

        Library library=em.find(Library.class,id);
        em.remove(library);


        em.getTransaction().commit();
        em.close();



    }

    public static  void libraryrecords()
    {
        EntityManager em=emf.createEntityManager();

        em.getTransaction().begin();
        List<Library> libraryList=em.createQuery("Select from Library l").getResultList();

        for(Library b:libraryList)
        {
            System.out.println("LIBRARYNAME::"+b.getLibraryname());
        }


        em.getTransaction().commit();

        em.close();

    }
}
