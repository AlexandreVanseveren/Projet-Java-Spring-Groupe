//WebService

package be.ifosup.glvp.ws;


import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.services.UserService;

import java.util.List;

/**
 * Admin controller
 */
@RestController
@RequestMapping("/admin/ws/users")
public class AdminWSController {

    private final UserService usersService;

//        @RequestMapping(value = "/", method = RequestMethod.GET)
//        public DataTablesOutput<UserDTO> getUsers() {
//            List<UserDTO> allUsers = usersService.getAll();
//
//            DataTablesOutput dataTablesOutput = new DataTablesOutput();
//            dataTablesOutput.setData(allUsers);
//            dataTablesOutput.setRecordsTotal(allUsers.size());
//            dataTablesOutput.setRecordsFiltered(allUsers.size());
//            dataTablesOutput.setDraw(allUsers.size());
//
//            return dataTablesOutput;
//        }


    @Autowired
    public AdminWSController(UserService usersService) {
        this.usersService = usersService;
    }

//        @GetMapping
//        public UserDTO adminPage() {
//
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            String username = authentication.getName();
//
////            return usersService.getUser(username);
//        }
}

