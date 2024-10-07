package ico.fes.aragon.unam.mx.inicio;

import ico.fes.aragon.unam.mx.clases.Backtracking;
import ico.fes.aragon.unam.mx.clases.Pila;

import java.util.List;

public class Laberinto {
    private static final int[][] laberinto = {
            {0,1,0,0,0},
            {0,1,0,1,0},
            {0,0,0,1,0},
            {0,1,1,1,0},
            {0,0,0,0,0},


    };
    private static final int N = laberinto.length;
    private static final int [][] solucion = new int[N][N];
    private static final int[] movFila = {0,1,0,-1};
    private static final int[] movColumna = {1,0,-1,0};


    public static void main(String[] args) {
        int[][] solucion;
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
        public static boolean resolverlaberinto(int x, int y,int finx,int finy, Pila<String> Laberintopila){
            if(x == finx && y == finy){
                solucion [x][y]=1;

                Laberintopila.push("{"+x+","+y+")");
            }
            if(esValido(x,y)){
                solucion[x][y] = 1;  // Marcar como parte del camino
                Laberintopila.push("(" + x + ", " + y + ")");  // Agregar la posición a la pila
            for (int i =0; i<4; i++){
                int nuevoX = x+movFila[i];
                int nuevoY = y+movColumna[i];

                if(resolverlaberinto(nuevoX, nuevoY, finx,finy,Laberintopila)){
                    return true;
                }

            }
            solucion[x][y] = 0;
            Laberintopila.pop();

        }

   //}
            return false;
}

    private static boolean esValido(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N && laberinto[x][y] == 0 && solucion[x][y] == 0);

    }

    private static void imprimirSolucion() {
        Backtracking backtracking = new Backtracking();
        int[] nums = {0,1,0,0};
        List<List<Integer>> LaberintoPilas = backtracking.generador(nums);

        // Imprime todas las permutaciones generadas
        for (List<Integer> lista : LaberintoPilas) {
            System.out.println(lista);
        }
    }

}

