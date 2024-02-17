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
import projektRestauracja.models.Burger;
import projektRestauracja.services.BurgerService;
import projektRestauracja.services.BeverageService;

import java.util.List;
import java.util.Optional;

@Controller
public class BurgerController {
    @Autowired
    private BurgerService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public BurgerController() {
    }
    @RequestMapping("/zarzadzanie/burger_list")
    public String viewBurgerList(Model model){
        List<Burger> lb=service.findAll();
        model.addAttribute("lb", lb);
        return "burger_list";
    }
    @RequestMapping("/zarzadzanie/new_burger")
    public String showFormNewBurger(Model model) {
        Burger nb = new Burger();
        model.addAttribute("burger", nb);
        return "new_burger";
    }
    @PostMapping(value="/save_burger")
    public String saveBurger(@ModelAttribute("burger") Burger burger) {
        service.save(burger);
        return "redirect:/zarzadzanie/burger_list";
    }
    @RequestMapping("/edit_burger/{idb}")
    public ModelAndView showEditFormBurger(@PathVariable(name = "idb") Long idb) {
        ModelAndView mav = new ModelAndView("edit_burger");
        Optional<Burger> eb = service.findById(idb);
        mav.addObject("burger", eb);
        return mav;
    }
    @RequestMapping("/delete_burger/{idb}")
    public String deleteBurger(@PathVariable(name = "idb") Long idb) {
        service.deleteById(idb);
        return "redirect:/zarzadzanie/burger_list";
    }
}
