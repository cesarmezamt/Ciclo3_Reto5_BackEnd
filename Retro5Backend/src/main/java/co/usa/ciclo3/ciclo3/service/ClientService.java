package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <H2>ClientService</H2>
 * Servicio Cliente
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
/**
 * Servicio que obtiene la lista todos los elementos de Cliente
 * @return Servicio que obtiene la lista todos los elementos de Cliente
 */
    public List<Client> getAll(){
        return  clientRepository.getAll();
    }
 /**
  * Servicio que obtiene la lista todos los elementos de Cliente por id
  * @param clientId
  * @return Servicio que obtiene la lista todos los elementos de Cliente por id
  */
    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient( clientId);
    }
/**
 * Servicio que salva la lista todos los elementos de Cliente
 * @param client
 * @return Servicio que salva la lista todos los elementos de Cliente
 */
    public Client save(Client client){
        if(client.getIdClient()==null){
            return clientRepository.save(client);
        }else{
            Optional<Client> paux=clientRepository.getClient(client.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
    /**
     * Servicio que actualiza la lista todos los elementos de Cliente
     * @param client
     * @return Servicio que actualiza la lista todos los elementos de Cliente
     */
        public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> cli= clientRepository.getClient(client.getIdClient());
            if(!cli.isEmpty()){
                if(client.getName()!=null){
                    cli.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    cli.get().setAge(client.getAge());
                }
                if(client.getEmail()!=null){
                    cli.get().setEmail(client.getEmail());
                }       
                if(client.getPassword()!=null){
                    cli.get().setPassword(client.getPassword());
                }
                clientRepository.save(cli.get());
                return cli.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
      /**
       * Servicio que borra la lista todos los elementos de Cliente
       * @param clientId
       * @return Servicio que borra la lista todos los elementos de Cliente
       */ 
        public boolean deleteClient(int clientId) {
        Boolean aBoolean;
        aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
        
}
