package py.com.ale.productsservice.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import py.com.ale.productsservice.models.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository <Product, Long> {



}
