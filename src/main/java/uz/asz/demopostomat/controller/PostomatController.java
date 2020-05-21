package uz.asz.demopostomat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.asz.demopostomat.service.PostomatService;

import javax.servlet.http.HttpServletRequest;

@Controller

@RequestMapping("/postomat")

public class PostomatController {

    @Autowired
    private PostomatService postomatService;

    @GetMapping("/get")
    public String getPostomat(Model model) {
        model.addAttribute("postomat", postomatService.getAllPostomats());
        return "postomat/get";
    }

    @GetMapping("/create")
    public String createPostomats() {
        return "postomat/create";
    }

    @GetMapping("/created")
    public String PostomatCreated(HttpServletRequest request, Model model) {
        postomatService.createPostomat(request.getParameter("name"), request.getParameter("location"));
        model.addAttribute("postomat", postomatService.getAllPostomats());
        return "postomat/get";
    }

    @GetMapping("/emptyPostomat")
    public String emptyPostomatToClient(HttpServletRequest request) {
        Integer postomatId = Integer.valueOf(request.getParameter("postomats"));
        postomatService.changePostomatStatus(postomatId, false);
        return "postomat/empty";
    }
}
