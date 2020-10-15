package kea.lbniese.forum.mapper;

import kea.lbniese.forum.model.Author;
import kea.lbniese.forum.model.Thread;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThreadRowMapper implements RowMapper<Thread> {

    public Thread mapRow(ResultSet rs, int rowNum) throws SQLException {
        Thread thread = new Thread();
        thread.setId(rs.getInt("ID"));
        thread.setTitle(rs.getString("TITLE"));
        thread.setContent(rs.getString("CONTENT"));
        Author author = new Author();
        author.setId(rs.getInt("AUTHOR_ID"));
        author.setName(rs.getString("NAME"));
        thread.setAuthor(author);
        return thread;
    }

}
