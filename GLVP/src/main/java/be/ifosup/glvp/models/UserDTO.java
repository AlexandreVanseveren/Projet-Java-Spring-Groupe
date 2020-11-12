package be.ifosup.glvp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder

    //Génération de l'objet avec tout ces arguments
    public class UserDTO {
        private Long id;
        private String username;
        private String lastname;
        private String firstname;
    }


