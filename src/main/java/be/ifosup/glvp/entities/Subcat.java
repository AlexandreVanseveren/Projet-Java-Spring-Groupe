package be.ifosup.glvp.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subcat")
@Data
public class Subcat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sub")
    private Long id_sub;

    @NotNull
    @Column(name = "sub_name", nullable = false, unique = true)
    private String sub_name;


    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "id_catfk")
    private Category cat_name;


}