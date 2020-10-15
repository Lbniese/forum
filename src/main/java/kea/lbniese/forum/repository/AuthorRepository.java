package kea.lbniese.forum.repository;

import kea.lbniese.forum.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepository {

    @Autowired
    JdbcTemplate template;

    public void create(Author Author) {
        String sql = "INSERT INTO AUTHOR (NAME) VALUES(?)";
        template.update(sql, Author.getName());
    }

    public List<Author> fetchAll() {
        String sql = "SELECT * FROM AUTHOR";
        RowMapper<Author> rowMapper = new BeanPropertyRowMapper<>(Author.class);
        return template.query(sql, rowMapper);
    }

    public Author fetchById(int id) {
        String sql = "SELECT * FROM AUTHOR WHERE ID = ?";
        RowMapper<Author> rowMapper = new BeanPropertyRowMapper<>(Author.class);
        Author Author = template.queryForObject(sql, rowMapper, id);
        return Author;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM AUTHOR WHERE ID = ?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Author author) {
        String sql = "UPDATE AUTHOR SET NAME=? WHERE ID=?";
        template.update(sql, author.getName(), id);
    }

}
