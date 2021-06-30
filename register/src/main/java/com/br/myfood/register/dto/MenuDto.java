package com.br.myfood.register.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuDto {

    private String name;
    private Double price;
    private Long restaurant;
}
