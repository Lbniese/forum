package kea.lbniese.forum.repository;

import kea.lbniese.forum.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    JdbcTemplate template;

    public void create(Category Category) {
        String sql = "INSERT INTO CATEGORY (DESCRIPTION) VALUES(?)";
        template.update(sql, Category.getDescription());
    }

    public List<Category> fetchAll() {
        String sql = "SELECT * FROM CATEGORY";
        RowMapper<Category> rowMapper = new BeanPropertyRowMapper<>(Category.class);
        return template.query(sql, rowMapper);
    }

    public Category fetchById(int id) {
        String sql = "SELECT * FROM CATEGORY WHERE ID = ?";
        RowMapper<Category> rowMapper = new BeanPropertyRowMapper<>(Category.class);
        Category Category = template.queryForObject(sql, rowMapper, id);
        return Category;
    }

    public Boolean delete(int id) {
        String sql = "DELETE FROM CATEGORY WHERE ID = ?";
        return template.update(sql, id) > 0;
    }

    public void update(int id, Category category) {
        String sql = "UPDATE CATEGORY SET DESCRIPTION=? WHERE ID=?";
        template.update(sql, category.getDescription(), id);
    }

}
