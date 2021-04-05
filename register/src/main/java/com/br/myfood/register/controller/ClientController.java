package com.br.myfood.register.controller;

import com.br.myfood.register.dto.ClientDto;
import com.br.myfood.register.entity.Client;
import com.br.myfood.register.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/listing/{id}")
    public ResponseEntity findById(@PathVariable long id) {
        Client client =  clientService.findById(id);
         return client != null ? ResponseEntity.ok(client) : ResponseEntity.badRequest().body("The id doesn't exist!");
    }

    @PostMapping("/insert")
    public ResponseEntity insertClient(@RequestBody ClientDto clientDto) {
        try {
            return ResponseEntity.ok(clientService.insertClient(Client.create(clientDto)));
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ClientDto clientDto) {
        Client client = Client.create(clientDto);
        client.setId(id);

        if (clientService.updateClient(client) != null) {
            return ResponseEntity.ok(clientService.updateClient(client));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable long id) {
        return clientService.delete(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
