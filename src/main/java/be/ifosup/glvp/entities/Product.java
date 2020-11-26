package be.ifosup.glvp.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_prod")
    private Long id;

    @NotNull
    @Column(name = "prod_name", nullable = false)
    private String prod_name;

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
}
