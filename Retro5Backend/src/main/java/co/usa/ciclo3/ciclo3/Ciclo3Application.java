package co.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * <H2>Aplicación</H2>
 * Clase Aplicación
 * @since 21-10-2021
 * @version 1.0
 * @author César Alerto Meza González CC79429945
 */

@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.model"})
@SpringBootApplication
public class Ciclo3Application {
/**
 * Argumentos de la aplicacción
 * @param args Argumentos de la aplicacción
 */
	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
