package ico.fes.aragon.unam.mx.clases;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public List<List<Integer>> generador(int[] nums) {
        List<List<Integer>> resultado = new ArrayList<>();
        backtracking(resultado, new ArrayList<>(), nums);
        return resultado;
    }

    private void backtracking(List<List<Integer>> resultado, List<Integer> temporal, int[] nums) {
        // Si la lista temporal tiene el mismo tamaño que nums, se ha encontrado una permutación
        if (temporal.size() == nums.length) {
            resultado.add(new ArrayList<>(temporal));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (temporal.contains(nums[i])) continue; // Evita duplicados
                temporal.add(nums[i]); // Añade el número a la permutación
                backtracking(resultado, temporal, nums); // Recurre con el número añadido
                temporal.remove(temporal.size() - 1); // Retrocede, eliminando el último número añadido
            }
        }
    }


}
