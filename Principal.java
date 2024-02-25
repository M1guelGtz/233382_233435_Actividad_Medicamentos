import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        verMenu();
    }
    public static void verMenu(){
        Almacen almacen = new Almacen();
        Scanner entrada = new Scanner(System.in);
        int resp2;
        do{
            System.out.println("¿Que desea hacer?  \n1.- Añadir medicamento \n2.- Ver existencia de medicamentos  \n3.- Salir");
            int resp = entrada.nextInt();
            if(resp == 1){
                do{
                    añadirMedicamento(almacen);

                    System.out.println("¿desea agregar otro medicamento?\n 1.- si \nOtra tecla.- no");
                    entrada.nextLine();
                    resp2 = entrada.nextInt();

                }while(resp2 < 2 && resp2 > 0);
            }else if( resp == 2) {
                verListaDeMedicamentos(almacen);
            }
            System.out.println("¿Desea volver al menu principal?\n 1.- si \nOtra tecla.-salir");
            resp2 = entrada.nextInt();
        }while(resp2 == 1);
        entrada.close();
    }
    public static void añadirMedicamento(Almacen almacen){
        String nombre;
        int clave;
        int piezas;
        String lote = "";
        Scanner entrada = new Scanner(System.in);
        System.out.println("1.- Via oral \n2.- Via intravenosa");
        int resp = entrada.nextInt();
        if (resp==1 ){
            float gramaje;
            entrada.nextLine();
            ViaOral objMedic = new ViaOral();
            System.out.println("ingrese nombre del medicamento: ");
            nombre = entrada.nextLine();
            do{
                System.out.println("ingrese clave para " + nombre);
                clave = entrada.nextInt();
                if(clave<1){
                    System.out.println("La clave no puede ser un numero negativo ni cero.");
                }
            }while(clave<1);
            entrada.nextLine();
            System.out.println("Ingrese lote");
            lote = entrada.nextLine();
            System.out.println("ingrese fecha de caducidad para " + nombre);
            String caducidad = entrada.nextLine();
            System.out.println("ingrese gramaje de la precentacion: ");
            gramaje = entrada.nextFloat();
            System.out.println("¿cuantas piezas de "+ nombre + " desea agregar");
            piezas = entrada.nextInt();
            objMedic.setNombre(nombre);
            objMedic.setClave(clave);
            objMedic.setCaducidad(caducidad);
            objMedic.setGramos(gramaje);
            objMedic.setPiezas(piezas);
            almacen.addMedicamento(objMedic);
        }else{
            entrada.nextLine();
            String disolucion;
            Intravenosa objMedic = new Intravenosa();
            System.out.println("ingrese clave ");
            clave = entrada.nextInt();

            boolean found = buscarExistencia(almacen, clave);
            
            if (found == true) {
                System.out.println("Ingrese lote");
                entrada.nextLine();
                lote=entrada.nextLine();
                boolean loteBuscado = buscarLote(almacen, lote);
                buscarLote(almacen, lote);
                if(loteBuscado == true){
                    System.out.println("Cuantas piezas de "+clave+" desea añadir?");
                    int add = entrada.nextInt();
                    sumarExistencia(almacen, add, clave);
                }                
                    }else{ 
                            System.out.println("ingrese nombre del medicamento con clave: "+clave);
                            nombre = entrada.nextLine();
                            entrada.nextLine();
                            System.out.println("ingrese fecha de caducidad para " + clave+" "+nombre);
                            String caducidad = entrada.nextLine();
                            System.out.println("ingrese disolucion: ");
                            disolucion = entrada.nextLine();
                            do{                                
                                System.out.println("¿cuantas piezas de "+ nombre + " desea agregar");
                                piezas = entrada.nextInt();
                                if(piezas<1){
                                    System.out.println("El numero menor aceptable es 1");
                                }
                            }while(piezas<1);

                            objMedic.setNombre(nombre);
                            objMedic.setClave(clave);
                            objMedic.setLote(lote);
                            objMedic.setCaducidad(caducidad);
                            objMedic.setDisolucion(disolucion);
                            objMedic.setPiezas(piezas);
                            almacen.addMedicamento(objMedic);
            }
        }
    }
    public static void verListaDeMedicamentos(Almacen almacen){
        for (int i = 0; i < almacen.getListaMedicamentos().size(); i++) {
            System.out.println(almacen.getListaMedicamentos().get(i).getClave());
            System.out.println(almacen.getListaMedicamentos().get(i).getNombre());
            System.out.println(almacen.getListaMedicamentos().get(i).getLote());
            System.out.println(almacen.getListaMedicamentos().get(i).getPiezas());
            System.out.println(almacen.getListaMedicamentos().get(i).getCaducidad());
            System.out.println("");

        }
    }

    public static boolean buscarExistencia(Almacen almacen, int clave){
        boolean bandera = false;
        for (int i = 0; i < almacen.getListaMedicamentos().size(); i++){
            if(almacen.getListaMedicamentos().get(i).getClave() == clave){
                bandera = true;  
            }
        }
        return bandera;
    }

    public static void sumarExistencia(Almacen almacen, int add, int clave){
        for (int i=0; i<almacen.getListaMedicamentos().size();i++){
            if(almacen.getListaMedicamentos().get(i).getClave()==clave){
                add=add+almacen.getListaMedicamentos().get(i).getPiezas();
                almacen.getListaMedicamentos().get(i).setPiezas(add);
                System.out.println("Inventario actualizado :"+almacen.getListaMedicamentos().get(i).getNombre()+" "+almacen.getListaMedicamentos().get(i).getPiezas());
            }
        }
    }

    public static void restarExistencia(Almacen almacen){       ///////Esta funcion no esta en el menu principal
        Scanner entrada = new Scanner(System.in);
        int clave;
        int baja=0;
        do{
        System.out.println("Buscar clave");
        clave=entrada.nextInt();
            for (int i=0; i<almacen.getListaMedicamentos().size();i++){
                if(almacen.getListaMedicamentos().get(i).getClave()==clave){
                    do{
                        System.out.println("Piezas a dar de baja:");
                        baja=entrada.nextInt();
                        if(baja>0){
                            int aux=almacen.getListaMedicamentos().get(i).getPiezas();
                            aux=aux-baja;
                            almacen.getListaMedicamentos().get(i).setPiezas(aux);
                        }
                    }while(baja<1); 
                }else{System.out.println("Error: clave no encontrada");}
            }entrada.close();
        }while(clave<1);
    }

    public static boolean buscarLote(Almacen almacen, String lote){
        boolean bandera=false;
        for(int i=0; i<almacen.getListaMedicamentos().size();i++){
            if(almacen.getListaMedicamentos().get(i).getLote()==lote){
                bandera = true;
            }
        }return bandera;
    }
}