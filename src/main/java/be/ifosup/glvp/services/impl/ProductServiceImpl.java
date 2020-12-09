package be.ifosup.glvp.services.impl;


import be.ifosup.glvp.entities.Product;
import be.ifosup.glvp.entities.Statut;
import be.ifosup.glvp.forms.ProductForm;
import be.ifosup.glvp.helpers.ToModel;
import be.ifosup.glvp.repositories.ProductRepository;
import be.ifosup.glvp.repositories.StatutRepository;
import be.ifosup.glvp.repositories.SubcatRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;


import be.ifosup.glvp.models.ProductDTO;
import be.ifosup.glvp.services.ProductService;

import java.sql.Array;
import java.util.*;


@Service
public class ProductServiceImpl implements ProductService {
    @Qualifier("productRepository")
    @Autowired
    private ProductRepository productRepository;
    @Qualifier("statutRepository")
    @Autowired
    private StatutRepository statutRepository;
    @Qualifier("subcatRepository")
    @Autowired
    private SubcatRepository subcatRepository;

    @Autowired
    public ProductServiceImpl(
            @Qualifier("productRepository") ProductRepository productRepository,
            @Qualifier("statutRepository") StatutRepository statutRepository,
            @Qualifier("subcatRepository") SubcatRepository subcatRepository) {
        this.productRepository = productRepository;
        this.statutRepository = statutRepository;
        this.subcatRepository=subcatRepository;
    }




    @Override
    public void create(ProductForm productForm) {


        Product entity = Product.builder()
                .product(productForm.getProductname())
                .rayon(productForm.getRayon())
                .peremption(productForm.getPeremption())
                .sub_name(subcatRepository.findById(productForm.getId_subfk()).orElse(null))
//                .stat_name(statutRepository.findById(productForm.getId_statfk()).orElse((null)))
                .stat_name(statutRepository.findById(1))
                .price(productForm.getPrice())
                .quantities(productForm.getQuantities())
                .build();
        System.out.println(entity);
        Product product = productRepository.save(entity);
    }

    @Override
    public void update(ProductForm productForm) {
        Product entity = Product.builder()
                .id(productForm.getId())
                .product(productForm.getProductname())
                .rayon(productForm.getRayon())
                .peremption(productForm.getPeremption())
                .sub_name(subcatRepository.findById(productForm.getId_subfk()).orElse(null))
                .stat_name(statutRepository.findById(productForm.getId_statfk()).orElse((null)))
                .price(productForm.getPrice())
                .quantities(productForm.getQuantities())
                .build();
        Product product = productRepository.save(entity);
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
        Product product = productRepository.findByProduct(prodname);
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
    public Set<ProductDTO>getByCategory(long id){
        Set<Product> entities = new HashSet<>(productRepository.findAllById_subfk(id));
        return ToModel.getProductsFromEntities(entities);
    }

    @Override
    public Set<ProductDTO>getBysubCategory(long id){
        Set<Product> entities = new HashSet<>(productRepository.findAllById_subcatfk(id));
        return ToModel.getProductsFromEntities(entities);
    }

    @Override
    public Set<ProductDTO>getBystatut(long id){
        Set<Product> entities = new HashSet<>(productRepository.findAllById_statfk(id));
        return ToModel.getProductsFromEntities(entities);
    }

    @Override
    public Set<ProductDTO> getAll() {
        Set<Product> entities = new HashSet<>(productRepository.findAll());
        return ToModel.getProductsFromEntities(entities);
    }
}