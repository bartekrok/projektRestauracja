package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.FoodTruckBeverage;
import projektRestauracja.models.FoodTruckBurger;
import projektRestauracja.services.FoodTruckBeverageService;
import projektRestauracja.services.FoodTruckBurgerService;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodTruckBurgerController {
    @Autowired
    private FoodTruckBurgerService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public FoodTruckBurgerController() {
    }
    @RequestMapping("/zarzadzanie/foodtruckburger_list")
    public String viewFoodTruckBurgerList(Model model){
        List<FoodTruckBurger> lftb=service.findAll();
        model.addAttribute("lftb", lftb);
        return "foodtruckburger_list";
    }
    @RequestMapping("/zarzadzanie/new_foodtruckburger")
    public String showFormNewFoodTruckBurger(Model model) {
        FoodTruckBurger nftb = new FoodTruckBurger();
        model.addAttribute("foodtruckburger", nftb);
        return "new_foodtruckburger";
    }
    @PostMapping(value="/save_foodtruckburger")
    public String saveFoodTruckBurger(@ModelAttribute("foodtruckburger") FoodTruckBurger foodtruckburger) {
        service.save(foodtruckburger);
        return "redirect:/zarzadzanie/foodtruckburger_list";
    }
    @RequestMapping("/edit_foodtruckburger/{idftb}")
    public ModelAndView showEditFormFoodTruckBurger(@PathVariable(name = "idftb") Long idftb) {
        ModelAndView mav = new ModelAndView("edit_foodtruckburger");
        Optional<FoodTruckBurger> eftb = service.findById(idftb);
        mav.addObject("foodtruckburger", eftb);
        return mav;
    }
    @RequestMapping("/delete_foodtruckburger/{idftb}")
    public String deleteFoodTruckBurger(@PathVariable(name = "idftb") Long idftb) {
        service.deleteById(idftb);
        return "redirect:/zarzadzanie/foodtruckburger_list";
    }
}
