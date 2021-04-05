package com.br.myfood.register.service;

import com.br.myfood.register.entity.Client;
import com.br.myfood.register.entity.Restaurant;
import com.br.myfood.register.repository.ClientRepository;
import com.br.myfood.register.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant insertRestaurant(Restaurant restaurant){

        return restaurantRepository.save(restaurant);
    }

    public  Restaurant updateRestaurant(Restaurant restaurant){
        Optional<Restaurant> restaurantS = restaurantRepository.findById(restaurant.getId());

        return restaurantS.isEmpty() ?
                null :
                restaurantRepository.save(restaurant);
    }

    public boolean delete(long id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            restaurantRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Restaurant findById(long id){
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        return restaurant.isPresent() ? restaurant.get() : null;
    }

}
