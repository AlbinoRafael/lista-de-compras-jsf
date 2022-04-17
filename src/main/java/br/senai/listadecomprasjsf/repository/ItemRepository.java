package br.senai.listadecomprasjsf.repository;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ItemRepository {

    private List<String> lista = new ArrayList<>();

    public ItemRepository() {
        lista.add("Item 1");
        lista.add("Item 2");
        lista.add("Item 3");
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
