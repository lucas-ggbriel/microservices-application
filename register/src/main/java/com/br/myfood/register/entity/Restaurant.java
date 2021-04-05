package com.br.myfood.register.entity;

import com.br.myfood.register.dto.RestaurantDto;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String email;
    private String password;

    public static Restaurant create(RestaurantDto restaurantDto){
        return new ModelMapper().map(restaurantDto, Restaurant.class);
    }

}
