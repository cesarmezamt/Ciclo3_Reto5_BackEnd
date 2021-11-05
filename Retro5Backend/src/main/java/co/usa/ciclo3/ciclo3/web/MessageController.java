package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <H2>Controlador Mensaje</H2>
 * Controlador Mensaje
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MessageController {
    
    @Autowired
    private MessageService  messageService;
    /**
     * Controlador obtiene lista de Mensaje
     * @return Controlador obtiene lista de Mensaje
     */
    @GetMapping("/all")
    public List <Message> getMessage(){
        return messageService.getAll();
    }
    /**
     * Controlador obtiene lista de Mensaje por id
     * @param idMessage obtiene lista de Mensaje por id
     * @return Controlador obtiene lista de Mensaje por id
     */
    @GetMapping("/{id}")
    public Optional<Message> getReservation(@PathVariable("id") int idMessage) {
        return messageService.getMessage(idMessage);
    }
/**
 * Controlador salva lista de Mensaje
 * @param message salva lista de Mensaje 
 * @return salva lista de Mensaje 
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody Message message) {
        return messageService.save(message);
    }
    /**
     * Controlador actualiza lista de Mensaje 
     * @param message actualiza lista de Mensaje 
     * @return Controlador actualiza lista de Mensaje 
     */
     @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.update(message);
    }
    /**
     * Controlador Borra lista de Mensaje por id
     * @param messageId Borra lista de Mensaje por id
     * @return Controlador Borra lista de Mensaje por id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageService.deleteMessage(messageId);
    }
    
    
    
}
