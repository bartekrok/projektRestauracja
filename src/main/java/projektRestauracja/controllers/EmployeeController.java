package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.Beverage;
import projektRestauracja.models.Employee;
import projektRestauracja.services.BeverageService;
import projektRestauracja.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public EmployeeController() {
    }
    @RequestMapping("/zarzadzanie/employee_list")
    public String viewEmployeeList(Model model){
        List<Employee> le=service.findAll();
        model.addAttribute("le", le);
        return "employee_list";
    }
    @RequestMapping("/zarzadzanie/new_employee")
    public String showFormNewEmployee(Model model) {
        Employee ne = new Employee();
        model.addAttribute("employee", ne);
        return "new_employee";
    }
    @PostMapping(value="/save_employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        service.save(employee);
        return "redirect:/zarzadzanie/employee_list";
    }
    @RequestMapping("/edit_employee/{ide}")
    public ModelAndView showEditFormEmployee(@PathVariable(name = "ide") Long ide) {
        ModelAndView mav = new ModelAndView("edit_employee");
        Optional<Employee> ee = service.findById(ide);
        mav.addObject("employee", ee);
        return mav;
    }
    @RequestMapping("/delete_employee/{ide}")
    public String deleteEmployee(@PathVariable(name = "ide") Long ide) {
        service.deleteById(ide);
        return "redirect:/zarzadzanie/employee_list";
    }
}
