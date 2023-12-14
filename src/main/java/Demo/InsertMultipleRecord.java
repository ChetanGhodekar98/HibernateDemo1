package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;


public class InsertMultipleRecord {
    public static void main(String[] args) {
        Session session=new Configuration().configure()
                .buildSessionFactory().openSession();


        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER NUMBER TO INSERT RECORDS ->");
        int num= scanner.nextInt();
        Transaction tx=session.beginTransaction();
        for(int i=0;i<num;i++){

            System.out.println("ENTER EMPLOYEE ID");
            int id= scanner.nextInt();
            System.out.println("ENTER EMPLOYEE NAME");
            String name= scanner.next();
            System.out.println("ENTER EMPLOYEE SALARY");
            double salary= scanner.nextDouble();

            Employee e1=new Employee();
            e1.setEmpId(id);
            e1.setEmpName(name);
            e1.setEmpSal(salary);

            session.save(e1);

        }
        tx.commit();
        session.close();
        System.out.println("MULTIPLE RECORD SAVED");

    }
}
