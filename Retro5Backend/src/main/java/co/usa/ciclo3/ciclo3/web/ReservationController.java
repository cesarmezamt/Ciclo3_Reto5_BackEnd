package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.ClientCounter;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.model.ReservationStatus;
import co.usa.ciclo3.ciclo3.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * <H2>Controlador Reservacion</H2>
 * Controlador Reservacion
 *
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Controlador obtiene lista de Reservaciones
     *
     * @return obtiene lista de Reservaciones
     */
    @GetMapping("/all")
    public List<Reservation> getReservation() {
        return reservationService.getAll();
    }

    /**
     * Controlador obtiene lista de Reservaciones por id
     *
     * @param idReservation obtiene lista de Reservaciones por id
     * @return obtiene lista de Reservaciones por id
     */
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int idReservation) {
        return reservationService.getReservation(idReservation);
    }

    /**
     * Controlador salva lista de Reservaciones
     *
     * @param reservation salva lista de Reservaciones
     * @return Controlador salva lista de Reservaciones
     */

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    /**
     * Controlador Actualiza lista de Reservaciones
     *
     * @param reservation Actualiza lista de Reservaciones
     * @return Controlador Actualiza lista de Reservaciones
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return reservationService.update(reservation);
    }

    /**
     * Controlador Borra lista de Reservaciones por id
     *
     * @param reservationId Borra lista de Reservaciones por id
     * @return Controlador Borra lista de Reservaciones por id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationService.deleteReservation(reservationId);
    }
/**
 * Controlador obtiene reporte de estado
 * @return obtiene reporte de estado
 */
    @GetMapping("/report-status")
    public ReservationStatus getReservas() {
        return reservationService.reporteStatusServicio();
    }
/**
 * Controlador obtiene reporte por fechas
 * @param dateOne fecha inicial
 * @param dateTwo fecha final
 * @return obtiene reporte por fechas
 */
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservasTiempo(@PathVariable("dateOne") String dateOne, @PathVariable("dateTwo") String dateTwo) {
        return reservationService.reporteTiempoServicio(dateOne, dateTwo);
    }
/**
 * Controlador obtiene reporte de clientes
 * @return obtiene reporte de clientes
 */
    @GetMapping("/report-clients")
    public List<ClientCounter> getClientes() {
        return reservationService.reporteClientesServicio();
    }

}
