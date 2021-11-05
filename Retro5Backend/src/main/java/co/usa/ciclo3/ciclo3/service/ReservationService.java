package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.ClientCounter;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.ReservationStatus;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <H2>ReservationService</H2>
 * Servicio Reservaciones
 *
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    /**
     * Servicio que obtiene la lista todos los elementos de Reservaciones
     *
     * @return Servicio que obtiene la lista todos los elementos de
     * Reservaciones
     */
    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    /**
     * Servicio que obtiene la lista todos los elementos de Reservaciones por id
     *
     * @param reservationId
     * @return Servicio que obtiene la lista todos los elementos de
     * Reservaciones por id
     */
    public Optional<Reservation> getReservation(int reservationId) {
        return reservationRepository.getReservation(reservationId);
    }

    /**
     * Servicio que salva la lista todos los elementos de Reservaciones
     *
     * @param reservation
     * @return Servicio que salva la lista todos los elementos de Reservaciones
     */
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> evt = reservationRepository.getReservation(reservation.getIdReservation());
            if (evt.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     * Servicio que actualiza la lista todos los elementos de Reservaciones
     *
     * @param reservation
     * @return Servicio que actualiza la lista todos los elementos de
     * Reservaciones
     */
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> res = reservationRepository.getReservation(reservation.getIdReservation());
            if (!res.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    res.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    res.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    res.get().setStatus(reservation.getStatus());
                }
                reservationRepository.save(res.get());
                return res.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     * Servicio que borra la lista todos los elementos de Reservaciones
     *
     * @param reservationId
     * @return Servicio que borra la lista todos los elementos de Reservaciones
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean;
        aBoolean = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Servicio obtiene reporte de estado
     *
     * @return obtiene reporte de estado
     */
    public ReservationStatus reporteStatusServicio() {
        List<Reservation> completed = reservationRepository.reservacionStatusRepositorio("completed");
        List<Reservation> cancelled = reservationRepository.reservacionStatusRepositorio("cancelled");

        return new ReservationStatus(completed.size(), cancelled.size());
    }

    /**
     * Servicio obtiene las fechas de entrega y devolución
     *
     * @param datoA fecha de entrega
     * @param datoB fecha de devolución
     * @return
     */
    public List<Reservation> reporteTiempoServicio(String datoA, String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        if (datoUno.before(datoDos)) {
            return reservationRepository.reservacionTiempoRepositorio(datoUno, datoDos);
        } else {
            return new ArrayList<>();

        }
    }

    /**
     * Servicio obtiene la lista de clientes
     *
     * @return obtiene la lista de clientes
     */
    public List<ClientCounter> reporteClientesServicio() {
        return reservationRepository.getClientesRepositorio();
    }
}
