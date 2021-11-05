package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <H2>CategoryRepository</H2>
 * Repositorio Mesanjes
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    /**
     * Obtiene la lista todos los elementos de Mesanjes
     * @return Obtiene la lista todos los elementos de Mesanjes
     */
    public List<Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    /**
     * Obtiene la lista todos los elementos de Mesanjes por id
     * @param id
     * @return la lista todos los elementos de Mesanjes por id
     */
    public Optional <Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    /**
     * Salva la lista todos los elementos de Mesanjes
     * @param message
     * @return Salva la lista todos los elementos de Mesanjes
     */
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    /**
     * Borra la lista de todos los elementos de Mesanjes
     * @param message 
     */
     public void delete(Message message){
        messageCrudRepository.delete(message);
    }
     
}
    
    

