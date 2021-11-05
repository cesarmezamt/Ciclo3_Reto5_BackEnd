package co.usa.ciclo3.ciclo3.repository.crud;

import co.usa.ciclo3.ciclo3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * <H2>ReservationCrudRepository</H2>
 * Interface Reservación
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer>{
    
public List<Reservation> findAllByStatus (String status); 
public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
@Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
public List<Object[]> countTotalReservationsByClient();
}
