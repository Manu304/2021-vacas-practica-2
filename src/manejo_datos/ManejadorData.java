package src.manejo_datos;

public class ManejadorData {


    public ManejadorData(){

    }

    public static Object[] ordenarNombre(Object[] datos, int totalData, boolean ascendente){
        boolean cambio = true;
        Object selec = null;
        int pos = 0;

        for (int i = 0; i < totalData; i++) {
            selec = datos[i];
            pos = i;

            for (int j = i+1; j < totalData; j++) {
                
                if (ascendente) {
                    cambio = selec.toString().compareTo(datos[j].toString()) > 0;
                    
                }else{
                    cambio = selec.toString().compareTo(datos[j].toString()) < 0;
                }
                if (cambio){
                    selec = datos[j];
                    pos = j;
                }
            }
            datos[pos] = datos[i];
            datos[i] = selec;
        }
        return datos;
    }

    public static String llenarEspacio(String palabra){
        while (palabra.length() < 20) {
            palabra += " ";
        }
        return palabra;
    }

    public static Object [] eliminarVacios (Object [] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length - i; j++) {
                if (arreglo[j] != null) {
                    int indice = j-1;
                    if (indice >= 0) {
                        Object filaAux = arreglo[j];
                        arreglo[j] = arreglo[indice];
                        arreglo[indice] = filaAux;
                    }
                }
            }

        }
        return arreglo;
    }


    
}
