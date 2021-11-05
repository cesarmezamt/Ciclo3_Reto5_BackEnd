package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.service.ClientService;
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
 * <H2>Controlador Cliente</H2>
 * Controlador Cliente
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ClientController {
    
    @Autowired
    private ClientService clientService;
/**
 * Controlador obtiene lista de Cliente
 * @return  Controlador obtiene lista de Cliente
 */
    @GetMapping("/all")
    public List<Client> getClient(){
        return clientService.getAll();
    }
    /**
     *  Controlador obtiene lista de Cliente por id
     * @param idClient Controlador obtiene lista de Cliente por id
     * @return Controlador obtiene lista de Cliente por id
     */
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient){
        return clientService.getClient(idClient);
    }
/**
 * Controlador salva lista de Cliente
 * @param cl salva lista de Cliente
 * @return Controlador salva lista de Cliente
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client cl){
        return clientService.save(cl);
    }
    /**
     * Controlador actualiza Cliente
     * @param client Controlador actualiza  Cliente
     * @return Controlador actualiza  Cliente
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client) {
        return clientService.update(client);
    }
    /**
     * Controlador borra lista de Cliente
     * @param clientId borra Cliente
     * @return Controlador borra Cliente
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId) {
        return clientService.deleteClient(clientId);
    }
     
}
