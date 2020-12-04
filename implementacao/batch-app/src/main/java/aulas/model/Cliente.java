package aulas.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cli")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy="cliente")
    private List<Lancamento> lancamentos = new ArrayList<Lancamento>();

    @OneToMany(mappedBy="cliente")
    private List<Fatura> faturas = new ArrayList<Fatura>();

    public Cliente(){}

    public Cliente(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public Lancamento lanca(String descricao,Double valor,Moeda moeda) {
        Lancamento lancamento = new Lancamento(descricao,valor,moeda,this);
        lancamentos.add(lancamento);
        return lancamento;
    }

    public Fatura iniciaFaturaParaFechamento(Date dataFechamento) {
        Fatura fatura = new Fatura(this,dataFechamento);
        faturas.add(fatura);
        return fatura;
    }

    public Fatura getFaturaAberta() {
        for (Fatura fatura : faturas) {
            if(fatura.aberta())
                return fatura;
        }
        return null;
    }

    public Long getId() {
        return id;
    }
}