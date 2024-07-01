package com.example.demo.Services;


import com.example.demo.DTOS.ProductDTO;
import com.example.demo.models.ProductModel;
import com.example.demo.repositories.ProductsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {


    @Autowired
    private ProductsRepository productRepository;

    public List<ProductModel> getAllProducts() {

        return productRepository.findAll();

    }

    public ProductModel createProduct(ProductDTO productDTO) {
        ProductModel productModel = new ProductModel();
        BeanUtils.copyProperties(productDTO, productModel);
        return productRepository.save(productModel);

    }

    public Optional<ProductModel> findOneProduct(UUID id) {
        Optional<ProductModel> targetProduct = productRepository.findById(id);
        if (targetProduct.isEmpty()) {
            return Optional.empty();
        }
        return targetProduct;
    }

    public String deleteProduct(UUID id) {
        Optional<ProductModel> targetProduct = productRepository.findById(id);
        if (targetProduct.isEmpty()) {
            return "Não existe o produto, portanto não pode ser deletado";
        }
        productRepository.delete(targetProduct.get());
        return "Produto deletado com sucesso";
    }

    public Optional<Object> updateProduct(UUID id, ProductDTO productDTO){
        Optional<ProductModel> targetProduct = productRepository.findById(id);
        if(targetProduct.isEmpty()){
            return Optional.empty();

        }
        ProductModel productModel = targetProduct.get();
        BeanUtils.copyProperties(productDTO, productModel);
        return Optional.of(productRepository.save(productModel));
    }


}
