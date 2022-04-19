package br.senai.listadecomprasjsf.model;


import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

public class ItemDeLista {
    @NotEmpty(message = "{item.descricao.NotEmpty.message}")
    private String descricao;

    private Float quantidade;

    private String medida;

    public ItemDeLista() {
    }

    public ItemDeLista(String descricao, Float quantidade, String medida) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.medida = medida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public List<String> getMedidas() {
        return Arrays.asList("unidade(s)", "kilo(s)", "litro(s)", "garrafa(s)", "pacote(s)");
    }

    @Override
    public String toString() {
        return quantidade + " " + medida + " de " + descricao;
    }
}
