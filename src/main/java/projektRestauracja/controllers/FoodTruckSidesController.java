package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.FoodTruckSides;
import projektRestauracja.services.FoodTruckBurgerService;
import projektRestauracja.services.FoodTruckSidesService;

import java.util.List;
import java.util.Optional;

@Controller
public class FoodTruckSidesController {
    @Autowired
    private FoodTruckSidesService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public FoodTruckSidesController() {
    }
    @RequestMapping("/zarzadzanie/foodtrucksides_list")
    public String viewFoodTruckSidesList(Model model){
        List<FoodTruckSides> lfts=service.findAll();
        model.addAttribute("lfts", lfts);
        return "foodtrucksides_list";
    }
    @RequestMapping("/zarzadzanie/new_foodtrucksides")
    public String showFormNewFoodTruckSides(Model model) {
        FoodTruckSides nfts = new FoodTruckSides();
        model.addAttribute("foodtrucksides", nfts);
        return "new_foodtrucksides";
    }
    @PostMapping(value="/save_foodtrucksides")
    public String saveFoodTruckSides(@ModelAttribute("foodtrucksides") FoodTruckSides FoodTruckSides) {
        service.save(FoodTruckSides);
        return "redirect:/zarzadzanie/foodtrucksides_list";
    }
    @RequestMapping("/edit_foodtrucksides/{idfts}")
    public ModelAndView showEditFormFoodTruckSides(@PathVariable(name = "idfts") Long idfts) {
        ModelAndView mav = new ModelAndView("edit_foodtrucksides");
        Optional<FoodTruckSides> efts = service.findById(idfts);
        mav.addObject("foodtrucksides", efts);
        return mav;
    }
    @RequestMapping("/delete_foodtrucksides/{idfts}")
    public String deleteFoodTruckSides(@PathVariable(name = "idfts") Long idfts) {
        service.deleteById(idfts);
        return "redirect:/zarzadzanie/foodtrucksides_list";
    }
}
