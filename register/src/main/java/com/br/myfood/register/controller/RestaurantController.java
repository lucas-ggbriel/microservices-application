package com.br.myfood.register.controller;

import com.br.myfood.register.dto.RestaurantDto;
import com.br.myfood.register.entity.Restaurant;
import com.br.myfood.register.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        Restaurant restaurant =  restaurantService.findById(id);
         return restaurant != null ? ResponseEntity.ok(restaurant) : ResponseEntity.badRequest().body("The restaurant doesn't exist!");
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody RestaurantDto restaurantDto) {
        try {
            return ResponseEntity.ok(restaurantService.insertRestaurant(Restaurant.create(restaurantDto)));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto) {
        Restaurant restaurant = Restaurant.create(restaurantDto);
        restaurant.setId(id);

        if (restaurantService.updateRestaurant(restaurant) != null) {
            return ResponseEntity.ok(restaurantService.updateRestaurant(restaurant));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable long id) {
        return restaurantService.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
