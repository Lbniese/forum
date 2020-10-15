package kea.lbniese.forum.service;

import kea.lbniese.forum.model.Author;
import kea.lbniese.forum.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository AuthorRepository;

    public void create(Author Author) {
        AuthorRepository.create(Author);
    }

    public List<Author> fetchAll() {
        return AuthorRepository.fetchAll();
    }

    public Author fetchById(int id) {
        return AuthorRepository.fetchById(id);
    }

    public Boolean delete(int id) {
        try {
            return AuthorRepository.delete(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public void update(int id, Author author) {
        AuthorRepository.update(id, author);
    }

}
