package asia.fourtitude.java.sboot.tonystark.controller.rest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @see asia.fourtitude.java.sboot.tonystark.product_java.Product
 */
@Getter
@Setter
@Schema(description = "Request body for create product")
public class ProductCreateDto {

    @Schema(description = "Product code")
    @NotBlank
    private String code;

    @Schema(description = "Product name")
    @NotBlank
    private String name;

    @Schema(description = "Product category")
    @NotBlank
    private String category;

    @Schema(description = "Product brand", nullable = true)
    private String brand;

    @Schema(description = "Product type", nullable = true)
    private String type;

    @Schema(description = "Product description", nullable = true)
    private String description;
}
