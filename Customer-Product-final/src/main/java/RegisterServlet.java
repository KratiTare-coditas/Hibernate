import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
     static Configuration configuration=new Configuration().configure();
    static SessionFactory sessionFactory= configuration.buildSessionFactory();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");


        Customer customer=new Customer();
        customer.setName(name);
        customer.setPassword(password);
        customer.setEmail(email);

        Session session=sessionFactory.openSession();
        Transaction transaction= session.beginTransaction();
        session.save(customer);

        transaction.commit();

        session.close();

        RequestDispatcher rd= req.getRequestDispatcher("login.html");
        rd.forward(req,resp);



    }

    public static void ShowCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session= sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Customer> listCustomer = new ArrayList<Customer>();

        try {
            Query query = session.createQuery("from Customer");
            listCustomer = query.getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        request.setAttribute("listCustomer",listCustomer);
        request.getRequestDispatcher("showCustomer.jsp").forward(request,response);
    }
    public static void ShowProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Product> listProduct = new ArrayList<>();

        try {
            Query query = session.createQuery(" From Product");
            listProduct = query.getResultList();
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        request.setAttribute("listProduct",listProduct);
        request.getRequestDispatcher("showProduct.jsp").forward(request,response);
    }
}


