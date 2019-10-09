package py.com.ale.productsservice.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import py.com.ale.productsservice.models.entity.Product;
import py.com.ale.productsservice.models.service.IProductService;

@RestController
public class ProductRestController {

    private final IProductService productService;

    @Autowired
    private Environment environment;

    @Value("${server.port}")
    private Integer port;

    public ProductRestController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/listar")
    public List<Product> listar() {
        return productService.findAll().stream().map(product -> {
            product.setPort(port);
            return product;
        }).collect(Collectors.toList());
    }

    @GetMapping("ver/{id}")
    public Product detalle(@PathVariable Long id) {
        Product product = productService.findById(id);
        product.setPort(port);
        return product;
    }
}
