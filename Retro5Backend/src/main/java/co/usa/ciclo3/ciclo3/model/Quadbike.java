package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
/**
 * <H2>Quadbike</H2>
 * Clase para Quadbike Entity que crea la tabla "quadbike" con auto incremento
 * la llave es id
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Entity
@Table(name="quadbike")

public class Quadbike implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
 /**
 * Campos de la clase Quadbike de la tabla definicion de las variables
 * id es Integer y autoinclemental las demas variables son: 
 * String name, String brand, Integer year, String description
 * @param
*/
  
    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

 /**
 *
 * Relaciones entre tablas con quadbike
 * OneToMany quadbike category
 * @param
 */ 
    
    @ManyToOne
    @JoinColumn(name="categoryId")
    @JsonIgnoreProperties("quadbikes")
    private Category category;
    /**
     * Relaciones entre tablas con quadbike
     * OneToMany quadbike con  messages
     * @param
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Message> messages;
   /**
     * Relaciones entre tablas con quadbike
     * OneToMany quadbike con  reservations
     * @param
    */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="quadbike")
    @JsonIgnoreProperties({"quadbike","client"})
    private List<Reservation> reservations;

 /**
 *
 * gettes and setters de la clase Quadbike
 * @param
 */      
    
 /**
  * obtiene el id para la tabla quadbike
 * @return id
 */
    
    public Integer getId() {
        return id;
    }

 /**
  *  insertar el id para la tabla quadbike
 * @param id
*/
    
    public void setId(Integer id) {
        this.id = id;
    }
    
 /**
  * obtiene el name para la tabla quadbike
 * @return name
 */

    public String getName() {
        return name;
    }
/**
 * inserta el name para la tabla quadbike
 * @param name
*/
    public void setName(String name) {
        this.name = name;
    }
 /**
  *obtiene el brand para la tabla quadbike
 * @return brand
 */
    public String getBrand() {
        return brand;
    }
/**
 * inserta el brand para la tabla quadbike
 * @param brand
*/
    public void setBrand(String brand) {
        this.brand = brand;
    }
 /**
  * obtiene el year para la tabla quadbike
 * @return year
 */
    public Integer getYear() {
        return year;
    }
/**
 * inserta el year para la tabla quadbike
 * @param year 
*/
    public void setYear(Integer year) {
        this.year = year;
    }
 /**
  * obtiene el description para la tabla quadbike
 * @return description
 */
    public String getDescription() {
        return description;
    }
/**
 * inserta el description para la tabla quadbike
 * @param description
*/
    public void setDescription(String description) {
        this.description = description;
    }
 /**
  * obtiene el category para la tabla quadbike
 * @return category
 */
    public Category getCategory() {
        return category;
    }
/**
 * inserta el category para la tabla quadbike
 * @param category
*/
    public void setCategory(Category category) {
        this.category = category;
    }
 
/**
 * obtiene el messages para la tabla quadbike
 * @return messages
 */
    public List<Message> getMessages() {
        return messages;
    }
    
/**
 * inserta el messages para la tabla quadbike
 * @param messages
*/
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
/**
 * obtiene la lista reservations para la tabla quadbike
 * @return  reservations
 */
    public List<Reservation> getReservations() {
        return reservations;
    }
/**
 * inserta la lista  reservations para la tabla quadbike
 * @param reservations
*/
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    
}
