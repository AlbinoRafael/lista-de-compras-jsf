package br.senai.listadecomprasjsf.repository;

import br.senai.listadecomprasjsf.model.ItemDeLista;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class ItemRepository {

    private List<ItemDeLista> lista = new ArrayList<>();

    public ItemRepository() {
        lista.add(new ItemDeLista("limão", 2.0f, "unidade(s)"));
        lista.add(new ItemDeLista("carne",1f,"kilo(s)"));
        lista.add(new ItemDeLista("leite",4f,"litro(s)"));
    }

    public List<ItemDeLista> obterItens() {
        return lista;
    }

    public void adicionar(ItemDeLista itemNovo) {
        lista.add(itemNovo);
    }
    public void remover(ItemDeLista item) {
        lista.remove(item);
    }
    public boolean existe(String nome) {
        return lista.stream().anyMatch(s -> s.equals(nome));
    }
}
