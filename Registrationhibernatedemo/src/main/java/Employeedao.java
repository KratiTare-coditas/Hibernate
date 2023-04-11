import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Employeedao {
    private SessionFactory sessionFactory;
    public Employeedao(SessionFactory sessionFactory)
    {
        super();
        this.sessionFactory=sessionFactory;
    }
    public boolean saveEmployee(Employee emp)
    {
        boolean flag=false;
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(emp);
       int i= (int) session.save(emp);
       if(i>0)
       {
           flag=true;
       }
        transaction.commit();
        session.close();
       return  flag;
    }
}
