package kea.lbniese.forum.repository;

import kea.lbniese.forum.mapper.ThreadRowMapper;
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
        String sql = "INSERT INTO THREAD (CONTENT, TITLE, AUTHOR_ID) VALUES(?,?,?)";
        template.update(sql, thread.getContent(), thread.getTitle(), thread.getAuthor().getId());
    }

    /*
    public List<Thread> fetchAll() {
        String sql = "SELECT * FROM THREAD";
        RowMapper<Thread> rowMapper = new BeanPropertyRowMapper<>(Thread.class);
        return template.query(sql, rowMapper);
    }
    */

    public List<Thread> fetchAll() {
        return template.query("SELECT * FROM THREAD t JOIN Author a ON t.AUTHOR_ID = a.ID", new ThreadRowMapper());
    }

    public Thread fetchById(int id) {
        String sql = "SELECT * FROM THREAD t JOIN Author a ON t.AUTHOR_ID = a.ID WHERE t.ID = ?";
        RowMapper<Thread> rowMapper = new ThreadRowMapper();
        Thread Thread = template.queryForObject(sql, rowMapper, id);
        return Thread;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM THREAD WHERE ID = ?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Thread thread) {
        String sql = "UPDATE THREAD SET CONTENT=?, TITLE=?, AUTHOR_ID=? WHERE ID=?";
        template.update(sql, thread.getTitle(), thread.getContent(), thread.getAuthor().getId(), id);
    }

}
