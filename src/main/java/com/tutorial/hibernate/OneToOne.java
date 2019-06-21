package com.tutorial.hibernate;

import com.tutorial.hibernate.config.HibernateConfig;
import com.tutorial.hibernate.entitites.AccountEntity;
import com.tutorial.hibernate.entitites.EmployeeEntity;
import org.hibernate.Session;

public class OneToOne {

    /**
     * Example of mapping and executing a one to one relationship in hibernate.
     * @todo:as an exercise please build the corresponding services class and dao classes and than make use of the services
     * to execute the same logic as in this class.
     * You should  implement an employee service with an employee do as well as an account service and an account dao.
     *
     * Please note:this example demonstrate how to map one to one relationship in hibernate  with foreign key association.
     *
     * As an exercise please modify the entities to map one to one relationship in hibernate  with common join table and
     * shared primary key.
     */

    public static void main(String[] args) {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();

        AccountEntity account = new AccountEntity();
        account.setAccountNumber("123-345-65454");
        session.saveOrUpdate(account);

        // Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setName("demo-user");
        emp.setAccount(account);
        session.saveOrUpdate(emp);

        session.getTransaction().commit();
        session.close();
    }

}
