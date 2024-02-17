package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.*;
import projektRestauracja.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class FoodTruckController {
    @Autowired
    private FoodTruckService service;
    @Autowired
    private FoodTruckBeverageService ftbservice;
    @Autowired
    private FoodTruckBurgerService ftbuservice;
    @Autowired
    private FoodTruckSidesService ftsservice;
    @Autowired
    private SidesService sservice;
    @Autowired
    private BeverageService bservice;
    @Autowired
    private BurgerService buservice;

    public FoodTruckController() {
    }

    @RequestMapping("/menu/{id}")
    public ModelAndView showMenu(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("foodtruck_menu_list");

        List<FoodTruckBeverage> lftb = ftbservice.findAll();
        List<FoodTruckBurger> lftbu = ftbuservice.findAll();
        List<FoodTruckSides> lfts = ftsservice.findAll();

        List<Beverage> beverageList = new ArrayList<>();
        List<Burger> burgerList = new ArrayList<>();
        List<Sides> sidesList = new ArrayList<>();

        for (FoodTruckBeverage ftb : lftb) {
            if (ftb.getId_foodtruck().equals(id)) {
                Optional<Beverage> bft = bservice.findById(ftb.getId_beverage());
                bft.ifPresent(beverageList::add);
            }
        }

        for (FoodTruckBurger ftbu : lftbu) {
            if (ftbu.getId_foodtruck().equals(id)) {
                Optional<Burger> buft = buservice.findById(ftbu.getId_burger());
                buft.ifPresent(burgerList::add);
            }
        }

        for (FoodTruckSides fts : lfts) {
            if (fts.getId_foodtruck().equals(id)) {
                Optional<Sides> sft = sservice.findById(fts.getId_sides());
                sft.ifPresent(sidesList::add);
            }
        }

        mav.addObject("beverage", beverageList);
        mav.addObject("burger", burgerList);
        mav.addObject("sides", sidesList);

        return mav;
    }

    @RequestMapping("/zarzadzanie/foodtruck_list")
    public String viewFoodTruckList(Model model){
        List<FoodTruck> lft=service.findAll();
        model.addAttribute("lft", lft);
        return "foodtruck_list";
    }
    @RequestMapping("/foodtruck_list")
    public String viewUnauthorizedFoodTruckList(Model model){
        List<FoodTruck> lft=service.findAll();
        model.addAttribute("lft", lft);
        return "unauthorized_foodtruck_list";
    }
    @RequestMapping("/zarzadzanie/new_foodtruck")
    public String showFormNewFoodTruck(Model model) {
        FoodTruck nft = new FoodTruck();
        model.addAttribute("foodtruck", nft);
        return "new_foodtruck";
    }
    @PostMapping(value="/save_foodtruck")
    public String saveFoodTruck(@ModelAttribute("foodtruck") FoodTruck foodtruck) {
        service.save(foodtruck);
        return "redirect:/zarzadzanie/foodtruck_list";
    }
    @RequestMapping("/edit_foodtruck/{idft}")
    public ModelAndView showEditFormFoodTruck(@PathVariable(name = "idft") Long idft) {
        ModelAndView mav = new ModelAndView("edit_foodtruck");
        Optional<FoodTruck> eft = service.findById(idft);
        mav.addObject("foodtruck", eft);
        return mav;
    }
    @RequestMapping("/delete_foodtruck/{idft}")
    public String deleteFoodTruck(@PathVariable(name = "idft") Long idft) {
        service.deleteById(idft);
        return "redirect:/zarzadzanie/foodtruck_list";
    }
}
