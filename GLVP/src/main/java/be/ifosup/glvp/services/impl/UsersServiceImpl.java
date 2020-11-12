package be.ifosup.glvp.services.impl;


    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import be.ifosup.glvp.entities.User;
import be.ifosup.glvp.models.UserDTO;
import be.ifosup.glvp.repositories.UserRepository;
import be.ifosup.glvp.services.UserService;

    @Service
    public class UsersServiceImpl implements UserService {

        private final UserRepository userRepository;

        @Autowired
        public UsersServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
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
    }

