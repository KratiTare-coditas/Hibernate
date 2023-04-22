import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProductAddServlet")
public class ProductAddServlet extends HttpServlet {


    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class,id);

        req.setAttribute("product",product);
        req.getRequestDispatcher("showProductToBuy.jsp").forward(req,resp);

        session.close();
    }
}