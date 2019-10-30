package com.example.carllegod.repositorios;

import java.util.List;

import com.example.carllegod.entidades.Pessoa;

public interface PessoaRepositorio {
    void inserir(Pessoa umaPessoa);

    List<Pessoa> consultarTodos();

    Pessoa consultar(long id);

    Pessoa remover(long id);

    void alterar(Pessoa umaPessoa);
}
