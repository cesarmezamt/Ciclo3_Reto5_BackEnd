package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.ClientCounter;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.crud.ReservationCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <H2>QuadbikeRepository</H2>
 * Repositorio Reservaciones
 *
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Repository
public class ReservationRepository {

    @Autowired

    private ReservationCrudRepository reservationCrudRepository;

    /**
     * Obtiene la lista todos los elementos de Reservaciones
     *
     * @return Obtiene la lista todos los elementos de Reservaciones
     */
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    /**
     * Obtiene la lista todos los elementos de Reservaciones por id
     *
     * @param id
     * @return Obtiene la lista todos los elementos de Reservaciones por id
     */
    public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }

    /**
     * Salva la lista todos los elementos de Reservaciones
     *
     * @param reservation
     * @return Salva la lista todos los elementos de Reservaciones
     */
    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    /**
     * Borra la lista todos los elementos de Reservaciones
     *
     * @param reservation
     */
    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }

    /**
     *  Obtiene la lista todos los elementos de Reservaciones por el estado
     * @param status la lista todos los elementos de Reservaciones por el estado
     * @return la lista todos los elementos de Reservaciones por el estado
     */
    public List<Reservation> reservacionStatusRepositorio(String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }

    /**
     * Obtiene la fecha entrega y fecha de devolución 
     * @param a fecha entrega
     * @param b echa de devolución 
     * @return Obtiene la fecha entrega y fecha de devolución 
     */
    public List<Reservation> reservacionTiempoRepositorio(Date a, Date b) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    /**
     *Obtiene la lista todos los elementos de Clientes
     * @return Obtiene la lista todos los elementos de Clienters
     */
    public List<ClientCounter> getClientesRepositorio() {
        List<ClientCounter> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ClientCounter((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }
        return res;
    }

}
