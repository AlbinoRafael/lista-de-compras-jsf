package br.senai.listadecomprasjsf.mbean;

import br.senai.listadecomprasjsf.repository.ItemRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Named
@SessionScoped
public class ListaBean implements Serializable {

    @Inject
    private ItemRepository itemRepo;

    private String item;

    private BigDecimal quantidade = BigDecimal.valueOf(0);
    private String medida;

    private String itemFormatado;
    private List<String> lista = new ArrayList<>();
    private List<String> itensSelecionados = new ArrayList<>();

    public void onload() {   // vem do  f:event type="preRenderView"
        lista = itemRepo.obterItens();
    }

    public String adicionarItem() {
        if(item!=null&&medida!=null&& quantidade.doubleValue()>0.0){
            setItemFormatado();
            itemRepo.adicionar(getItemFormatado());
            this.item = new String();
            this.quantidade = new BigDecimal(0);
            this.medida = new String();
            this.lista = itemRepo.obterItens();
        }
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

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getItemFormatado() {
        return itemFormatado;
    }

    public void setItemFormatado() {
        this.itemFormatado = this.quantidade.toString()+" "+this.medida+" de "+this.item;
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
    public List<String> getMedidas() {
        return Arrays.asList("unidade(s)", "kilo(s)", "litro(s)", "garrafa(s)", "pacote(s)");
    }
}
