package uz.asz.demopostomat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.asz.demopostomat.service.CourierService;
import uz.asz.demopostomat.service.PostomatService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/courier")
public class CourierController {
    @Autowired
    private CourierService courierService;
    @Autowired
    private PostomatService postomatService;

    @GetMapping("/getItem")
    public String getOrder(HttpServletRequest request, Model model) {
        Integer id = Integer.valueOf(request.getParameter("couriers"));
        courierService.changeCourierStatus(id, true);
        postomatService.changePostomatStatus(Integer.valueOf(request.getParameter("postomats")),false);
        return "courier/sendToPostomat";
    }


}
