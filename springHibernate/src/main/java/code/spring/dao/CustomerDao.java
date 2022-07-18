package code.spring.dao;
import code.spring.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDao {

    @Autowired
     SessionFactory factory;

    public  void insertCustomer(Customer customer)
    {

        factory.getCurrentSession().save(customer);
        System.out.println("saved");
    }

    public  List<Customer> getCustomers()
    {

        return  factory.getCurrentSession().createQuery("from Customer").list();

    }


}
