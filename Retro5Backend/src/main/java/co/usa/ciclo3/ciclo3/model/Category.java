package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * <H2>Category</H2>
 * Clase Category Entity crea la tabla "category" con auto incremento
 * la llave es id
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Entity
@Table(name = "category")

public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Campos de la clase "Category" definicion de las variables
     * de configuración de la tabla, la variable id es Integer y
     * autoinclemental las demas variables son: String name String description
     * @param
    */
    private Integer id;
    private String name;
    private String description;

    /**
     *
     * Relaciones entre tablas con "categor" OneToMany category con quadbikes
     *
     * @param Relaciones entre tablas 
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "category")
    @JsonIgnoreProperties("category")
    private List<Quadbike> quadbikes;

    /**
     * gettes and setters de la clase Quadbike
     * @param gettes and setters de la clase Quadbike
     */
    
    /**
     * obtiene el id public class Category
     * @return  obtiene el id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * insertar el id para la tabla categor
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * obtiene el name para la tabla categor
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * insertar el name para la tabla categor
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtiene el description para la tabla categor
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * insertar el description para la tabla categor
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * obtiene la lista de quadbikes para la tabla categor
     * @return quadbikes
     */
    public List<Quadbike> getQuadbikes() {
        return quadbikes;
    }

    /**
     * insertar la lista de quadbikes para la tabla categor
     * @param quadbikes
     */
    public void setQuadbikes(List<Quadbike> quadbikes) {
        this.quadbikes = quadbikes;
    }

}
