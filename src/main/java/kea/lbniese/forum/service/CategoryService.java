package kea.lbniese.forum.service;

import kea.lbniese.forum.model.Category;
import kea.lbniese.forum.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository CategoryRepository;

    public void create(Category Category) {
        CategoryRepository.create(Category);
    }

    public List<Category> fetchAll() {
        return CategoryRepository.fetchAll();
    }

    public Category fetchById(int id) {
        return CategoryRepository.fetchById(id);
    }

    public Boolean delete(int id) {
        try {
            return CategoryRepository.delete(id);
        } catch (DataIntegrityViolationException ex) {
            return false;
        }
    }

    public void update(int id, Category category) {
        CategoryRepository.update(id, category);
    }

}
