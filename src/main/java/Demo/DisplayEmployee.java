package Demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DisplayEmployee {
    public static void main(String[] args) {
        Session session =new Configuration().configure().
                buildSessionFactory().openSession();
        Transaction tx= session.beginTransaction();

        Employee employee=session.load(Employee.class,103);

        System.out.println(employee.getEmpId());
        System.out.println(employee.getEmpName());
        System.out.println(employee.getEmpSal());

        session.close();
    }
}
