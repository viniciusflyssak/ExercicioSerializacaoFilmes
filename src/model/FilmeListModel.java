package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidade.Filme;

public class FilmeListModel extends AbstractTableModel{
    
    private final int Genero = 0;
    private final int Filme = 1;
    private final int Data = 2;
    private final int Hora = 3;
    
    private final String colunas[] = {"Gênero", "Filme", "Data", "Hora"};
    private final List<Filme> listaFilmes;

    public FilmeListModel(List<Filme> listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    public void onÍnsert(){
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice); 
    }
    
    @Override
    public int getRowCount() {
        return this.listaFilmes.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filme filme = listaFilmes.get(rowIndex);       
        switch(columnIndex){
            case Genero: return  filme.getGenero();
            case Filme:return filme.getTitulo();
            case Data: return filme.getSessao().getData();
            case Hora: return filme.getSessao().getHora();           
            default : throw new IndexOutOfBoundsException("Coluna inválida!");
        }    
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
}
