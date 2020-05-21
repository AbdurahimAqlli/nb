package uz.asz.demopostomat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.asz.demopostomat.service.ItemService;
import uz.asz.demopostomat.service.PostomatService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private PostomatService postomatService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("items", itemService.getAllItems());
        return "item/index";
    }

    @GetMapping("/create")
    public String createItem() {
        return "item/create";
    }

    @GetMapping("/created")
    public String itemCreated(HttpServletRequest request, Model model) {
        itemService.createItem(request.getParameter("name"));
        model.addAttribute("items", itemService.getAllItems());
        return "item/index";
    }

    @GetMapping("/purchased/{id}")
    public String bought(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("items", itemService.getItemById(id));
        model.addAttribute("postomatName", postomatService.getAllPostomats());
        return "item/bought";
    }
}
