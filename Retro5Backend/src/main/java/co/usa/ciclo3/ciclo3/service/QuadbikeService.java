package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Quadbike;
import co.usa.ciclo3.ciclo3.repository.QuadbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <H2>QuadbikeService</H2>
 * Servicio Cuadrimotos
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Service
public class QuadbikeService {

    @Autowired
    private QuadbikeRepository quadbikeRepository;

    /**
     * Servicio que obtiene la lista todos los elementos de Cuadrimotos
     * @return Servicio que obtiene la lista todos los elementos de Cuadrimotos
     */
    public List<Quadbike> getAll() {
        return quadbikeRepository.getAll();
    }

    /**
     * Servicio que obtiene la lista todos los elementos de Cuadrimotos por id
     * @param idquadbike
     * @return Servicio que obtiene la lista todos los elementos de Cuadrimotos por id
     */
    public Optional<Quadbike> getQuadbike(int idquadbike) {
        return quadbikeRepository.getQuadbike(idquadbike);
    }

    /**
     * Servicio que salva la lista todos los elementos de Cuadrimotos
     * @param quadbike
     * @return Servicio que salva la lista todos los elementos de Cuadrimotos
     */
    public Quadbike save(Quadbike quadbike) {
        if (quadbike.getId() == null) {
            return quadbikeRepository.save(quadbike);
        } else {
            Optional<Quadbike> paux = quadbikeRepository.getQuadbike(quadbike.getId());
            if (paux.isEmpty()) {
                return quadbikeRepository.save(quadbike);
            } else {
                return quadbike;
            }
        }
    }

    /**
     * Servicio que actualiza la lista todos los elementos de Cuadrimotos
     * @param quadbike
     * @return Servicio que actualiza la lista todos los elementos de Cuadrimotos
     */
    public Quadbike update(Quadbike quadbike) {
        if (quadbike.getId() != null) {
            Optional<Quadbike> qbike = quadbikeRepository.getQuadbike(quadbike.getId());
            if (!qbike.isEmpty()) {
                if (quadbike.getName() != null) {
                    qbike.get().setName(quadbike.getName());
                }
                if (quadbike.getBrand() != null) {
                    qbike.get().setBrand(quadbike.getBrand());
                }
                if (quadbike.getYear() != null) {
                    qbike.get().setYear(quadbike.getYear());
                }
                if (quadbike.getDescription() != null) {
                    qbike.get().setDescription(quadbike.getDescription());
                }
                if (quadbike.getCategory() != null) {
                    qbike.get().setCategory(quadbike.getCategory());
                }
                quadbikeRepository.save(qbike.get());
                return qbike.get();
            } else {
                return quadbike;
            }
        } else {
            return quadbike;
        }
    }
/**
 * Servicio que borra la lista todos los elementos de Cuadrimotos
 * @param idquadbike
 * @return Servicio que borra la lista todos los elementos de Cuadrimotos
 */
    public boolean deleteQuadbike(int idquadbike) {
        Boolean qBoolean;
        qBoolean = getQuadbike(idquadbike).map(quadbike -> {
            quadbikeRepository.delete(quadbike);
            return true;
        }).orElse(false);
        return qBoolean;
    }
}
