import java.util.ArrayList;
public class Almacen {
    public ArrayList medicamentos = new ArrayList<>();

    public ArrayList  getListaMedicamentos(){
        return medicamentos;
    }
    public void addMedicamento(Medicamento medicamento){
        medicamentos.add(medicamento);
    }
    
}
