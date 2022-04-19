package asia.fourtitude.java.sboot.tonystark.repository;

import asia.fourtitude.java.sboot.tonystark.product_java.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByCode(String code);
}
