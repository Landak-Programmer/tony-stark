package asia.fourtitude.java.sboot.tonystark.services;

import asia.fourtitude.java.sboot.tonystark.product_java.Product;
import asia.fourtitude.java.sboot.tonystark.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends BaseService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(final Product product) {
        checkNullInput(product);
        return productRepository.save(product);
    }

    @Override
    public Product getById(final Integer id) {
        return productRepository.getById(id);
    }

    @Override
    public Product getByCode(final String code) {
        return productRepository.findByCode(code);
    }

    @Override
    public Page<Product> list(final PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    @Override
    public Product update(final String code, final Product changeSet) {
        final Product pProduct = getByCode(code);
        return doUpdate(pProduct, changeSet);
    }

    @Override
    public Product update(final Integer id, final Product changeSet) {
        final Product pProduct = getById(id);
        return doUpdate(pProduct, changeSet);
    }

    @Override
    public Product doUpdate(final Product pProduct, final Product changeSet) {
        if (isChanged(pProduct.getCode(), changeSet.getCode())) {
            pProduct.setCode(changeSet.getCode());
        }

        if (isChanged(pProduct.getName(), changeSet.getName())) {
            pProduct.setName(changeSet.getName());
        }

        if (isChanged(pProduct.getCategory(), changeSet.getCategory())) {
            pProduct.setCategory(changeSet.getCategory());
        }

        if (isChanged(pProduct.getBrand(), changeSet.getBrand())) {
            pProduct.setBrand(changeSet.getBrand());
        }

        if (isChanged(pProduct.getType(), changeSet.getType())) {
            pProduct.setType(changeSet.getType());
        }

        if (isChanged(pProduct.getDescription(), changeSet.getDescription())) {
            pProduct.setDescription(changeSet.getDescription());
        }

        checkNullInput(pProduct);
        return productRepository.save(pProduct);
    }

    @Override
    public void delete(final String code) {
        final Product product = this.getByCode(code);
        productRepository.deleteById(product.getId());
    }

    private void checkNullInput(Product product) {
        if (product.getBrand().equalsIgnoreCase("*null*")) {
            product.setBrand(null);
        }

        if (product.getType().equalsIgnoreCase("*null*")) {
            product.setType(null);
        }

        if (product.getDescription().equalsIgnoreCase("*null*")) {
            product.setDescription(null);
        }
    }
}
