package uz.asz.demopostomat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.asz.demopostomat.entity.Client;
import uz.asz.demopostomat.entity.Courier;
import uz.asz.demopostomat.entity.Item;
import uz.asz.demopostomat.entity.Postomat;
import uz.asz.demopostomat.repository.ClientRepository;
import uz.asz.demopostomat.repository.CourierRepository;
import uz.asz.demopostomat.repository.ItemRepository;
import uz.asz.demopostomat.repository.PostomatRepository;
import uz.asz.demopostomat.service.ClientService;
import uz.asz.demopostomat.service.CourierService;
import uz.asz.demopostomat.service.ItemService;
import uz.asz.demopostomat.service.PostomatService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private PostomatService postomatService;
    @Autowired
    private CourierService courierService;
    @Autowired
    private ItemService itemService;

    @GetMapping("/created")
    public String createdClient(HttpServletRequest request, Model model) {
        clientService.createClient(request.getParameter("location"), request.getParameter("fullname"), Integer.valueOf(request.getParameter("purchase_item")), request.getParameter("postomatForClient"));
        Integer postomatId=Integer.valueOf(request.getParameter("postomatForClient"));
        postomatService.changePostomatStatus(postomatId,true);
        model.addAttribute("purchased_item", itemService.getItemById(Integer.valueOf(request.getParameter("purchase_item"))));
        model.addAttribute("free_couriers", courierService.getCourier());
        return "courier/takeOrder";
    }
}
