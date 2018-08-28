package com.project.sda.timetable.controller;

import com.project.sda.timetable.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private final EmployeeService employeeService;

    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(path = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        return "index";
    }

    @RequestMapping(path = {"/login"}, method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    @RequestMapping(path = {"/employees"}, method = RequestMethod.GET)
    public String allVisits(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }


}
