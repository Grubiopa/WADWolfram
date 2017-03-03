package com.mycompany.mavenproject1;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewsController {

    @Autowired
    private NewsRepository news;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public String viewAllNews(Model model) {
        List<New> l = news.findAll();
        model.addAttribute("news", l);
        return "blog_template";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String viewNew(Model model, @RequestParam long id) {
        New n = news.findById(id);
        model.addAttribute("new", n);
        return "new_template";
    }

    @RequestMapping(value = "/newsCategory", method = RequestMethod.GET)
    public String newsFromCategory(Model model, @RequestParam Category category) {
        List<New> l = news.findByCategory(category);
        model.addAttribute("categories", l);
        return "blog_template";
    }

    @RequestMapping(value = "/loadNew", method = RequestMethod.POST)
    public void loadNew(@RequestParam String title, @RequestParam String body, @RequestParam String image) {
        New n = new New(title, image, body);
        news.save(n);
    }

}
