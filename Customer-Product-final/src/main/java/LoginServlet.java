import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
//public static  Configuration configuration=new Configuration();
    //public static SessionFactory sessionFactory= configuration.buildSessionFactory();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Customer customer = (Customer) session.createQuery("from Customer C where C.email=:email")
                .setParameter("email", email)
                .uniqueResult();

        if (customer != null && customer.getPassword().equals(password)) {
            HttpSession session1 = req.getSession();
            session1.setAttribute("cid", customer.getId());
            resp.sendRedirect("customerlogin.html");
        } else {
            out.println("invalid credentials");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, resp);
        }

        session.close();
        sessionFactory.close();
    }

}
