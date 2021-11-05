package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Quadbike;
import co.usa.ciclo3.ciclo3.repository.crud.QuadbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <H2>QuadbikeRepository</H2>
 * Repositorio Cuadrimoto
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@Repository
public class QuadbikeRepository {

    @Autowired
    private QuadbikeCrudRepository quadbikeCrudRepository;
     /**
      * Obtiene la lista todos los elementos de Cuadrimotos
      * @return Obtiene la lista todos los elementos de Cuadrimotos
      */
    public List<Quadbike> getAll(){
        return (List<Quadbike>) quadbikeCrudRepository.findAll();
    }
    /**
     * Obtiene la lista todos los elementos de Cuadrimotos por id
     * @param id
     * @return Obtiene la lista todos los elementos de Cuadrimotos por id
     */
    public Optional<Quadbike> getQuadbike(int id){
        return  quadbikeCrudRepository.findById(id);
    }
    /**
     * Salva la lista todos los elementos de Cuadrimotos
     * @param quadbike
     * @return Salva la lista todos los elementos de Cuadrimotos
     */
    public Quadbike save(Quadbike quadbike){
        return quadbikeCrudRepository.save(quadbike);
    }
    /**
     * Borra la lista todos los elementos de Cuadrimotos
     * @param quadbike 
     */
    public void delete(Quadbike quadbike){
       quadbikeCrudRepository.delete(quadbike);
    }

}
