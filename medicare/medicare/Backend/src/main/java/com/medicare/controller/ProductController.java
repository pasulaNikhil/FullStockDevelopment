package com.medicare.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicare.dto.ProductDto;
import com.medicare.model.Product;
import com.medicare.services.CategoryService;
import com.medicare.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {
    

  @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    public static String productImageUploadDir = System.getProperty("user.dir") + 
                         "/src/main/resources/static/images";
    public static String defaultImage = "default.jpg";

     @PostMapping("/")
    public ResponseEntity<Product> postProductsAdd(@RequestParam("product") String productDtoString,
                                                   @RequestParam("image") MultipartFile image
                                   ) throws IOException{

        ProductDto productDTO = new ObjectMapper().readValue(productDtoString, ProductDto.class);
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setCategory(this.categoryService.getCategory(productDTO.getCategoryId()).get());
        product.setWeight(productDTO.getWeight());
        product.setStockCount(productDTO.getStockCount());
        product.setPrice(productDTO.getPrice());
        product.setBrand(productDTO.getBrand());
        product.setDescription(productDTO.getDescription());
        String imageUUID;
     
        if(image.isEmpty()){
            imageUUID = defaultImage;
        }else{
            imageUUID = image.getOriginalFilename();
            Path fileNameAndPath = Paths.get(productImageUploadDir, imageUUID);
            Files.write(fileNameAndPath, image.getBytes());
        }
        product.setImageName(imageUUID);
     
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/")
    public List<Product> getProducts(){
        return this.productService.getAlProducts();
    }

      @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id){
        Optional<Product> product =  this.productService.getProductById(id);
        if(product.isEmpty()){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.productService.getProductById(1).get());
        }
        return ResponseEntity.ok(product.get());
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        this.productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") long id ,@RequestBody ProductDto productDTO){
        Product product = this.productService.getProductById(id).get();
        product.setName(productDTO.getName());
        product.setCategory(this.categoryService.getCategory(productDTO.getCategoryId()).get());
        product.setWeight(productDTO.getWeight());
        product.setStockCount(productDTO.getStockCount());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setBrand(productDTO.getBrand());
        return this.productService.updateProduct(id, product);
    }

    @GetMapping("/category/{id}")
    public List<Product> getProductByCategory(@PathVariable("id") int id) {
        return this.productService.getProductByCategoryId(id);
    }

    @GetMapping("/search/{query}")
    public List<Product> getProductsByQuery(@PathVariable("query") String query ){
      return this.productService.getProductsByQuery(query);
    }
        
}