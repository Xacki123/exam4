package ru.tsvetkov.object;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "table_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "many_to_many_group_mountaineer")
    private ArrayList<Mountaineer> mountaineer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mountain")
    private Mountain mountain;
    private Boolean flag;
    private int maxGroup;
    private LocalDateTime dateTime;

    public Group() {
    }

    public Group(ArrayList<Mountaineer> mountaineer, Mountain mountain, int maxGroup, LocalDateTime dateTime) {
        if(mountain.equals(null)) throw new IllegalArgumentException("Значение горы не может быть пустым");
        if (maxGroup < 1) throw new IllegalArgumentException("Количество участников не может быть меньше 1");
        if (dateTime.isBefore(LocalDateTime.now())) throw new IllegalArgumentException("Дата не верна");
        this.mountaineer = mountaineer;
        this.mountain = mountain;
        this.flag = true;
        this.maxGroup = maxGroup;
        this.dateTime = dateTime;
    }

    public ArrayList<Mountaineer> getMountaineer() {
        return mountaineer;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public Boolean getFlag() {
        return flag;
    }

    public int getMaxGroup() {
        return maxGroup;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void addMountaineer(Mountaineer mountaineer){
        if (flag.equals(false)) throw new IllegalArgumentException("Группа заполнена");
        if (mountaineer.equals(null)) throw new IllegalArgumentException("Значение не может быть пустым");
        this.mountaineer.add(mountaineer);
        if (this.mountaineer.size() == maxGroup) flag = false;
    }

    @Override
    public String toString() {
        return "Group{" +
                "idGroup=" + idGroup +
                ", mountaineer=" + mountaineer +
                ", mountain=" + mountain +
                ", flag=" + flag +
                ", maxGroup=" + maxGroup +
                ", dateTime=" + dateTime +
                '}';
    }
}
