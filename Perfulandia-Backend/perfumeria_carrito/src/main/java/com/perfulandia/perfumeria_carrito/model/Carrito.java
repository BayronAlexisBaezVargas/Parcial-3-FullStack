package com.perfulandia.perfumeria_carrito.model;

//Aaa
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
@Schema(description = "Entidad que representa el carrito de compra de la tienda")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Carrito {
    @Schema(description = "ID autogenerado con Identity", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Cantidad de productos que puede tener el carrito", example = "12")
    private int cantidad_productos;

    @Schema(description = "Total del carrito", example = "1200")
    private double total;

    @Schema(description = "Nombre del usuario que creo el carrito",example = "Versage")
    private String usuario;
}
