package kea.lbniese.forum.model;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @Nullable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
