package be.ifosup.glvp.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm implements Serializable {

    private String lastname;
    private String firstname;
    private String username;
    private String password;
    private  String role;
}
