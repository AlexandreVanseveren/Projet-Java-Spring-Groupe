package be.ifosup.glvp.services;

import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.forms.UserForm;


import java.util.List;
import java.util.Set;

//Objet créer en fonction du login
public interface UserService {
    UserDTO getUser(String username);

    Set<UserDTO> getAll();

    UserDTO getById(long id);

    void deleteById(long id);

    UserDTO create(UserForm userform);
}

