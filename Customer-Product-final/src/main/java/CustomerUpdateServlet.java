import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");



        Customer customer = session.get(Customer.class,id);
        customer.setName(name);
        customer.setEmail(email);


        session.saveOrUpdate(customer);

        transaction.commit();
        session.close();


        RequestDispatcher rd = req.getRequestDispatcher("customerlogin.html");
        rd.forward(req,resp);
    }
}