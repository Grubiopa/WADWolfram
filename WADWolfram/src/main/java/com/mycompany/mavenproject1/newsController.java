package com.mycompany.mavenproject1;

@controller
public class NewsController{
@Autowired
private NewsRepository news;

@RequestMapping("/news"), method = RequestMethod.GET)
public String viewAllNews(Model model){
List<New> l=news.findAll();
model.addAttribute("news", l);
return "blog_template";
}

@RequestMapping("/new"), method = RequestMethod.GET)
public String viewNew(Model model, @requestParam int id){
New n=news.findOne(id);
model.addAttribute("new", n);
return "new_template";
}

@RequestMapping("/newsCategory"), method = RequestMethod.GET)
public String newsFromCategory(Model model, @requestParam Category category){
List<New> l=news.findByCategory(Category category);
model.addAtTribute("categories", l);
return "blog_template";
}

@RequestMapping("/loadNew"), method = RequestMethod.POST)
public void loadNew(@requestParam String title, @requestParam String body, @requestParam String image){
New n=new New(title, image, body);
new.save(n);
}

}