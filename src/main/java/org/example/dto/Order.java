package org.example.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Integer id;
    private String name;
    private int quantity;
    private double unit_price;
    private double total;

}
