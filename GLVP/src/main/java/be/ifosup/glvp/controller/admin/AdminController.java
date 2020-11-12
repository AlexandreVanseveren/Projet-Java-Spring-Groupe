package be.ifosup.glvp.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//Importation des services, modeles nécessaires pour les objets
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.services.UserService;

/**
 * Admin controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService usersService;

    @Autowired
    public AdminController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public String adminPage(Model model) { //
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserDTO user = usersService.getUser(username); //Création de l'objet user en fonction du login entré


        model.addAttribute("user", user);

        return "admin/index";
    }
}
