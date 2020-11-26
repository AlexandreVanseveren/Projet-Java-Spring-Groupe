package be.ifosup.glvp.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cat")
    private Long id_cat;

    @NotNull
    @Column(name = "cat_name", nullable = false, unique = true)
    private String cat_name;

}
