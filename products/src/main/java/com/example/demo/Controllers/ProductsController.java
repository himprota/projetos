package com.example.demo.Controllers;


import com.example.demo.DTOS.ProductDTO;
import com.example.demo.Exceptions.UserNotFoundException;
import com.example.demo.Services.ProductService;
import com.example.demo.models.ProductModel;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.KeyAgreementSpi;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Object> teste() {
        if (productService.getAllProducts().isEmpty()) {
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOne(@PathVariable(value = "id") UUID id) throws UserNotFoundException {
        Optional<ProductModel> productModel = productService.findOneProduct(id);

        if (productModel.isEmpty()) {
            throw new UserNotFoundException("Usuario não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productModel);

    }

    @PostMapping("/products")
    public ResponseEntity<ProductModel> postProduct(@RequestBody @Valid ProductDTO productDTO) {
        var newProduct = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);


    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {

        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.deleteProduct(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductDTO productDTO) {


        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(id, productDTO));
    }
}
