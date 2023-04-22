import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Logout")
public class Logout extends HttpServlet {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        int cid = (int) session.getAttribute("cid");

        Session session1 = sessionFactory.openSession();
        Transaction transaction = session1.beginTransaction();

        Customer customer = session1.get(Customer.class,cid);
        List<Product> list = customer.getProducts();




        session.invalidate();
        resp.sendRedirect("login.html");

        session1.close();
    }
}