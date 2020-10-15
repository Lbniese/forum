package kea.lbniese.forum.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String Name;

    //@OneToMany(mappedBy = "author")
    @OneToMany(mappedBy = "author")
    //@JoinColumn(name = "fk_thread_id")
    //private Set<Thread> threads;
    private Set<Thread> threads;

    public Set<Thread> getThreads() {
        return threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", threads=" + threads +
                '}';
    }
}
