package com.example.carllegod.repositorios;

import java.util.List;

import com.example.carllegod.entidades.Automovel;

public interface AutomovelRepositorio {
    void inserir(Automovel umAutomovel);

    Automovel remover(long id);

    Automovel consultar(long id);

    List<Automovel> consultarPorProprietaria(long id);
}
