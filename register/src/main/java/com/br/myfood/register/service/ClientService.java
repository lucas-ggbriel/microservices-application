package com.br.myfood.register.service;

import com.br.myfood.register.entity.Client;
import com.br.myfood.register.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client insertClient(Client client){
        return clientRepository.save(client);
    }

    public  Client updateClient(Client client){
        Optional<Client> clientS = clientRepository.findById(client.getId());

        return clientS.isEmpty() ?
                null :
                clientRepository.save(client);
    }

    public boolean delete(long id){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            clientRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Client findById(long id){
        Optional<Client> client = clientRepository.findById(id);

        return client.isPresent() ? client.get() : null;
    }

}
