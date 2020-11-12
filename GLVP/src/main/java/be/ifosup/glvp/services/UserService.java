package be.ifosup.glvp.services;

    import be.ifosup.glvp.models.UserDTO;
//Objet créer en fonction du login
    public interface UserService {
        UserDTO getUser(String username);
    }

