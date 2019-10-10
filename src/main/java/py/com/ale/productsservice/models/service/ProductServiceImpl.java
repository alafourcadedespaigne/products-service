package py.com.ale.productsservice.models.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.ale.productsservice.models.entity.Product;
import py.com.ale.productsservice.models.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(
      ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List <Product> findAll() {
    return (List <Product>) productRepository.findAll();
  }

  @Override
  public Product findById(Long id) {

    return productRepository.findById(id).orElse(null);
  }
}
