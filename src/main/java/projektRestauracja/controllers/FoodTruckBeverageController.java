package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.Employee;
import projektRestauracja.models.FoodTruckBeverage;
import projektRestauracja.services.EmployeeService;
import projektRestauracja.services.FoodTruckBeverageService;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodTruckBeverageController {
    @Autowired
    private FoodTruckBeverageService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public FoodTruckBeverageController() {
    }
    @RequestMapping("/zarzadzanie/foodtruckbeverage_list")
    public String viewFoodTruckBeverageList(Model model){
        List<FoodTruckBeverage> lftb=service.findAll();
        model.addAttribute("lftb", lftb);
        return "foodtruckbeverage_list";
    }
    @RequestMapping("/zarzadzanie/new_foodtruckbeverage")
    public String showFormNewFoodTruckBeverage(Model model) {
        FoodTruckBeverage nftb = new FoodTruckBeverage();
        model.addAttribute("foodtruckbeverage", nftb);
        return "new_foodtruckbeverage";
    }
    @PostMapping(value="/save_foodtruckbeverage")
    public String saveFoodTruckBeverage(@ModelAttribute("foodtruckbeverage") FoodTruckBeverage foodtruckbeverage) {
        service.save(foodtruckbeverage);
        return "redirect:/zarzadzanie/foodtruckbeverage_list";
    }
    @RequestMapping("/edit_foodtruckbeverage/{idftb}")
    public ModelAndView showEditFormFoodTruckBeverage(@PathVariable(name = "idftb") Long idftb) {
        ModelAndView mav = new ModelAndView("edit_foodtruckbeverage");
        Optional<FoodTruckBeverage> eftb = service.findById(idftb);
        mav.addObject("foodtruckbeverage", eftb);
        return mav;
    }
    @RequestMapping("/delete_foodtruckbeverage/{idftb}")
    public String deleteFoodTruckBeverage(@PathVariable(name = "idftb") Long idftb) {
        service.deleteById(idftb);
        return "redirect:/zarzadzanie/foodtruckbeverage_list";
    }
}
