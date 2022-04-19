package asia.fourtitude.java.sboot.tonystark.controller.rest;

import asia.fourtitude.java.sboot.tonystark.common.PageRequestBuilder;
import asia.fourtitude.java.sboot.tonystark.controller.rest.dto.ProductCreateDto;
import asia.fourtitude.java.sboot.tonystark.controller.rest.dto.ProductUpdateDto;
import asia.fourtitude.java.sboot.tonystark.product_java.Product;
import asia.fourtitude.java.sboot.tonystark.services.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/products")
public class ProductRestController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
    })
    @Operation(summary = "Create product", description = "Create product")
    @PostMapping(value = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> create(@RequestBody ProductCreateDto dto) {
        final Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.ok(productServiceImpl.create(product));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
    })
    @Operation(summary = "Get product by code", description = "Get product by code")
    @GetMapping(value = "/{code}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> get(@PathVariable String code) {
        return ResponseEntity.ok(productServiceImpl.getByCode(code));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
    })
    @Operation(summary = "Get list of product", description = "Get list of product")
    @GetMapping(value = "", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Product>> list(@RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false, defaultValue = "10") int size) {
        return ResponseEntity.ok(productServiceImpl.list(PageRequestBuilder.getPageRequest(size, page, null)));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
    })
    @Operation(summary = "Update product by code", description = "Update product by code")
    @PutMapping(value = "/{code}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> update(@PathVariable String code, @Valid @RequestBody ProductUpdateDto dto) {
        final Product product = new Product();
        BeanUtils.copyProperties(dto, product);
        return ResponseEntity.ok(productServiceImpl.update(code, product));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found"),
    })
    @Operation(summary = "Delete product by code", description = "Delete product by code")
    @DeleteMapping(value = "/{code}")
    public void update(@PathVariable String code) {
        productServiceImpl.delete(code);
    }
}
