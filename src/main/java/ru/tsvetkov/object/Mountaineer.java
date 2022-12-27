package ru.tsvetkov.object;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "table_mountaineer")
public class Mountaineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMountaineer;
    @Column(name = "mountaineer_name", length = 100, nullable = false)
    private String name;
    private String address;
    private int age;

    @ManyToMany
    private ArrayList<Group> groups;

    public Mountaineer() {
    }

    public Mountaineer(String name, String address, int age) {
        if (name.length() < 3) throw new IllegalArgumentException("Имя слишком короткое");
        if (address.length() < 5) throw new IllegalArgumentException("Адрес слишком короткий");
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Mountaineer{" +
                "idMountaineer=" + idMountaineer +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
