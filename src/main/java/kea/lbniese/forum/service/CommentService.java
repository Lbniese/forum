package kea.lbniese.forum.service;

import kea.lbniese.forum.model.Comment;
import kea.lbniese.forum.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void create(Comment comment) {
        commentRepository.create(comment);
    }

    public List<Comment> fetchAll() {
        return commentRepository.fetchAll();
    }

    public Comment fetchById(int id) {
        return commentRepository.fetchById(id);
    }

    public Boolean delete(int id) {
        try {
            return commentRepository.delete(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public void update(int id, Comment comment) {
        commentRepository.update(id, comment);
    }
}
