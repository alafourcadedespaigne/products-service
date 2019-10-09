package py.com.ale.productsservice.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import py.com.ale.productsservice.models.entity.Product;
import py.com.ale.productsservice.models.service.IProductService;

@RestController
public class ProductRestController {

  private final IProductService productService;

  public ProductRestController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/listar")
  public List <Product> listar() {
    return productService.findAll();
  }

  @GetMapping("ver/{id}")
  public Product detalle(@PathVariable Long id) {
    return productService.findById(id);
  }
}
