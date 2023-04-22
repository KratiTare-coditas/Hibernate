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

@WebServlet("/CustomerEditServlet")
public class CustomerEditServlet extends HttpServlet {

    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session1 = req.getSession(false);
        int id = (int) session1.getAttribute("cid");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,id);

        req.setAttribute("customerEdit",customer);
        req.getRequestDispatcher("showEditCustomer.jsp").forward(req,resp);

        session.close();
    }
}