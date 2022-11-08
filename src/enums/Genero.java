package enums;

public enum Genero {
   Acao("Ação"),
   Aventura("Aventura"),
   Terror("Terror"),
   Suspense("Suspense"),
   Comedia("Comédia");
   
   private String descricao;

    private Genero(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
   
}
