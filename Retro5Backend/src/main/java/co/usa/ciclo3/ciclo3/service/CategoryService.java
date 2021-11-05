package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
/**
 * <H2>CategoryService</H2>
 * Servicio Categoria
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     *  Servicio que obtiene la lista todos los elementos de la categoria
     * @return Servicio que obtiene la lista todos los elementos de la categoria
     */
    
    public List<Category> getAll(){
        return  categoryRepository.getAll();
    }
    /**
     * Servicio que obtiene la lista todos los elementos de la categoria por id
     * @param categoryId
     * @return Servicio que obtiene la lista todos los elementos de la categoria por id
     */
    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }
    /**
     * Servicio que salva la lista todos los elementos de la categoria
     * @param category
     * @return Servicio que salva la lista todos los elementos de la categoria
     */
    public Category save(Category category){
        if(category.getId()==null){
            return categoryRepository.save(category);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(category.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(category);
            }else{
                return category;
            }
        }
    }
    /**
     * Servicio que actualiza la lista todos los elementos de la categoria
     * @param category
     * @return Servicio que actualiza la lista todos los elementos de la categoria
     */
        public Category update(Category category){
        if(category.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(category.getId());
            if(!g.isEmpty()){
                if(category.getDescription()!=null){
                    g.get().setDescription(category.getDescription());
                }
                if(category.getName()!=null){
                    g.get().setName(category.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return category;
}
        /**
         * Servicio que borra la lista todos los elementos de la categoria
         * @param categoryId
         * @return Servicio que borra la lista todos los elementos de la categoria
         */
 public boolean deleteCategory(int categoryId){
        Boolean dcat;
        dcat = getCategory(categoryId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return dcat;
    }
        
}
