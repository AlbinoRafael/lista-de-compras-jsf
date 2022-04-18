package br.senai.listadecomprasjsf.mbean;

import br.senai.listadecomprasjsf.model.ItemDeLista;
import br.senai.listadecomprasjsf.repository.ItemRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ListaBean implements Serializable {

    @Inject
    private ItemRepository itemRepo;

    private ItemDeLista item = new ItemDeLista();

    private List<ItemDeLista> lista = new ArrayList<>();
    private List<ItemDeLista> itensSelecionados = new ArrayList<>();

    public void onload() {   // vem do  f:event type="preRenderView"
        lista = itemRepo.obterItens();
    }

    public String adicionarItem() {
        if (item != null) {
            itemRepo.adicionar(item);
            this.item = new ItemDeLista();
            this.lista = itemRepo.obterItens();
        }
        return null;
    }

    public String removerItens() {
        for (ItemDeLista i1 : itensSelecionados) {
            itemRepo.remover(i1);
        }
        this.lista = itemRepo.obterItens();
        return null;
    }

    public ItemDeLista getItem() {
        return item;
    }

    public void setItem(ItemDeLista item) {
        this.item = item;
    }

    public List<ItemDeLista> getLista() {
        return lista;
    }

    public void setLista(List<ItemDeLista> lista) {
        this.lista = lista;
    }

    public List<ItemDeLista> getItensSelecionados() {
        return itensSelecionados;
    }

    public void setItensSelecionados(List<ItemDeLista> itensSelecionados) {
        this.itensSelecionados = itensSelecionados;
    }

}
