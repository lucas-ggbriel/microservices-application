package com.br.myfood.register.service;

import com.br.myfood.register.dto.MenuDto;
import com.br.myfood.register.dto.MenuOrderDto;
import com.br.myfood.register.entity.Menu;
import com.br.myfood.register.entity.Restaurant;
import com.br.myfood.register.messages.MenuMessage;
import com.br.myfood.register.repository.MenuRepository;
import com.br.myfood.register.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuMessage menuMessage;

    @Autowired
    public MenuService(final MenuRepository menuRepository, final RestaurantRepository restaurantRepository, final MenuMessage menuMessage) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
        this.menuMessage = menuMessage;
    }

    public Menu insertMenu(MenuDto menuDto){
        Optional<Restaurant> restaurant = restaurantRepository.findById(menuDto.getRestaurant());
        if (restaurant.isPresent()){
            Menu menu = Menu.create(menuDto);
            menu.setRestaurant(restaurant.get());
            Menu menuSave =  menuRepository.save(menu);
            menuMessage.sendMessage(new MenuOrderDto(menuSave.getId()));
            return menuSave;
        }else {
            return null;
        }

    }

    public  Menu updateClient(Menu menu, long id){
        Optional<Menu> menuS = menuRepository.findById(menu.getId());
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isPresent()){
            menu.setRestaurant(restaurant.get());
            return menuS.isEmpty() ?
                    null :
                    menuRepository.save(menu);
        }else{
            return null;
        }
    }

    public boolean delete(long id){
        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()){
            menuRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Menu findById(long id){
        Optional<Menu> menu = menuRepository.findById(id);

        return menu.isPresent() ? menu.get() : null;
    }

}
