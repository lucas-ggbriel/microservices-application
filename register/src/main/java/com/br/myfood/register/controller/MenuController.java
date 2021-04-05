package com.br.myfood.register.controller;

import com.br.myfood.register.dto.ClientDto;
import com.br.myfood.register.dto.MenuDto;
import com.br.myfood.register.entity.Client;
import com.br.myfood.register.entity.Menu;
import com.br.myfood.register.service.ClientService;
import com.br.myfood.register.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        Menu menu = menuService.findById(id);
         return menu != null ? ResponseEntity.ok(menu) : ResponseEntity.badRequest().body("The id doesn't exist!");
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody MenuDto menuDto) {
        try {
            Menu menu = menuService.insertMenu(menuDto);
          return  menu != null ?
                  ResponseEntity.ok(menu):
                  ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody MenuDto menuDto) {
        Menu menu = Menu.create(menuDto);
        menu.setId(id);

        if (menuService.updateClient(menu, menuDto.getRestaurant()) != null) {
            return ResponseEntity.ok(menuService.updateClient(menu, menuDto.getRestaurant()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable long id) {
        return menuService.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
