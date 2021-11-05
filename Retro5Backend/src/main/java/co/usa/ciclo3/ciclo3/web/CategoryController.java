package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
/**
 * <H2>Controlador Categoria</H2>
 * Controlador Categoria
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@RestController

@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class CategoryController {

    @Autowired
    private CategoryService categoryService;
/**
 * Controlador Obtiene lista de Categoria
 * @return Controlador Obtiene lista de Categoria
 */
    @GetMapping("/all")
    public List<Category> getCategory(){
        return categoryService.getAll();
    }
    /**
     * Controlador Obtiene lista de Categoria por id
     * @param categoryId Categoria por id
     * @return Controlador Obtiene lista de Categoria por id
     */
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId){
        return categoryService.getCategory(categoryId);
    }
/**
 * Controlador salva lista de Categoria
 * @param c salva lista de Categoria
 * @return Controlador salva lista de Categoria
 */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }
/**
 * Controlador actualiza lista de Categoria
 * @param category actualiza lista de Categoria 
 * @return Controlador actualiza lista de Categoria 
 */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Category update(@RequestBody Category category) {
        return categoryService.update(category);
    }
    /**
     * Controlador borra lista de Categoria por id
     * @param categoryId borra lista de Categoria por id
     * @return Controlador borra lista de Categoria por id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoryId) {
        return categoryService.deleteCategory(categoryId);
    }

}
