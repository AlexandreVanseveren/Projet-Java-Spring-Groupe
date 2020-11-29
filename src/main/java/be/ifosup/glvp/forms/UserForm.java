package be.ifosup.glvp.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


//Facultatif pour l instant
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {

    @NotEmpty(message = "{error.email.empty}")

    private String lastname;

    private String firstname;

    private String username;

    private String password;

    private  String role;

}
