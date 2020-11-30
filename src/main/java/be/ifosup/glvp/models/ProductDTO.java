package be.ifosup.glvp.models;

import be.ifosup.glvp.entities.Statut;
import be.ifosup.glvp.entities.Subcat;
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
    private Subcat id_subfk;
    private Statut id_statfk;
    private Float price;
    private Integer quantities;

}