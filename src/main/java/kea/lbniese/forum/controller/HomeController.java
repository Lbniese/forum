package kea.lbniese.forum.controller;

import kea.lbniese.forum.model.Author;
import kea.lbniese.forum.model.Thread;
import kea.lbniese.forum.service.AuthorService;
import kea.lbniese.forum.service.CategoryService;
import kea.lbniese.forum.service.CommentService;
import kea.lbniese.forum.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    //Logging for whenever someone visits a page
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    ThreadService threadService;

    @Autowired
    CommentService commentService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    AuthorService authorService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/thread")
    public String thread(Model model) {
        logger.info("[GET] Calling fetch threads");
        List<Thread> threadList = threadService.fetchAll();
        model.addAttribute("threads", threadList);
        return "thread";
    }

    @PostMapping("/thread")
    public String thread(@ModelAttribute Thread thread, Model model) {
        logger.info("[POST] Calling create thread");
        threadService.create(thread);
        List<Thread> threadList = threadService.fetchAll();
        model.addAttribute("threads", threadList);
        return "thread";
    }

    @GetMapping("/author")
    public String author(Model model) {
        logger.info("[GET] Calling fetch authors");
        List<Author> authorList = authorService.fetchAll();
        model.addAttribute("authors", authorList);
        return "author";
    }

    @PostMapping("/author")
    public String author(@ModelAttribute Author author, Model model) {
        logger.info("[POST] Calling create author");
        authorService.create(author);
        List<Author> authorList = authorService.fetchAll();
        model.addAttribute("authors", authorList);
        return "author";
    }

    @GetMapping("/thread/delete/{id}")
    public String deleteThread(@PathVariable("id") int id) {
        logger.info("[GET] Calling delete thread");
        threadService.delete(id);
        return "redirect:/thread";
    }

    @GetMapping("/thread/update/{id}")
    public String updateThread(@PathVariable("id") int id, Model model) {
        logger.info("[GET] Calling update thread");
        model.addAttribute("thread", threadService.fetchById(id));
        model.addAttribute("AUTHOR_ID", threadService.fetchById(id).getAuthor().toString());
        return "update-thread";
    }

    @PostMapping("/thread/update")
    public String updateThread(@ModelAttribute Thread thread) {
        logger.info("[POST] Calling update thread");
        threadService.update(thread.getId(), thread);
        return "redirect:/thread";
    }

    @GetMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable("id") int id) {
        logger.info("[GET] Calling delete author");
        authorService.delete(id);
        return "redirect:/author";
    }

    @GetMapping("/author/update/{id}")
    public String updateAuthor(@PathVariable("id") int id, Model model) {
        logger.info("[GET] Calling update author");
        model.addAttribute("author", authorService.fetchById(id));
        return "update-author";
    }

    @PostMapping("/author/update")
    public String updateAssignment(@ModelAttribute Author author) {
        logger.info("[POST] Calling update assignment");
        authorService.update(author.getId(), author);
        return "redirect:/author";
    }

}
