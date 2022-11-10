package entidade;

import java.time.LocalDate;
import enums.Genero;
import entidade.Sessao;
import java.io.Serializable;

public class Filme implements Serializable{
    private Genero genero;

    public Filme(Genero genero, String titulo, Sessao sessao) {
        this.genero = genero;
        this.titulo = titulo;
        this.sessao = sessao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }
    private String titulo;
    private Sessao sessao;
    
}
