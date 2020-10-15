package kea.lbniese.forum.repository;

import kea.lbniese.forum.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {

    @Autowired
    JdbcTemplate template;

    public void create(Comment comment) {
        String sql = "INSERT INTO COMMENT (CONTENT, FK_THREAD_ID) VALUES(?,?)";
        template.update(sql, comment.getContent(), comment.getThread().getId());
    }

    public List<Comment> fetchAll() {
        String sql = "SELECT * FROM COMMENT";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        return template.query(sql, rowMapper);
    }

    public Comment fetchById(int id) {
        String sql = "SELECT * FROM COMMENT WHERE id = ?";
        RowMapper<Comment> rowMapper = new BeanPropertyRowMapper<>(Comment.class);
        Comment Comment = template.queryForObject(sql, rowMapper, id);
        return Comment;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM COMMENT WHERE ID = ?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Comment comment) {
        String sql = "UPDATE THREAD SET CONTENT=?, THREAD_ID=? WHERE ID=?";
        template.update(sql, comment.getContent(), comment.getThread().getId(), id);
    }

}
