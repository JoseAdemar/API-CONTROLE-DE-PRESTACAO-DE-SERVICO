package apicontroledeservicoprestado.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Servico {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @EqualsAndHashCode.Include
	 private Long id;
	 
	 @Column(nullable = false, length = 150)
	 private String descricao;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_cliente")
	 private Cliente cliente;
	 
	 @Column
	 private BigDecimal valor;
	 
	 
	 
	 
}
