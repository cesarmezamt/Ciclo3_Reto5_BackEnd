package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <H2>ClientRepository</H2>
 * Repositorio Cliente
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;
    /**
     * obtiene la lista todos los elementos de Clientes
     * @return obtiene la lista todos los elementos de Clientes
     */
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    /**
     * obtiene la lista todos los elementos de Clientes por id
     * @param id
     * @return Obtiene la lista todos los elementos de Clientes por id
     */
    public Optional <Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }
    /**
     * Salva la lista todos los elementos de Clientes
     * @param client
     * @return  Salva la lista todos los elementos de Clientes
     */
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    /**
     * Borra la lista de todos los elementos de Clientes
     * @param client 
     */
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }
    
}
