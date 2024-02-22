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
                    resp2 = entrada.nextInt();
                }while(resp2 < 2 && resp2 > 0);
            }else if( resp == 2) {
                verListaDeMedicamentos(almacen);
            }
            System.out.println("¿Desea volver al menu principal?\n 1.- si \nOtra tecla.-salir");
            resp2 = entrada.nextInt();
        }while(resp2 == 1);
    }
    public static void añadirMedicamento(Almacen almacen){
        String nombre;
        int clave;
        int piezas;
        Scanner entrada = new Scanner(System.in);
        System.out.println("1.- Via oral \n2.- Via intravenosa");
        int resp = entrada.nextInt();
        if (resp==1 ){
            float gramaje;
            entrada.nextLine();
            ViaOral objMedic = new ViaOral();
            System.out.println("ingrese nombre del medicamento: ");
            nombre = entrada.nextLine();
            System.out.println("ingrese clave para " + nombre);
            clave = entrada.nextInt();
            entrada.nextLine();
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
            System.out.println("ingrese nombre del medicamento: ");
            nombre = entrada.nextLine();
            System.out.println("ingrese clave para" + nombre);
            clave = entrada.nextInt();
            entrada.nextLine();
            System.out.println("ingrese fecha de caducidad para " + nombre);
            String caducidad = entrada.nextLine();
            System.out.println("ingrese disolucion: ");
            disolucion = entrada.nextLine();
            System.out.println("¿cuantas piezas de "+ nombre + " desea agregar");
            piezas = entrada.nextInt();
            objMedic.setNombre(nombre);
            objMedic.setClave(clave);
            objMedic.setCaducidad(caducidad);
            objMedic.setDisolucion(disolucion);
            objMedic.setPiezas(piezas);
            almacen.addMedicamento(objMedic);


        }

    }
    public static void verListaDeMedicamentos(Almacen almacen){
        for (int i = 0; i < almacen.getListaMedicamentos().size(); i++) {
            System.out.println(almacen.getListaMedicamentos().get(i).getNombre());
            System.out.println(almacen.getListaMedicamentos().get(i).getClave());
            System.out.println(almacen.getListaMedicamentos().get(i).getCaducidad());
            System.out.println(almacen.getListaMedicamentos().get(i).getCaducidad());
            System.out.println("");

        }
        /*almacen.getListaMedicamentos().forEach(() => {

        });*/
    }
}