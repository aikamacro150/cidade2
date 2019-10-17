/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Cidade {
    private Integer codigo;
    private String nome;
    private String sigla_estado;
    private Double area_total;
    private Double distancia_capital;
    private Integer numero_abitantes;
    private LocalDate data_emancipacao;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla_estado() {
        return sigla_estado;
    }

    public void setSigla_estado(String sigla_estado) {
        this.sigla_estado = sigla_estado;
    }

    public Double getArea_total() {
        return area_total;
    }

    public void setArea_total(Double area_total) {
        this.area_total = area_total;
    }

    public Double getDistancia_capital() {
        return distancia_capital;
    }

    public void setDistancia_capital(Double distancia_capital) {
        this.distancia_capital = distancia_capital;
    }

    public Integer getNumero_abitantes() {
        return numero_abitantes;
    }

    public void setNumero_abitantes(Integer numero_abitantes) {
        this.numero_abitantes = numero_abitantes;
    }

    public LocalDate getData_emancipacao() {
        return data_emancipacao;
    }

    public void setData_emancipacao(LocalDate data_emancipacao) {
        this.data_emancipacao = data_emancipacao;
    }

    @Override
    public String toString() {
        return "Cidade{" + "nome=" + nome + '}';
    }
}
