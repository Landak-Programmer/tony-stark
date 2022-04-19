package asia.fourtitude.java.sboot.tonystark.services;

import asia.fourtitude.java.sboot.tonystark.product_java.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IProductService {
    Product create(Product product);

    Product getById(Integer id);

    Product getByCode(String code);

    Page<Product> list(PageRequest pageRequest);

    Product update(String code, Product changeSet);

    Product update(Integer id, Product changeSet);

    Product doUpdate(Product pProduct, Product changeSet);

    void delete(String code);
}
