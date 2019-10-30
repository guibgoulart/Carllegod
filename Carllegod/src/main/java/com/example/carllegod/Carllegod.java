package com.example.carllegod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.carllegod.entidades.Automovel;
import com.example.carllegod.entidades.Pessoa;
import com.example.carllegod.repositorios.AutomovelRepositorio;
import com.example.carllegod.repositorios.PessoaRepositorio;
import java.util.Date;

@SpringBootApplication
public class Carllegod implements CommandLineRunner {

    @Autowired
    private PessoaRepositorio pessoas;
    @Autowired
    private AutomovelRepositorio automoveis;

    public static void main(String[] args) {
        SpringApplication.run(Carllegod.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        // - Adicionando pessoas ao banco:
        Pessoa p1 = new Pessoa("Luis", new Date(1997, 03, 03));
        pessoas.inserir(p1);
        Pessoa p2 = new Pessoa("Callegari", new Date(1980, 05, 01));
        pessoas.inserir(p2);
        Pessoa p3 = new Pessoa("Adilson", new Date(2000, 10, 9));
        pessoas.inserir(p3);
        Pessoa p4 = new Pessoa("Emilyn", new Date(1998, 9, 7));
        pessoas.inserir(p4);
        Pessoa p5 = new Pessoa("Luiza", new Date(2001, 2, 9));
        pessoas.inserir(p5);
        Pessoa p6 = new Pessoa("Rafael", new Date(2002, 3, 15));
        pessoas.inserir(p6);
        Pessoa p7 = new Pessoa("Everton", new Date(1997, 4, 25));
        pessoas.inserir(p7);
        Pessoa p8 = new Pessoa("Hiago", new Date(1998, 1, 6));
        pessoas.inserir(p8);
        Pessoa p9 = new Pessoa("Richard", new Date(2004, 10, 9));
        pessoas.inserir(p9);

        // - Adicionando ao banco e vinculando um dono para eles:
        Automovel a1 = new Automovel("IWZ-0226", "Fusca", null);
        automoveis.inserir(a1);
        Automovel a2 = new Automovel("IHF-5744", "Celta", p1);
        automoveis.inserir(a2);
        Automovel a3 = new Automovel("JHG-3456", "Ferrari", p2);
        automoveis.inserir(a3);
        Automovel a4 = new Automovel("GOD-0001", "Model 3", p2);
        automoveis.inserir(a4);
        Automovel a5 = new Automovel("GOD-0031", "Gol", p3);
        automoveis.inserir(a5);
        Automovel a6 = new Automovel("GOD-4301", "Uno", p3);
        automoveis.inserir(a6);
        Automovel a7 = new Automovel("GOD-7841", "Palio", p5);
        automoveis.inserir(a7);
        Automovel a8 = new Automovel("GOD-2001", "Fox", p6);
        automoveis.inserir(a8);
        Automovel a9 = new Automovel("GOD-3004", "Fiesta", p7);
        automoveis.inserir(a9);
        Automovel a10 = new Automovel("GOF-0001", "Siena", null);
        automoveis.inserir(a10);

        // - Não funfa por causa da restrição da mascara da string no banco:
        //Automovel a11 = new Automovel("GOF-00001", "Siena", null);
        //automoveis.inserir(a11);

        System.out.println("=========================================");
        System.out.println(" - Nome das pessoas:");
        System.out.println("=========================================");
        for (Pessoa p : pessoas.consultarTodos()) {
            System.out.println( " - Nome: " + p.getNome());
        }

        pessoas.vendeAutomovel(p2, a10); // metodo vende

        // - Consultar automóvel por sua ID:
        System.out.println("=========================================");
        System.out.println(" - Consultar automovel de id[10]:");
        System.out.println("=========================================");
        Automovel au = automoveis.consultar(10);
        System.out.println("  + Id: " + au.getId());
        System.out.println("  + Placa: " + au.getPlaca());
        System.out.println("  + Modelo: " + au.getModelo());
        System.out.println("  + Proprietario: " + au.getProprietaria().getNome());




        // - Consultar automóveis pela ID do proprietario:
        System.out.println("=========================================");
        System.out.println(" - Consultar automoveis:");
        System.out.println("=========================================");
        for (Automovel a : automoveis.consultarPorProprietaria(2)) {
            System.out.println("  + Nome: " + a.getProprietaria().getNome());
            System.out.println("  + Placa: " + a.getPlaca());
            System.out.println("  + Modelo: " + a.getModelo());
            System.out.println("\n");
        }

        // - Remover um carro vinculado a uma pessoa (funfa):
        //automoveis.remover(5);

        // - Remover uma pessoa vinculada a um carro (não funfa):
        //pessoas.remover(2);
    }
}



















