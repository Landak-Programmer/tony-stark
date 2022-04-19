package asia.fourtitude.java.sboot.tonystark.controller;

import asia.fourtitude.java.sboot.tonystark.common.PageRequestBuilder;
import asia.fourtitude.java.sboot.tonystark.product_java.Product;
import asia.fourtitude.java.sboot.tonystark.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping(value = {"/", "index.html"})
    public String index(Model model,
                        @RequestParam(required = false, defaultValue = "0") int page,
                        @RequestParam(required = false, defaultValue = "10") int size) {
        model.addAttribute("list",
                productServiceImpl.list(PageRequestBuilder.getPageRequest(size, page, null)));
        model.addAttribute("pageSize", size);
        return "index";
    }

    @GetMapping(value = {"/add"})
    public String add() {
        return "add";
    }

    @PostMapping(value = {"/create"})
    public String create(
            @RequestParam String code,
            @RequestParam String name,
            @RequestParam String category,
            @RequestParam String brand,
            @RequestParam String type,
            @RequestParam String description
    ) {
        final Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setCategory(category);
        product.setBrand(brand);
        product.setType(type);
        product.setDescription(description);
        productServiceImpl.create(product);
        return "redirect:/";
    }

    @GetMapping(value = {"/edit/{id}"})
    public String edit(@PathVariable Integer id, Model model) {
        final Product product = productServiceImpl.getById(id);
        model.addAttribute("product", product);
        return "edit";
    }

    @PostMapping(value = {"/update/{id}"})
    public String update(@PathVariable Integer id,
                         @RequestParam String code,
                         @RequestParam String name,
                         @RequestParam String category,
                         @RequestParam String brand,
                         @RequestParam String type,
                         @RequestParam String description) {
        final Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setCategory(category);
        product.setBrand(brand);
        product.setType(type);
        product.setDescription(description);
        productServiceImpl.update(id, product);
        return "redirect:/";
    }

}
