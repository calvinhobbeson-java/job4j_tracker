package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            Query<Item> query = session.createQuery(
                    "from Item as i where i.id = 3", Item.class);
            System.out.println(query.uniqueResult());
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}