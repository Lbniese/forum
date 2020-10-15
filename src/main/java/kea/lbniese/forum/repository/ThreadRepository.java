package kea.lbniese.forum.repository;

import kea.lbniese.forum.model.Thread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThreadRepository {

    @Autowired
    JdbcTemplate template;

    public void create(Thread thread) {
        String sql = "INSERT INTO THREAD (CONTENT, TITLE) VALUES(?,?)";
        template.update(sql, thread.getContent(), thread.getTitle());
    }

    public List<Thread> fetchAll() {
        String sql = "SELECT * FROM THREAD";
        RowMapper<Thread> rowMapper = new BeanPropertyRowMapper<>(Thread.class);
        return template.query(sql, rowMapper);
    }

    public Thread fetchById(int id) {
        String sql = "SELECT * FROM THREAD WHERE ID = ?";
        RowMapper<Thread> rowMapper = new BeanPropertyRowMapper<>(Thread.class);
        Thread Thread = template.queryForObject(sql, rowMapper, id);
        return Thread;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM THREAD WHERE ID = ?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Thread thread) {
        String sql = "UPDATE THREAD SET CONTENT=?, TITLE=? WHERE ID=?";
        template.update(sql, thread.getTitle(), thread.getContent(), id);
    }

}
