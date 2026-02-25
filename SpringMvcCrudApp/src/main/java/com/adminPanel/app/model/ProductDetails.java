package com.adminPanel.app.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @NotNull(message = "Expiration date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "expiration_date")
    private Date expirationDate;

    @NotBlank(message = "manufacturer is required")
    @Column(name = "manufacturer")
    private String manufacturer;

    @DecimalMin(value = "0.01", message = "Price must be > 0")
    @NotNull(message = "price is required")
    @Column(name = "price")
    private double price;

    @NotNull(message = "availability is required")
    @Column(name = "available")
    private Boolean available;

    @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL)
    private Product product;

}
