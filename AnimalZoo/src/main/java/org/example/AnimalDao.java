package org.example;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class AnimalDao {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("rt");

    static BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));

    public static void createanimal() throws IOException {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();

        Animal animal=new Animal();

        System.out.println("Enter name of animal");
        String name=sc.readLine();
        animal.setName(name);
        System.out.println("Enter age");
       int age=Integer.parseInt(sc.readLine());
       animal.setAge(age);

        System.out.println("Enter type");
        String type=sc.readLine();
        animal.setType(type);

        System.out.println("Enter zoo id");
        int id=Integer.parseInt(sc.readLine());

        Zoo zoo=em.find(Zoo.class,id);
        animal.setZoo(zoo);

        em.persist(animal);



        em.getTransaction().commit();
        em.close();
        System.out.println("Animal insertion done");
    }

    public static void delete() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        System.out.println("Enter animal id::");
        int id=Integer.parseInt(sc.readLine());
        Animal animal=em.find(Animal.class,id);

        em.remove(animal);

        em.getTransaction().commit();
        em.close();
        System.out.println("Deletion done!!");


    }

    public static void updateAnimal() throws IOException {
        EntityManager em= emf.createEntityManager();
        System.out.println("Enter ID:");
        int id = Integer.parseInt(sc.readLine());
        System.out.println("Enter Updated Name:");
        String name=sc.readLine();


      em.getTransaction().begin();

        Animal animal= em.find(Animal.class,id);
       animal.setName(name);
      em.merge(animal);

        em.getTransaction().commit();
        em.close();



    }
    public static void findbyage()
    {
        EntityManager em= emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Animal>cq=cb.createQuery(Animal.class);
        Root<Animal>root=cq.from(Animal.class);
        cq.select(root);
        cq.where(cb.between(root.get("age"),2,7));

        TypedQuery<Animal>query= em.createQuery(cq);
        List<Animal>result=query.getResultList();
        for(Animal a:result)

        {
            System.out.println(a);
        }

        em.getTransaction().commit();
        em.close();


    }

    public static void findbycategory() throws IOException {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("Enter category");
        String type=sc.readLine();

        TypedQuery<Animal>query=em.createQuery("Select a from Animal a where a.type=:type",Animal.class);

        query.setParameter("type",type);
        List<Animal>a=query.getResultList();


        for(Animal animal:a)
        {
            System.out.println(a);
        }
        em.getTransaction().commit();
        em.close();
    }






    public static void findbyname()
    {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Animal>cq=cb.createQuery(Animal.class);

        Root<Animal> root=cq.from(Animal.class);

        cq.select(root);

        cq.where(cb.like(root.get("name"), "Z%"));


        TypedQuery<Animal>query=em.createQuery(cq);


        List<Animal> result=query.getResultList();


        for(Animal a:result)
        {
            System.out.println(a);
        }

        em.getTransaction().commit();
        em.close();


    }
}
