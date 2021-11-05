package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * <H2>Client</H2>
 * Clase para Client Entity que crea la tabla "client" con auto incremento la
 * llave es idClient
 *
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Entity
@Table(name = "client")

public class Client implements Serializable {

    @Id
    @GeneratedValue

    /**
     * Campos de la clase Client de la tabla definicion de las variables
     * idClient es Integer y autoinclemental las demas variables son: String
     * email String password String name Integer age
     *
     * @param Campos de la clase Client
     */
    private Integer idClient;
    private String email;
    private String password;
    private String name;
    private Integer age;

    /**
     *
     * Relaciones entre tablas con client OneToMany client con messages
     *
     * @param Relaciones entre tablas con client
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Message> messages;
    /**
     * Relaciones entre tablas con client OneToMany client con reservations
     *
     * @param Relaciones entre tablas con client
     */
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    /**
     *
     * obtiene el idClient para la tabla client
     * @return idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * insertar el idClient para la tabla client
     *
     * @param idClient
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * obtiene el email para la tabla client
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * insertar el email para la tabla client
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * obtiene el password para la tabla client
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * insertar el password para la tabla client
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * obtiene el name para la tabla client
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * insertar el name para la tabla client
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * obtiene el age para la tabla client
     *
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * insertar el age para la tabla client
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * obtiene la lista messages para la tabla client
     *
     * @return messages
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * insertar la lista messages para la tabla client
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * obtiene la lista reservations para la tabla client
     *
     * @return reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * insertar la lista reservations para la tabla client
     *
     * @param reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
