package mx.com.gm.domain;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import lombok.Data;


@Data
@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	
        private static final long serialVersionUID = 1L;
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPersona;
        
        @NotEmpty //valida que el valor no sea null y que la cadena tampoco sea vacia
	private String nombre;
        
        @NotEmpty
	private String apellido;
         
        @NotEmpty
        @Email
	private String email;
          
       
	private String telefono;
        
        @NotNull
        private double saldo;
	
}
