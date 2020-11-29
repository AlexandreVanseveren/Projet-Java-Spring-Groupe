package be.ifosup.glvp.controller.admin;

import be.ifosup.glvp.forms.ProductForm;
import be.ifosup.glvp.forms.UserForm;
import be.ifosup.glvp.models.ProductDTO;
import be.ifosup.glvp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
    private final ProductService productService;

    @Autowired
    public AdminController(UserService usersService, ProductService productService) {
        this.usersService = usersService;
        this.productService = productService;
    }


    @GetMapping("/users/create")
    public String SetStudent(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);

        return "admin/users";
    }

    @PostMapping("/users/create")
    public String CreateStudent(@ModelAttribute("userform") UserForm userForm) {
        usersService.create(userForm);
        return "redirect:/admin/userlist";
    }

    @GetMapping("/users/delete/{id}")
    public String DeleteUser(@PathVariable("id") int id) {

        // delete the user
        usersService.deleteById(id);

        // redirect to prevent duplicate submissions
        return "redirect:/admin/userlist";

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
        UserForm userForm1 = new UserForm();
        model.addAttribute("userform", userForm1);
        // get users from db
        Set<UserDTO> users = usersService.getAll();
        // add to the spring model
        model.addAttribute("users", users);
        return "admin/users";
    }

     @GetMapping("/productlist")
    public String listProducts(Model model) {
        ProductForm productForm1 = new ProductForm();
        model.addAttribute("productform", productForm1);
        // get users from db
        Set<ProductDTO> products = productService.getAll();
        // add to the spring model
        model.addAttribute("products", products);
        return "admin/product";
    }


}
