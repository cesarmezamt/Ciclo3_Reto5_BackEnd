package co.usa.ciclo3.ciclo3.model;

/**
 * <H2>ReservationStatus</H2>
 * Clase para ReservationStatus que da el estado de las reservas
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
public class ReservationStatus {
    /**
     * Campos de la clase "ReservationStatus" definicion de las variables variables
     * son: int completed y int cancelled
     */
    private int completed;
    private int cancelled;
/**
 * Método contructor
 * @param completed
 * @param cancelled 
 */
    public ReservationStatus(int completed, int cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }
/**
 * gettes and setters de la clase ReservationStatus
 * /
  
 /**
 * obtiene variable completed
 * @return completed
 */
    public int getCompleted() {
        return completed;
    }
/**
 * Inserta variable completed
 * @param completed 
 */
    public void setCompleted(int completed) {
        this.completed = completed;
    }
/**
 * obtiene variable cancelled
 * @return cancelled
 */
    public int getCancelled() {
        return cancelled;
    }
/**
 * Inserta variable cancelled
 * @param cancelled 
 */
    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
    
    
}
