package projektRestauracja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import projektRestauracja.models.Sides;
import projektRestauracja.services.SidesService;

import java.util.List;
import java.util.Optional;

@Controller
public class SidesController {
    @Autowired
    private SidesService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public SidesController() {
    }
    @RequestMapping("/zarzadzanie/sides_list")
    public String viewSidesList(Model model){
        List<Sides> ls=service.findAll();
        model.addAttribute("ls", ls);
        return "sides_list";
    }
    @RequestMapping("/zarzadzanie/new_sides")
    public String showFormNewSides(Model model) {
        Sides ns = new Sides();
        model.addAttribute("sides", ns);
        return "new_sides";
    }
    @PostMapping(value="/save_sides")
    public String saveSides(@ModelAttribute("sides") Sides sides) {
        service.save(sides);
        return "redirect:/zarzadzanie/sides_list";
    }
    @RequestMapping("/edit_sides/{ids}")
    public ModelAndView showEditFormSides(@PathVariable(name = "ids") Long ids) {
        ModelAndView mav = new ModelAndView("edit_sides");
        Optional<Sides> es = service.findById(ids);
        mav.addObject("sides", es);
        return mav;
    }
    @RequestMapping("/delete_sides/{ids}")
    public String deleteBook(@PathVariable(name = "ids") Long ids) {
        service.deleteById(ids);
        return "redirect:/zarzadzanie/sides_list";
    }
}
