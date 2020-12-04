package aulas.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "lanc")
public class Lancamento implements Serializable {

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;
       private String descricao;
       private Double valor;
       private Moeda moeda;

       @Temporal(TemporalType.DATE)
       private Date data;

       @ManyToOne
       private Cliente cliente;

       @ManyToOne
       private Fatura fatura;

       public Lancamento() {

       }
       public Lancamento(String descricao, Double valor, Moeda moeda, Cliente cliente) {
             this.valor = valor;
             this.moeda = moeda;
             this.cliente = cliente;
             this.descricao = descricao;
             data = new Date();
       }
       public Long getId() {
             return id;
       }
       public void converteParaReal(Double valorDolar) {
             this.valor = valorDolar * valor;
             this.moeda = Moeda.REAL;
       }
       public String getDescricao() {
             return descricao;
       }
       public Double getValor() {
             return valor;
       }
       public void processa() {
             //Associa a fatura em aberto como fatura do lan�amento
             fatura = cliente.getFaturaAberta();
       }
       public Date getData() {
             return data;
       }
}