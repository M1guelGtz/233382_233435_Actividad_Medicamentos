public class Medicamento {
    protected String nombre;
    protected int clave;
    protected String caducidad;
    protected int piezas;
    protected String lote;

    public Medicamento(){}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getClave() {return clave;}
    public void setClave(int clave) { this.clave = clave;}

    public String getCaducidad() {return caducidad; }
    public void setCaducidad(String caducidad) { this.caducidad = caducidad; }

    public int getPiezas() { return piezas; }
    public void setPiezas(int piezas) { this.piezas = piezas; }

    public String getLote(){return lote;}
    public void setLote(String lote){this.lote = lote;}
}
