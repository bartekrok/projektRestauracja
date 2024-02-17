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
import projektRestauracja.services.BeverageService;


import java.util.List;
import java.util.Optional;

@Controller
public class BeverageController {
    @Autowired
    private BeverageService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public BeverageController() {
    }
    @RequestMapping("/zarzadzanie/beverage_list")
    public String viewBeverageList(Model model){
        List<Beverage> lb=service.findAll();
        model.addAttribute("lb", lb);
        return "beverage_list";
    }
    @RequestMapping("/zarzadzanie/new_beverage")
    public String showFormNewBeverage(Model model) {
        Beverage nb = new Beverage();
        model.addAttribute("beverage", nb);
        return "new_beverage";
    }
    @PostMapping(value="/save_beverage")
    public String saveBeverage(@ModelAttribute("beverage") Beverage beverage) {
        service.save(beverage);
        return "redirect:/zarzadzanie/beverage_list";
    }
    @RequestMapping("/edit_beverage/{idb}")
    public ModelAndView showEditFormBeverage(@PathVariable(name = "idb") Long idb) {
        ModelAndView mav = new ModelAndView("edit_beverage");
        Optional<Beverage> eb = service.findById(idb);
        mav.addObject("beverage", eb);
        return mav;
    }
    @RequestMapping("/delete_beverage/{idb}")
    public String deleteBook(@PathVariable(name = "idb") Long idb) {
        service.deleteById(idb);
        return "redirect:/zarzadzanie/beverage_list";
    }
}
