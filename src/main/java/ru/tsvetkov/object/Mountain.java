package ru.tsvetkov.object;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "table_mountain")
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMountain;
    @Column(name = "mountain_name", length = 100, nullable = false)
    private String name;
    private String country;
    private int height;


    @OneToMany(mappedBy = "mountain", fetch = FetchType.EAGER)
    private ArrayList<Group> group;

    public Mountain() {
    }

    public Mountain(String name, String country, int height) {
        if (name.length() < 4) throw new IllegalArgumentException("Название горы слишком короткое");
        if (country.length() < 4) throw new IllegalArgumentException("Название страны слишком короткое");
        if (height < 100) throw new IllegalArgumentException("Высота должна быть больше 100");
        this.name = name;
        this.country = country;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "idMountain=" + idMountain +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
