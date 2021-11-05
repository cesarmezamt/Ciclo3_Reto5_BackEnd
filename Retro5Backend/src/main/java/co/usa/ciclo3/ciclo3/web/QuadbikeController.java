package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Quadbike;
import co.usa.ciclo3.ciclo3.service.QuadbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * <H2>Controlador Cuadrimoto</H2>
 * Controlador Cuadrimoto
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@RestController
@RequestMapping("/api/Quadbike")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class QuadbikeController {

    @Autowired
    private QuadbikeService quadbikeService;
/**
 * Controlador obtiene lista de Cuadrimotos
 * @return obtiene lista de Cuadrimotos
 */
    @GetMapping("/all")
    public List<Quadbike> getQuadbike(){
        return quadbikeService.getAll();
    }
    /**
     * Controlador obtiene lista de Cuadrimotos por id
     * @param qbikeId obtiene lista de Cuadrimotos por id
     * @return obtiene lista de Cuadrimotos por id
     */
    @GetMapping("/{id}")
    public Optional<Quadbike> getQuadbike(@PathVariable("id") int qbikeId){
        return quadbikeService.getQuadbike(qbikeId);
    }
/**
 * Controlador Salva lista de Cuadrimotos
 * @param quadbike Salva lista de Cuadrimotos
 * @return Salva lista de Cuadrimotos por id
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike save(@RequestBody Quadbike quadbike){
        return quadbikeService.save(quadbike);
    }
    /**
     * Controlador  actualiza lista de Cuadrimotos por id
     * @param quadbike actualiza lista de Cuadrimotos por id
     * @return actualiza lista de Cuadrimotos por id
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Quadbike update(@RequestBody Quadbike quadbike) {
        return quadbikeService.update(quadbike);
    }
    /**
     * Controlador borra lista de Cuadrimotos por id
     * @param qbikeId borra lista de Cuadrimotos por id
     * @return borra lista de Cuadrimotos por id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int qbikeId) {
        return quadbikeService.deleteQuadbike(qbikeId);
    } 
        
}
