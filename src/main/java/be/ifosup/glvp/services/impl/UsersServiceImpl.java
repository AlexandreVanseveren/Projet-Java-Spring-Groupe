package be.ifosup.glvp.services.impl;


import be.ifosup.glvp.constants.RoleEnum;

import be.ifosup.glvp.forms.UserForm;
import be.ifosup.glvp.helpers.ToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;



import be.ifosup.glvp.entities.User;
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.repositories.UserRepository;
import be.ifosup.glvp.services.UserService;

import java.util.*;

@Service
public class UsersServiceImpl implements UserService {
    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UsersServiceImpl(
        @Qualifier("userRepository") UserRepository userRepository) {
            this.userRepository = userRepository;
    }

    @Override
    public void create(UserForm userform) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword = bCryptPasswordEncoder.encode(userform.getPassword());
        List<RoleEnum> roleEnums = new ArrayList<>();
        roleEnums.add(RoleEnum.USER);
       User entity = User.builder()
                .username(userform.getUsername())
                .lastname(userform.getLastname())
                .firstname(userform.getFirstname())
                .password(encodePassword)
                .roles(roleEnums)
                .enabled(true)
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .build();
        User user = userRepository.save(entity);

    }

    @Override
    public void deleteById(long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }


    @Override
    public UserDTO getById(long id) {
        User entity = userRepository.findById(id);

        UserDTO user = entity == null ? null : ToModel.getUserFromEntity(entity);

        return user;
    }

    @Override
    public UserDTO getUser(String username) {
        User user = userRepository.findByUsername(username); //recherche en fonction du username
        //Constructeur d'objet
        UserDTO userDTO = UserDTO.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .id(user.getId())
                .username(user.getUsername())
                .build();

        return userDTO;
    }

    @Override
    public Set<UserDTO> getAll() {
        Set<User> entities = new HashSet<>(userRepository.findAll());
        return ToModel.getUsersFromEntities(entities);
    }

}
