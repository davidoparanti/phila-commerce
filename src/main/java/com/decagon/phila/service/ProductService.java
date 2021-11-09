package com.decagon.phila.service;

import com.decagon.phila.model.Product;
import com.decagon.phila.model.ProductPage;
import com.decagon.phila.payload.request.ProductRequest;
import org.springframework.data.domain.Page;


public interface ProductService {
    Page<Product> getAllProducts(ProductPage productPage);
    Page<Product> searchAllProducts(String keyword);
    Page<Product> getProductsByCategory(ProductPage productPage, String categoryName);
    Page<Product> getProductsByCategoryAndSubCategory(ProductPage productPage,
                                                      String categoryName, String subCategoryName);
    Product saveProduct(ProductRequest productRequest);
    Product updateProduct(Long productId, ProductRequest productRequest);
    void deleteProduct(Long productId);
    Product getProductById(Long id);

}
