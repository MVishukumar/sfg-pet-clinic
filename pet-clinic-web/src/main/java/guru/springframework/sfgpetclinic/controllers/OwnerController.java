package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
        System.out.println("Owner controller initialized");
    }


    @RequestMapping({"", "/", "/index", "/index.html"})
    public String lisOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        System.out.println("list owners method in controller");
        System.out.println(ownerService.findAll());

        Iterator it = ownerService.findAll().iterator();
        while(it.hasNext()) {
            Owner o = (Owner) it.next();
            System.out.println(o.getId());
        }

        return "owners/index";
    }
}
