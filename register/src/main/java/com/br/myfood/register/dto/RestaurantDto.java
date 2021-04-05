package com.br.myfood.register.dto;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String name;
    private String email;
    private String password;

}
