package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <H2>MessageService</H2>
 * Servicio Mensajes
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@Service
public class MessageService {
    @Autowired
    private MessageRepository  messageRepository;
    /**
     * Servicio que obtiene la lista todos los elementos de Mensajes
     * @return Servicio que obtiene la lista todos los elementos de Mensajes
     */
    public List<Message> getAll(){
         return messageRepository.getAll();
    }
    /**
     * Servicio que obtiene la lista todos los elementos de Mensajes por id
     * @param messageId
     * @return Servicio que obtiene la lista todos los elementos de Mensajes por id
     */
    public Optional<Message> getMessage(int messageId){
        return messageRepository.getMessage(messageId);
    }
    
    /**
     * Servicio que salva la lista todos los elementos de Mensajes
     * @param message
     * @return Servicio que salva la lista todos los elementos de Mensajes
     */
    public Message save(Message message){
        if(message.getIdMessage()==null){
            return messageRepository.save(message);
        }else{
            Optional<Message> evt=messageRepository.getMessage(message.getIdMessage());
            if(evt.isEmpty()){
            return messageRepository.save(message);
            }else{
                return message;
            }
        
        
        }
    
    }
    /**
     * Servicio que actualiza la lista todos los elementos de Mensajes
     * @param message
     * @return Servicio que actualiza la lista todos los elementos de Mensajes
     */
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> men= messageRepository.getMessage(message.getIdMessage());
            if(!men.isEmpty()){
                if(message.getMessageText()!=null){
                    men.get().setMessageText(message.getMessageText());
                }
               messageRepository.save(men.get());
                return men.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    /**
     * Servicio que borra la lista todos los elementos de Mensajes
     * @param messageId
     * @return Servicio que borra la lista todos los elementos de Mensajes
     */
     public boolean deleteMessage(int messageId) {
        Boolean aBoolean;
        aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
