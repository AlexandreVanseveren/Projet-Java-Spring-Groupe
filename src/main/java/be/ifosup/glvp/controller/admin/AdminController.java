package be.ifosup.glvp.controller.admin;

import be.ifosup.glvp.forms.ProductForm;
import be.ifosup.glvp.forms.UserForm;
import be.ifosup.glvp.models.*;
import be.ifosup.glvp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


//Importation des services, modeles nécessaires pour les objets

import java.util.Set;

/**
 * Admin controller
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService usersService;
    private final ProductService productService;
    private final SubcatService subcatService;
    private final StatutService statutService;
    private final CategoryService categoryService;

    @Autowired
    public AdminController(UserService usersService, ProductService productService, StatutService statutService,
                           SubcatService subcatService, CategoryService categoryService) {
        this.usersService = usersService;
        this.productService = productService;
        this.subcatService = subcatService;
        this.statutService = statutService;
        this.categoryService= categoryService;
    }


    @GetMapping("/users/create")
    public String SetUser(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);

        return "admin/users";
    }

    @PostMapping("/users/create")
    public String CreateUser(@ModelAttribute("userform") UserForm userForm) {
        usersService.create(userForm);
        return "redirect:/admin/userlist";
    }

    @GetMapping("/product/update/{id}")
    public String GetStudent(@PathVariable("id") int id, Model model) {
        ProductDTO product = productService.getById(id);
        model.addAttribute("product", product);
        return "admin/productlist";
    }

    @PostMapping("/product/update")
    public String UpdateStudent(@ModelAttribute("product") ProductForm productForm) {
        productService.update(productForm);
        return "redirect:/admin/produclist";
    }

    @GetMapping("/product/create")
    public String SetProduct(Model model) {
        ProductForm productForm = new ProductForm();
        model.addAttribute("productform", productForm);
        return "admin/users";
    }

    @PostMapping("/product/create")
    public String CreateProduct(@ModelAttribute("productform") ProductForm productForm) {
        productService.create(productForm);
        return "redirect:/admin/productlist";
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

    @GetMapping("/categorielist/{id}")
    public String listCategorie(Model model,@PathVariable("id") int id){
        Set<ProductDTO> pr1 = productService.getByCategory(id);
        model.addAttribute("pr1",pr1);
        return "admin/product";
    }


    @GetMapping("/productlist")
    public String listProducts(Model model) {

        ProductForm productForm1 = new ProductForm();
        model.addAttribute("productform", productForm1);
        // get users from db
        // add to the spring model
         Set<ProductDTO> products = productService.getAll();
         model.addAttribute("products", products);
         // add to the spring model
         Set<SubcatDTO> subcat = subcatService.getAll();
         model.addAttribute("subcat", subcat);
         // add to the spring model
         Set<StatutDTO> status = statutService.getAll();
         model.addAttribute("status", status);
         // add to the spring model
         Set<CategoryDTO> category = categoryService.getAll();
         model.addAttribute("category", category);
//         System.out.println(subcat);
//         System.out.println(status);
//         System.out.println(products);
//         System.out.println(category);
         model.addAttribute("subcat", subcat);
//         Set<StatutDTO> status = statutService.getAll();
         Set<ProductDTO> pr1 = productService.getByCategory(1);
         Set<ProductDTO> pr2 = productService.getBysubCategory(1);
         Set<ProductDTO> pr3 = productService.getBystatut(2);
//
//         add to the spring model
       model.addAttribute("status", status);
//         System.out.println(subcat);
//         System.out.println(status);
//         System.out.println(products);

        return "admin/product";
    }

    @GetMapping("/products/delete/{id}")
    public String DeleteProduct(@PathVariable("id") int id) {
        // delete the user
        productService.deleteById(id);
        // redirect to prevent duplicate submissions
        return "redirect:/admin/productlist";
    }


}
