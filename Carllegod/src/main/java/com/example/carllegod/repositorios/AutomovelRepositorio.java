package com.example.carllegod.repositorios;

import java.util.List;

import com.example.carllegod.entidades.Automovel;
import com.example.carllegod.entidades.Pessoa;

public interface AutomovelRepositorio {
    void inserir(Automovel umAutomovel);

    Automovel remover(long id);

    Automovel consultar(long id);

    List<Automovel> consultarPorProprietaria(long id);

}
