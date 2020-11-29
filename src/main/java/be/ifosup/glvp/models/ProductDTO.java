package be.ifosup.glvp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

//Génération de l'objet avec tout ces arguments
public class ProductDTO {
    private Long id;
    private String productname;
    private Date rayon;
    private Date peremption;
    private Long id_subfk;
    private Long id_statfk;
    private Float price;
    private Integer quantities;

}