package be.ifosup.glvp.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "statut")
@Data
public class Statut {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_stat")
    private Long id_stat;

    @NotNull
    @Column(name = "stat_name", nullable = false, unique = true)
    private String stat_name;

}