package asia.fourtitude.java.sboot.tonystark.controller.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * @see asia.fourtitude.java.sboot.tonystark.product_java.Product
 */
@Getter
@Setter
@Schema(description = "Request body for update product")
public class ProductUpdateDto {

    @Schema(description = "Product code", nullable = true)
    private String code;

    @Schema(description = "Product name", nullable = true)
    private String name;

    @Schema(description = "Product category", nullable = true)
    private String category;

    @Schema(description = "Product brand", nullable = true)
    private String brand;

    @Schema(description = "Product type", nullable = true)
    private String type;

    @Schema(description = "Product description", nullable = true)
    private String description;
}
