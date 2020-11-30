package be.ifosup.glvp.models;

import be.ifosup.glvp.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubcatDTO {
    private Long id;
    private String subcat;
    private Category id_catfk;
}
