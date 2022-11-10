package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;
import javax.swing.JOptionPane;
import entidade.Filme;
import entidade.Sessao;
import enums.Genero;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;

public class FilmeDao implements Serializable{
    
    private List<Filme> listaFilmes;

    public FilmeDao() {
        listaFilmes = new ArrayList<>();
        Sessao sessao1 = new Sessao(LocalDate.now(), LocalTime.now(), BigDecimal.valueOf(120.40));
        Filme filme1 = new Filme(Genero.Acao, "A aventura inesperada", sessao1);

        Sessao sessao2 = new Sessao(LocalDate.of(2022, Month.MARCH, 25), LocalTime.of(14, 45), BigDecimal.valueOf(120.40));
        Filme filme2 = new Filme(Genero.Comedia, "Piadas 5", sessao1);

        this.listaFilmes.add(filme1);
        this.listaFilmes.add(filme2);
    }

    public void gravar(String path) {
        try(OutputStream output = new FileOutputStream(path)){
          ObjectOutputStream object = new ObjectOutputStream(output);
          object.writeObject(listaFilmes);
          JOptionPane.showMessageDialog(null, "Arquivo foi salvo com sucesso.");
        }catch (Exception ex){
           ex.printStackTrace();
        }
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public void setListaFilmes(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }
   
    public List<Filme> abrir(String path){
       try(InputStream input = new FileInputStream(path)){
            ObjectInputStream object = new ObjectInputStream(input);
            listaFilmes = (List<Filme>)object.readObject();
       }catch(IOException ex){
          ex.printStackTrace();
       } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
       }
       return listaFilmes;
    }
    
}
