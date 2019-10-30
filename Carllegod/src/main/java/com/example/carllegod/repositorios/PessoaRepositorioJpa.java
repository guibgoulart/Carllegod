package com.example.carllegod.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.example.carllegod.entidades.Pessoa;

@Component
@Transactional
public class PessoaRepositorioJpa implements PessoaRepositorio {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void inserir(Pessoa umaPessoa) {
        em.persist(umaPessoa);
    }


    @Override
    public List<Pessoa> consultarTodos() {
        String jpql = "select p from Pessoa p";
        TypedQuery<Pessoa> consulta =
                em.createQuery(jpql, Pessoa.class);
        return consulta.getResultList();
    }

    @Override
    public Pessoa consultar(long id) {
        return em.find(Pessoa.class, id);
    }

    @Override
    public Pessoa remover(long id) {
        Pessoa p = consultar(id);
        em.remove(p);
        return p;
    }

    @Override
    public void alterar(Pessoa umaPessoa) {
        em.merge(umaPessoa);
    }


}
