package ru.tsvetkov;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import ru.tsvetkov.object.Group;
import ru.tsvetkov.object.Mountain;
import ru.tsvetkov.object.Mountaineer;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ormLessons"); // должна создаваться в блоке try с ресурсом или у объекта вызван метод close

        EntityManager manager = factory.createEntityManager(); // создание менеджера управляющего ormLesson классами

        Mountaineer mountaineer = new Mountaineer("Alex", "Saint-Petersburg", 25);
        Mountaineer mountaineer1 = new Mountaineer("Bob", "Saint-Petersburg", 27);
        Mountain mountain = new Mountain("Джомолунгма", "Китай", 8848);
        ArrayList<Mountaineer> mountaineers = new ArrayList<>();
        mountaineers.add(mountaineer);


        Group group = new Group(mountaineers, mountain, 5, LocalDateTime.of(2023, Month.JULY, 9, 11, 6, 22));



        manager.getTransaction().begin();

        manager.persist(mountaineer);
        manager.persist(mountain);
        manager.persist(group);

        manager.persist(mountaineer1);
        mountaineers.add(mountaineer1);
        manager.persist(group);

        manager.getTransaction().commit();


        Mountain mountain2 = new Mountain("Эверест", "Китай", 8848);
        Group group2 = new Group(mountaineers, mountain2, 5, LocalDateTime.of(2023, Month.JULY, 9, 11, 6, 22));


        manager.getTransaction().begin();
        manager.persist(mountain2);
        manager.persist(group2);
        manager.getTransaction().commit();

        Group group3 = new Group(mountaineers, new Mountain("Гора", "Россия", 5654), 5, LocalDateTime.of(2023, Month.JULY, 9, 11, 6, 22));
        manager.getTransaction().begin();
        manager.persist(group3);
        manager.getTransaction().commit();
    }
}
