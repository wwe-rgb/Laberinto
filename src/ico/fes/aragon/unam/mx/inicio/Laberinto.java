package ico.fes.aragon.unam.mx.inicio;

import ico.fes.aragon.unam.mx.clases.Array2d;
import ico.fes.aragon.unam.mx.clases.Backtracking;
import ico.fes.aragon.unam.mx.clases.Pila;

import java.util.ArrayList;
import java.util.List;

public class Laberinto {
    private static Array2d laberinto = new Array2d(5,5);
    private static final int N = laberinto.getFilas();
    private static Array2d solucion  = new Array2d(N,N);
    private static final int[] movFila = {0,-1,0,1};
    private static final int[] movColumna = {-1,0,1,0};


    public static void main(String[] args) {
        configurarLaberinto();
        int inicioX = 0, inicioY = 0;
        int finX= 4, finY = 4;
        Pila<String> Laberintopilas = new Pila<>();
        if(resolverlaberinto( inicioX, inicioY, finX, finY, Laberintopilas)){
            System.out.println("Camino encontrado");
            imprimirSolucion();
            System.out.println("\n recorrido completo");
            while (!Laberintopilas.estVacio()) {
                System.out.println(Laberintopilas.pop());

            }
        }else{
                System.out.println("Camino no encontrado");
            }
    }

    private static void configurarLaberinto() {
        laberinto.setData(0,0,0);
        laberinto.setData(0,1,1);
        laberinto.setData(0,2,0);
        laberinto.setData(0,3,0);
        laberinto.setData(0,4,0);
        laberinto.setData(1,0,0);
        laberinto.setData(1,1,1);
        laberinto.setData(1,2,0);
        laberinto.setData(1,3,1);
        laberinto.setData(1,4,0);
        laberinto.setData(2,0,0);
        laberinto.setData(2,1,0);
        laberinto.setData(2,2,0);
        laberinto.setData(2,3,1);
        laberinto.setData(2,4,0);
        laberinto.setData(3,0,0);
        laberinto.setData(3,1,1);
        laberinto.setData(3,2,1);
        laberinto.setData(3,3,1);
        laberinto.setData(3,4,0);
        laberinto.setData(4,0,0);
        laberinto.setData(4,1,0);
        laberinto.setData(4,2,0);
        laberinto.setData(4,3,0);
        laberinto.setData(4,4,0);
    }

    public static boolean resolverlaberinto(int x, int y,int finx,int finy, Pila<String> Laberintopila){
            if(x == finx && y == finy){
                solucion.setData(x,y,1);

                Laberintopila.push("{"+x+","+y+")");
                return true;
            }
            if(esValido(x,y)){
                solucion.setData(x,y,1);// Marcar como parte del camino
                Laberintopila.push("{" + x + ", " + y + ")");  // Agregar la posición a la pila
            for (int i =0; i<4; i++){
                int nuevoX = x+movFila[i];
                int nuevoY = y+movColumna[i];

                if(resolverlaberinto(nuevoX, nuevoY, finx,finy,Laberintopila)){
                    return true;
                }

            }
            solucion.setData(x,y,1);
            Laberintopila.pop();

        }

   //}
            return false;
}

    private static boolean esValido(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && laberinto.getData(x,y)==0 && solucion.getData(x,y)== 0);

    }

    private static void imprimirSolucion() {
        Backtracking backtracking = new Backtracking();
        int[] nums = {0,1,0,0,1};
        List<List<Integer>> LaberintoPilas = backtracking.generador(nums);

        // Imprime todas las permutaciones generadas
        for (List<Integer> lista : LaberintoPilas) {
            System.out.println(lista);//
        }
    }

}

