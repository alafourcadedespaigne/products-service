package py.com.ale.productsservice.models.service;

import java.util.List;
import py.com.ale.productsservice.models.entity.Product;

public interface IProductService {

  List<Product> findAll();
  Product findById(Long id);
}
