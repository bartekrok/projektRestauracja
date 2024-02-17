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
import projektRestauracja.models.SupervisionPeriod;
import projektRestauracja.services.SidesService;
import projektRestauracja.services.SupervisionPeriodService;

import java.util.List;
import java.util.Optional;

@Controller
public class SupervisionPeriodController {
    @Autowired
    private SupervisionPeriodService service;
    //@Autowired
    //private FoodTruckBeverageService ftbservice;

    public SupervisionPeriodController() {
    }
    @RequestMapping("/zarzadzanie/supervisionperiod_list")
    public String viewSupervisionPeriodList(Model model){
        List<SupervisionPeriod> lsp=service.findAll();
        model.addAttribute("lsp", lsp);
        return "supervisionperiod_list";
    }
    @RequestMapping("/zarzadzanie/new_supervisionperiod")
    public String showFormNewSupervisionPeriod(Model model) {
        SupervisionPeriod nsp = new SupervisionPeriod();
        model.addAttribute("supervisionperiod", nsp);
        return "new_supervisionperiod";
    }
    @PostMapping(value="/save_supervisionperiod")
    public String saveSupervisionPeriod(@ModelAttribute("supervisionperiod") SupervisionPeriod supervisionperiod) {
        service.save(supervisionperiod);
        return "redirect:/zarzadzanie/supervisionperiod_list";
    }
    @RequestMapping("/edit_supervisionperiod/{idsp}")
    public ModelAndView showEditFormsupervisionperiod(@PathVariable(name = "ids") Long idsp) {
        ModelAndView mav = new ModelAndView("edit_supervisionperiod");
        Optional<SupervisionPeriod> esp = service.findById(idsp);
        mav.addObject("supervisionperiod", esp);
        return mav;
    }

}
