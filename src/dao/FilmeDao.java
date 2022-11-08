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

public class FilmeDao implements Serializable{
    
    private List<Filme> listaFilmes;

    public FilmeDao(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public FilmeDao() {
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
