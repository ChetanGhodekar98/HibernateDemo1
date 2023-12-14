package Demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
    public static void main(String[] args) {
        //IT WILL ACTIVATE HIBERNATE FRAMEWORK
        Configuration cfg=new Configuration();
        //IT WILL READ hibernate.cfg.xml SYNTACTICALLY CORRECT OR NOT
        // AND IF FILE IS SYNTACTICALLY CORRECT THEN RETURN CONFIGURATION OBJECT
        cfg=cfg.configure();
        // IT WILL FETCH THE DATA FROM CFG OBJECT AND CREATE ESTABLISH
        // THE CONNECTION BETWEEN HIBERNATE AND JAVA APPLICATION AND RETURN THE
        //SESSION FACTORY OBJECT
        SessionFactory factory =cfg.buildSessionFactory();

        //IT WILL FETCH THE RECORD FROM FACTORY AND RETURN
        //THE SESSION OBJECT
        Session session=factory.openSession();

        //WHEN WE CREATE AN OBJECT OF ENTITY CLASS SESSION WILL BE IN THREE PHASE
        //WHEN WE CREATE OBJECT THEN SESSION WILL BE IN TRANSIENT STATE
        Employee e1=new Employee();
        e1.setEmpId(103);
        e1.setEmpName("RAHUL");
        e1.setEmpSal(34999.99);

        Transaction tx= session.beginTransaction();
        //WHEN WE CALL ONE OF THE SESSION METHOD THEN SESSION WILL BE IN
        // TRANSIENT STATE
        session.save(e1);
        tx.commit();

        factory.close();

        // WHEN WE CLOSE THE SESSION THEN SESSION WILL BE IN DETACHED STATE
        session.close();
        System.out.println("DATA SAVED");
    }
}
