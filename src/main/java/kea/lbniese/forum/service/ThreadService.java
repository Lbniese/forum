package kea.lbniese.forum.service;

import kea.lbniese.forum.model.Thread;
import kea.lbniese.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThreadService {

    @Autowired
    ThreadRepository threadRepository;

    public void create(Thread thread) {
        threadRepository.create(thread);
    }

    public List<Thread> fetchAll() {
        return threadRepository.fetchAll();
    }

    public Thread fetchById(int id) {
        return threadRepository.fetchById(id);
    }

    public Boolean delete(int id) {
        try {
            return threadRepository.delete(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public void update(int id, Thread thread) {
        threadRepository.update(id, thread);
    }

}
