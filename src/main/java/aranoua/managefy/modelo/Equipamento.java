package aranoua.managefy.modelo;

public class Equipamento {
    private long num_tombo;
    private String equipamento;
    private String marca;
    private String modelo;
    private int ano_lancamento;

    public Equipamento(){

    }

    public Equipamento(String equipamento, String marca, String modelo) {
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Equipamento(String equipamento, String marca, String modelo, int ano_lancamento) {
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.ano_lancamento = ano_lancamento;
    }

    public long getNum_tombo() {
        return num_tombo;
    }

    public void setNum_tombo(long num_tombo) {
        this.num_tombo = num_tombo;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno_lancamento() {
        return ano_lancamento;
    }

    public void setAno_lancamento(int ano_lancamento) {
        this.ano_lancamento = ano_lancamento;
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "num_tombo=" + num_tombo +
                ", equipamento='" + equipamento + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano_lancamento=" + ano_lancamento +
                '}';
    }
}
