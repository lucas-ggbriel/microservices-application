package com.br.myfood.register.dto;

import com.br.myfood.register.entity.Restaurant;
import lombok.*;

import javax.persistence.*;

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
