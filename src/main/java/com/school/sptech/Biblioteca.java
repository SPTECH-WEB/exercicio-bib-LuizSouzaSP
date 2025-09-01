package com.school.sptech;

public class Biblioteca {
    private Boolean ativa;
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;

    public String getNome(){return this.nome;}
    public Double getMultaDiaria(){return this.multaDiaria;}
    public Integer getQtdLivros(){return this.qtdLivros;}
    public Boolean getAtiva(){return this.ativa;}
    public void setNome(String nome){this.nome = nome;}

    public Biblioteca(String nome, Double multaDiaria){
        setNome(nome);
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }
    public void registrarLivro(Integer quantidade){
        if(quantidade != null){
            if(quantidade > 0 && ativa == true){
                qtdLivros += quantidade;
            }
        }
    }
    public Integer emprestar(Integer quantidade){
        if(quantidade != null){
            if(ativa == true && quantidade > 0 && quantidade <= qtdLivros){
                qtdLivros -= quantidade;
                return quantidade;
            }
        }
        return null;
    }
    public Integer devolver(Integer quantidade){
        if(quantidade != null){
            if(ativa == true && quantidade > 0){
                qtdLivros += quantidade;
                return quantidade;
            }

        }
        return null;
    }
    public Integer desativar(){
        if(ativa == false){
            return null;
        } else {
            ativa = false;
            int anterior = qtdLivros;
            qtdLivros = 0;
            return anterior;
        }
    }
    public void transferir(Biblioteca destino, Integer quantidade){
        if(this.ativa == true && destino.ativa == true && quantidade != null && quantidade <= qtdLivros){
            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }
    public Boolean reajustarMulta(Double percentual){
        if(percentual != null && percentual > 0){
                this.multaDiaria *= (1.0 + percentual);
                return true;
            } else{
            return false;
        }

    }
}
