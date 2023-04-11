import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("Name");
        String department=req.getParameter("department");
     int salary= Integer.parseInt(req.getParameter("salary"));
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        //String id=req.getParameter("id");

//        Employee emp=new Employee();
//        emp.setName(name);
//        emp.setDepartment(department);
//        emp.setEmail(email);
//        emp.setPassword(password);
//        emp.setSalary(salary);

      Employee emp=new Employee(name,department,email,password,salary);
        System.out.println(emp);
     Employeedao dao=new Employeedao(HibernateUtil.getSessionFactory());
   boolean flag= dao.saveEmployee(emp);
     if(flag)
     {
         System.out.println("Registration done");
     }
     else
     {
         System.out.println("Something went wrong");
     }
    resp.sendRedirect("index.jsp");


       }
}
