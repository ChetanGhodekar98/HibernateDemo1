package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateEmployeeSalary {
    public static void main(String[] args) {
        Configuration cfg=new Configuration();
        cfg=cfg.configure();
        SessionFactory factory=cfg.buildSessionFactory();
        Session session= factory.openSession();
        Transaction tx= session.beginTransaction();

        Scanner scanner=new Scanner(System.in);
        System.out.println("ENTER EMPLOYEE ID");
        int id= scanner.nextInt();
        System.out.println("ENTER EMPLOYEE SALARY");
        double empSalary= scanner.nextDouble();

        Employee e1=session.load(Employee.class,id);
        e1.setEmpSal(empSalary);

        session.update(e1);
        tx.commit();
        factory.close();
        session.close();
        System.out.println("DATA UPDATED SUCCESSFULLY");
    }
}
