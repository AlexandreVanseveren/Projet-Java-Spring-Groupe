package be.ifosup.glvp.services.impl;


import be.ifosup.glvp.entities.Product;
import be.ifosup.glvp.forms.ProductForm;
import be.ifosup.glvp.helpers.ToModel;
import be.ifosup.glvp.repositories.ProductRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import be.ifosup.glvp.models.ProductDTO;
import be.ifosup.glvp.services.ProductService;

import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {
    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(
            @Qualifier("productRepository") ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO create(ProductForm productForm) {
        Product entity = Product.builder()
                .product(productForm.getProductname())
                .rayon(productForm.getRayon())
                .peremption(productForm.getPeremption())
                .build();
        Product product = productRepository.save(entity);
        return ToModel.getProductFromEntity(product);

    }

    @Override
    public void deleteById(long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
    }


    @Override
    public ProductDTO getById(long id) {
        Product entity = productRepository.findById(id);

        ProductDTO product = entity == null ? null : ToModel.getProductFromEntity(entity);

        return product;
    }

    @Override
    public ProductDTO getprodname(String prodname) {
        Product product = productRepository.findByProduct(prodname); //recherche en fonction du username
        //Constructeur d'objet
        ProductDTO productDTO =ProductDTO.builder()
                .id(product.getId())
                .productname(product.getProduct())
                .rayon(product.getRayon())
                .peremption(product.getPeremption())
//                .id_statfk(product.getStat_name())
//                .id_subfk(product.getSub_name())
                .price(product.getPrice())
                .quantities(product.getQuantities())
                .build();

        return productDTO;
    }

    @Override
    public Set<ProductDTO> getAll() {
        Set<Product> entities = new HashSet<>(productRepository.findAll());
        return ToModel.getProductsFromEntities(entities);
    }

}