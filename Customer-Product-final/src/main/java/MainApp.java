import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Product product = new Product();
        product.setId(1);
        product.setName("Laptop");
        product.setPrice(3000);

        Product product1 = new Product();
        product1.setId(2);
        product1.setName("Mobile");
        product1.setPrice(5000);

        Product product2 = new Product();
        product2.setId(3);
        product2.setName("TV");
        product2.setPrice(7000);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(product);
        session.save(product1);
        session.save(product2);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
