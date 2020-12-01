package be.ifosup.glvp.forms;

import be.ifosup.glvp.entities.Subcat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductForm implements Serializable {

    private Long id;
    private String productname;
    private Date rayon;
    private Date peremption;
    private Long id_subfk;
    private Long id_statfk;
    private Float price;
    private Integer quantities;

}
