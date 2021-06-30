package com.br.myfood.register.service;

import com.br.myfood.register.dto.ClientOrderDto;
import com.br.myfood.register.entity.Client;
import com.br.myfood.register.repository.ClientRepository;
import com.br.myfood.register.messages.ClientMessage;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMessage clientMessage;

    public ClientService(ClientRepository clientRepository, ClientMessage clientMessage) {
        this.clientRepository = clientRepository;
        this.clientMessage = clientMessage;
    }

    public Client insertClient(Client client){
        Client clientSave = clientRepository.save(client);
        clientMessage.sendMessage(new ClientOrderDto(client.getId()));
        return clientSave;
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
