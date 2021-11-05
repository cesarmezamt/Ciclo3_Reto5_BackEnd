package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * <H2>CategoryRepository</H2>
 * Repositorio Categoria
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    /**
     *  obtiene la lista todos los elementos de la categoria
     * @return Obtiene lista todos los elementos de la categoria
     */
    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    /**
     * obtiene la lista todos los elementos de la categoria por Id
     * @param id
     * @return Obtiene lista todos los elementos de la categoria por Id
     */
    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    /**
     * Salva la lista todos los elementos de la categoria 
     * @param category
     * @return Salva la lista todos los elementos de la categoria 
     */
    public Category save(Category category) {
        return categoryCrudRepository.save(category);
    }

    /**
     * Borra todos de los elementos de la categoria
     * @param category
     */
    public void delete(Category category) {
        categoryCrudRepository.delete(category);
    }

}
