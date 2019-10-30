package com.example.carllegod.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.carllegod.entidades.Automovel;
import com.example.carllegod.entidades.Pessoa;

@Component
@Transactional
public class AutomovelRepositorioJPA implements AutomovelRepositorio {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Automovel consultar(long id) {
        return em.find(Automovel.class, id);
    }

    @Override
    public void inserir(Automovel umAutomovel) {
        em.persist(umAutomovel);
    }

    @Override
    public List<Automovel> consultarPorProprietaria(long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Automovel> consulta = builder.createQuery(Automovel.class);
        Root<Automovel> raiz = consulta.from(Automovel.class);
        TypedQuery<Automovel> tq = em.createQuery(consulta.select(raiz).where(builder.equal(raiz.<Pessoa>get("proprietaria").get("id"), id)));
        return tq.getResultList();
    }

    @Override
    public Automovel remover(long id) {
        Automovel a = consultar(id);
        em.remove(a);
        return a;
    }
}




















