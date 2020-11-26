package be.ifosup.glvp.controller.admin;

import be.ifosup.glvp.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//Importation des services, modeles nécessaires pour les objets
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.services.UserService;

import java.util.Set;

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

    @GetMapping("/create")
    public String SetStudent(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);

        return "admin/users";
    }

    @PostMapping("/create")
    public String CreateStudent(@ModelAttribute("userform") UserForm userForm) {
        usersService.create(userForm);

        return "redirect:create";
    }

    @GetMapping
    public String adminPage(Model model) { //
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        UserDTO user = usersService.getUser(username); //Création de l'objet user en fonction du login entré


        model.addAttribute("user", user);

        return "admin/index";
    }

    @GetMapping("/userlist")
    public String listUsers(Model model) {

        // get users from db
        Set<UserDTO> users = usersService.getAll();

        // add to the spring model
        model.addAttribute("users", users);

        return "admin/users";
    }
}
