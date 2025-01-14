package src.tienda;

import java.util.*;

public class IngresoDatos {
    static Scanner scanner = new Scanner(System.in);

    private static void imprimirMensaje(String mensaje) {
        System.out.print("\nIngrese " + mensaje + ": ");
    }

    public static int getEntero(String mensaje, boolean negativo) {
        imprimirMensaje(mensaje);
        int tmp = scanner.nextInt();

        if (negativo) {
            return tmp;
        }

        if (tmp < 0) {
            do {
                imprimirMensaje("\nERROR. No puede ingresar números negativos\n");
                imprimirMensaje(mensaje);
                tmp = scanner.nextInt();
            } while (tmp < 0);
        }

        return tmp;
    }

    public static String getTexto(String mensaje) {
        imprimirMensaje(mensaje);
        scanner.nextLine();
        String res = scanner.nextLine().toLowerCase().trim();
        return res;
    }

    public static int aleatorio(int minimo, int maximo) {
        int aleatorio = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
        return aleatorio;
    }
}