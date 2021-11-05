package co.usa.ciclo3.ciclo3.model;

/**
 * <H2>ClientCounter</H2>
 * Clase para ClientCounter que crea el contador para clientes
 *
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
public class ClientCounter {

    /**
     * Campos de la clase "ClientCounter" definicion de las variables variables
     * son: Long total y Client client
     */
    private Long total;
    private Client client;

    /**
     * Método contructor
     * @param total variable total
     * @param client variable client
     */
    public ClientCounter(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    /**
     * gettes and setters de la clase ClientCounter
     * @param gettes and setters de la clase ClientCounter
     */
    
    /**
     * obtiene variable total
     * @return total
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Inserta variable total
     *
     * @param total variable total
     */
    public void setTotal(Long total) {
        this.total = total;
    }

    /**
     * obtiene variable client
     *
     * @return client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Inserta variable client
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

}
