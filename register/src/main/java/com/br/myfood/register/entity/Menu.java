package com.br.myfood.register.entity;

import com.br.myfood.register.dto.MenuDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Double price;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public static Menu create(MenuDto menuDto){
        return new ModelMapper().map(menuDto, Menu.class);
    }
}
