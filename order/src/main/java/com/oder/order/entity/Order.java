package com.oder.order.entity;

import com.oder.order.dto.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long id_client;
    private Long id_restaurant;
    private Long id_menu;

    public static Order create(OrderDto orderDto){
        return new Order(null, orderDto.getId_client(), orderDto.getId_restaurant(), orderDto.getId_restaurant());
    }
}
