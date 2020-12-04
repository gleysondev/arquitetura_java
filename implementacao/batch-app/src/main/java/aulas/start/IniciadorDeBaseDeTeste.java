package aulas.start;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import aulas.model.Cliente;
import aulas.model.Moeda;

@Singleton
public class IniciadorDeBaseDeTeste implements Serializable{

    @PersistenceContext(unitName = "MY_PU")
    private EntityManager em;

    @Transactional
    public void iniciaEstadoDaBase() {

        Date hoje = new Date();

        Cliente renan = new Cliente("Renan");
        em.persist(renan);
        em.persist(renan.iniciaFaturaParaFechamento(hoje));
        em.persist(renan.lanca("Saraiva",80.0,Moeda.REAL));
        em.persist(renan.lanca("ChurrascoMil",150.4,Moeda.REAL));
        em.persist(renan.lanca("DealExtreme",35.2,Moeda.DOLAR));

        Cliente gilberto = new Cliente("Gilberto");
        em.persist(gilberto);
        em.persist(gilberto.iniciaFaturaParaFechamento(hoje));
        em.persist(gilberto.lanca("PSN",20.0,Moeda.DOLAR));
        em.persist(gilberto.lanca("FastShop",2000.0,Moeda.REAL));
        em.persist(gilberto.lanca("eBay",77.6,Moeda.DOLAR));
    }

}