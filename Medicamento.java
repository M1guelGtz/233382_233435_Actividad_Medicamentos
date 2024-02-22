public class Medicamento {
    protected String nombre;
    protected int clave;
    protected String caducidad;

    public Medicamento(){}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public int getClave() {return clave;}
    public void setClave(int clave) { this.clave = clave;}

    public String getCaducidad() {return caducidad; }
    public void setCaducidad(String caducidad) { this.caducidad = caducidad; }
}
