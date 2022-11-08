package entidade;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public class Sessao {
    
    private LocalDate Data;
    private LocalTime Hora;

    public Sessao(LocalDate Data, LocalTime Hora, BigDecimal Valor) {
        this.Data = Data;
        this.Hora = Hora;
        this.Valor = Valor;
    }

    public LocalDate getData() {
        return Data;
    }

    public void setData(LocalDate Data) {
        this.Data = Data;
    }

    public LocalTime getHora() {
        return Hora;
    }

    public void setHora(LocalTime Hora) {
        this.Hora = Hora;
    }

    public BigDecimal getValor() {
        return Valor;
    }

    public void setValor(BigDecimal Valor) {
        this.Valor = Valor;
    }
    private BigDecimal Valor;
    
}
