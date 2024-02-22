import java.util.ArrayList;
import java.util.List;
public class Almacen {
    public List <Medicamento> medicamentos = new ArrayList<>();

    public List <Medicamento> getListaMedicamentos(){
        return medicamentos;
    }
    public void addMedicamento(Medicamento medicamento){
        medicamentos.add(medicamento);
    }
    
}
