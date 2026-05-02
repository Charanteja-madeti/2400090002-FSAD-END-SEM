package com.klef.fsad.exam.HibernateVehicle;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo 
{
    public static void main(String[] args) 
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        // INSERT
        Transaction t1 = session.beginTransaction();

        Vehicle v = new Vehicle();
        v.setName("Car");
        v.setDescription("Electric Vehicle");
        v.setDate(new Date());
        v.setStatus("Available");

        session.save(v);
        t1.commit();

        System.out.println("Inserted Successfully");

        // UPDATE
        Transaction t2 = session.beginTransaction();

        Vehicle v2 = session.get(Vehicle.class, 1); // change ID if needed
        if (v2 != null) 
        {
            v2.setName("Updated Car");
            v2.setStatus("Sold");
            session.update(v2);
        }

        t2.commit();

        System.out.println("Updated Successfully");

        session.close();
        sf.close();
    }
}