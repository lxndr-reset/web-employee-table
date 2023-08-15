package com.reset.spring.mvc_hibernate_aop.controller;

import com.reset.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.reset.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping("/showAllEmployees")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        model.addAttribute("allEmps", allEmployees); //Наш view будет использовать этот аттрибут, для того чтобы уже в нём выводить нужную информацию. По сути мы сейчас просто отформатировали нашлист под тот формат, который сможет использовать view

        return "all-employees-view";
    }
}
