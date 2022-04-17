package br.senai.listadecomprasjsf.mbean;

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

    private String item;
    private List<String> lista = new ArrayList<>();
    private List<String> itensSelecionados = new ArrayList<>();

    public void onload() {   // vem do  f:event type="preRenderView"
        lista = itemRepo.obterItens();
    }

    public String adicionarItem(String item) {
        if(item!=null) {
            itemRepo.adicionar(item);
        }
        this.item = null;
        this.lista = itemRepo.obterItens();
        return null;
    }

    public String removerItens() {
        for (String s1 : itensSelecionados) {
            itemRepo.remover(s1);
        }
        this.lista = itemRepo.obterItens();
        return null;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public List<String> getItensSelecionados() {
        return itensSelecionados;
    }

    public void setItensSelecionados(List<String> itensSelecionados) {
        this.itensSelecionados = itensSelecionados;
    }
}
