package todoapp.doa;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import todoapp.model.Todo;
import todoapp.util.HibernateUtil;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 *
 * @author Ramesh Fadatare
 *
 */

public class TodoDaoImpl implements TodoDao {

    public TodoDaoImpl() {
    }

    @Override
    public void insertTodo(Todo todo) throws SQLException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(todo);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Todo selectTodo(long todoId) {
        Transaction transaction = null;
        Todo todo = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            todo = session.get(Todo.class, todoId);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public List<Todo> selectAllTodos() {

        Transaction transaction = null;
        List<Todo> todos = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            todos = session.createQuery("from Todo").getResultList();

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return todos;
    }

    @Override
    public boolean deleteTodo(long id) throws SQLException {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Delete a todo object
            Todo todo = session.get(Todo.class, id);
//            session.save(todo);
//            transaction.commit();
            if (todo != null) {
                session.delete(todo);
               transaction.commit();
                System.out.println("todo is deleted");
                return true;
            }
          //transaction.commit();
            // commit transaction

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void updateTodo(Todo todo) throws SQLException {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.saveOrUpdate(todo);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
