package ra.baitapvnthayhai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ra.baitapvnthayhai.dao.EmployeeDAO;
import ra.baitapvnthayhai.entity.Employee;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping(value = {"/","listEm"})
    public String listEmployee(Model model){
        List<Employee> listEm=employeeDAO.getEmployees();
        model.addAttribute("list",listEm);
        return "list";
    }

    @RequestMapping("/ShowAddEmployee")
    public String ShowAddEmployee(Model model){
        Employee em = new Employee();
        model.addAttribute("em",em);
        return "addEmployee";
    }

    @RequestMapping("/addEmployee")
    public String addEmployee(@Validated @ModelAttribute("em") Employee employee, BindingResult result , Model model){
        if (result.hasErrors()){
            model.addAttribute("em",employee);
            return "addEmployee";
        }else {
            employeeDAO.addEmployee(employee);
            return "redirect:/listEm";
        }
    }

    @GetMapping("/ShowUpdateEmployee")
    public String ShowUpdateEmployee(Model model, @RequestParam("id") Integer id){
        Employee employee = employeeDAO.getEmployeeById(id);
        model.addAttribute("em",employee);
        return "editEmployee";
    }
    @PostMapping("/updateEmployee")
    public String updateEmployee(@Validated @ModelAttribute("em") Employee employee,BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("em",employee);
            return "editEmployee";
        }else {
            employeeDAO.updateEmployee(employee);
            return "redirect:/listEm";
        }
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDAO.deleteEmployee(id);
        return "redirect:/listEm";
    }

}
