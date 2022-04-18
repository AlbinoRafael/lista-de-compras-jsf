package br.senai.listadecomprasjsf.repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ItemRepository {

    private List<String> lista = new ArrayList<>();

    public ItemRepository() {
        lista.add("2 unidade(s) de limão");
        lista.add("1 kilo(s) de carne");
        lista.add("4 litro(s) de leite");
    }

    public List<String> obterItens() {
        return lista;
    }

    public void adicionar(String itemNovo) {
        lista.add(itemNovo);
    }

    public void remover(String item) {
        lista.remove(item);
    }
    public boolean existe(String nome) {
        return lista.stream().anyMatch(s -> s.equals(nome));
    }
}
