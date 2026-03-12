package consulta;

public class Animais {

    
    private int id;
    private String nome;
    private String raca;
    private String abrigo;
    private String adotado;
    private int adotante_id;
    
    public int getAdotante_id() {
        return adotante_id;
    }

    public void setAdotante_id(int adotante_id) {
        this.adotante_id = adotante_id;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getAbrigo() {
        return abrigo;
    }

    public void setAbrigo(String abrigo) {
        this.abrigo = abrigo;
    }

    public String getAdotado() {
        return adotado;
    }

    public void setAdotado(String adotado) {
        this.adotado = adotado;
    }
    
    
    
    
    
}
