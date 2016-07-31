package ru.sas.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.sas.model.ContactData;
import ru.sas.model.Contacts;
import ru.sas.model.GroupData;
import ru.sas.model.Groups;

import java.util.List;

public class DbHelper {
    private final SessionFactory sessionFactory;

    public DbHelper() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }

    public Groups groups() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<GroupData> result = session.createQuery("from GroupData ").list();
        session.getTransaction().commit();
        session.close();
        return new Groups(result);

    }
    public GroupData groupsWithACertainId(GroupData group) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        GroupData result =(GroupData)session.createQuery("from GroupData where group_id=" + group.getId()).uniqueResult();
        session.getTransaction().commit();
        session.close();
        return result;

    }

    public Contacts contacts() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00 00:00:00'").list();
        for (ContactData contact : result) {
            System.out.println(contact);
        }
        session.getTransaction().commit();
        session.close();
        return new  Contacts(result);
    }
    public ContactData contactWithACertainID(ContactData contact) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        ContactData result = (ContactData)session.createQuery("from ContactData where deprecated = '0000-00-00 00:00:00' and id = " + contact.getId()).uniqueResult();
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
        return result;
    }


}