package be.ifosup.glvp.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id_prod")
    private Long id;

    @NotNull
    @Column(name = "prod_name", nullable = false)
    private String product;  //Attention au nom de variable crée des erreurs

    @NotNull
    @Column(name = "rayon", nullable = false)
    private Date rayon;


    @Column(name = "peremption")
    private Date peremption;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_subfk")
    private Subcat sub_name;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_statfk")
    private Statut stat_name;

    @NotNull
    @Column(name = "price", nullable = false )
    private Float price;

    @NotNull
    @Column(name = "quantities", nullable = false )
    private Integer quantities;


}
