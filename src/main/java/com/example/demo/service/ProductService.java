package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repos.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Getter
@Service
public class ProductService {
    ProductRepository repo;
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }
    public List<Product> getProducts() {
            return repo.findAll();
    }

    public Product getProduct(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        return repo.save(product);
    }

    public Product updateProduct(int id,Product product,MultipartFile imgFile) throws IOException {
        product.setImageName(imgFile.getOriginalFilename());
        product.setImageType(imgFile.getContentType());
        product.setImageData(imgFile.getBytes());
        return repo.save(product);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    @Transactional
    public List<Product> searchProducts(String keyword) {
        return repo.searchProduct(keyword);
    }
}
