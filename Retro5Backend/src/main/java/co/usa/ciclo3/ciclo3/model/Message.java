package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * <H2>Message</H2>
 * Clase para message Entity que crea la tabla "message" con auto incremento la
 * llave es idMessage
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Entity
@Table(name = "message")

public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * configuración de la clase Message de las variables Message
     * Integer y autoinclemental las demas variables son: String messageText
     * @param
     *
     */
    private Integer idMessage;
    private String messageText;

    /**
     *
     * Relaciones entre tablas con message 
     * OneToMany message con quadbike
     * @param
     */
    @ManyToOne
    @JoinColumn(name = "quadbikeId")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Quadbike quadbike;
/**
 * OneToMany message con client
 * @param
 */
    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Client client;

    /**
     * obtiene el idClient para la tabla client
     * @return idMessage
     */
    public Integer getIdMessage() {
        return idMessage;
    }

    /**
     * insertar el idClient para la tabla client
     * @param idMessage
     */
    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    /**
     * obtiene el idClient para la tabla client
     * @return messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * insertar el idClient para la tabla client
     * @param messageText
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * obtiene el idClient para la tabla client
     * @return quadbike
     */
    public Quadbike getQuadbike() {
        return quadbike;
    }

    /**
     * insertar el idClient para la tabla client
     * @param quadbike
     */
    public void setQuadbike(Quadbike quadbike) {
        this.quadbike = quadbike;
    }

    /**
     * obtiene el idClient para la tabla client
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * insertar el idClient para la tabla client
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    
        
    
}
