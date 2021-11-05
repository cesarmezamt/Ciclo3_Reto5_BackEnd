package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * <H2>Reservation</H2>
 * Clase para reservation Entity que crea la tabla "reservation" con auto incremento
 * la llave es idReservation
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
/**
 *  configuración de la tabla
 *  definicion de las variables
 *  idReservation es Integer y autoinclemental
 *  las demas variables son:
 *  Date startDate
 *  Date devolutionDate
 *  variable inicializada:
 *  String status="created"
 * @return idReservation
 */    

    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    
 /**
 * Relaciones entre tablas con reservation
 * OneToMany reservation con  quadbike
 * @return
 */
    
    @ManyToOne
    @JoinColumn(name = "quadbikeId")
    //@JsonIgnoreProperties({"reservations","client"})
    @JsonIgnoreProperties({"reservations"})
    private Quadbike quadbike;
        
   /**
    * Relaciones entre tablas con reservation
    * OneToMany reservation con  client
    * @return Relaciones
    */
    
    @ManyToOne
    @JoinColumn(name ="idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;
/**
 * variable score
 * @return score
 */
    private String score;

    
/**
 * obtiene el idReservation para la tabla Reservation
* @return idReservation
*/
    public Integer getIdReservation() {
        return idReservation;
    }
/**
 * inserta el idReservation para la tabla Reservation
* @param idReservation
*/
    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
/**
 * obtiene el tartDate para la tabla Reservation
* @return startDate
*/
    public Date getStartDate() {
        return startDate;
    }
/**
 * inserta el  startDate para la tabla Reservation
* @param startDate
*/
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
/**
 * obtiene el devolutionDate para la tabla Reservation
* @return devolutionDate
*/
    public Date getDevolutionDate() {
        return devolutionDate;
    }
/**
 *  inserta el  devolutionDate para la tabla Reservation
* @param devolutionDate
*/
    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
/**
 * obtiene el status para la tabla Reservation
* @return status
*/
    public String getStatus() {
        return status;
    }
/**
 * inserta el  status para la tabla Reservation
* @param status
*/
    public void setStatus(String status) {
        this.status = status;
    }
/**
 * obtiene el quadbike para la tabla Reservation
* @return quadbike
*/
    public Quadbike getQuadbike() {
        return quadbike;
    }
/**
 * inserta el  quadbike para la tabla Reservation
* @param quadbike
*/
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }
/**
 * obtiene el client para la tabla Reservation
* @return client
*/
    public Client getClient() {
        return client;
    }
/**
 * inserta el client para la tabla Reservation
* @param client
*/
    public void setClient(Client client) {
        this.client = client;
    }
/**
 * obtiene el score para la tabla Reservation
* @return score
*/
    public String getScore() {
        return score;
    }
/**
 * inserta el score para la tabla Reservation
* @param score
*/
    public void setScore(String score) {
        this.score = score;
    }

      
    
}
