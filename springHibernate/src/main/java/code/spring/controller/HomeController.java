package code.spring.controller;

import code.spring.dao.CustomerDao;
import code.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public  class HomeController {

    @Autowired
    CustomerDao dao;

    @RequestMapping("/")
    public String getRoute()
    {
        return "index";
    }
    @PostMapping("save")
    public String saveData(@ModelAttribute("customer") Customer customer)
    {
        dao.insertCustomer(customer);
        return "index";
    }
    @GetMapping("customers")
    public String getData(Model model)
    {
        model.addAttribute("customers",dao.getCustomers());
        return "index";
    }
}
