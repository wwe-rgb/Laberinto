package ico.fes.aragon.unam.mx.inicio;

import ico.fes.aragon.unam.mx.clases.Pila;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static boolean verificarBalance(String texto) {

        Pila<Character> pila = new Pila<>();

        for (char c : texto.toCharArray()) {

        if (c == '{' || c == '(') {
            pila.push(c);
        }
        // Si es una llave o paréntesis de cierre, verificamos la pila
        else if (c == '}' || c == ')') {
            // Si la pila está vacía o no coincide el cierre con la apertura
            if (pila.estVacio()) {
                return false;
            }

            char cima = pila.pop();

            // Verificamos que las llaves o paréntesis coincidan
            if ((c == '}' && cima != '{') || (c == ')' && cima != '(')) {
                return false;
            }
        }
    }

    // Si al final la pila no está vacía, significa que quedaron llaves o paréntesis sin cerrar
        return pila.estVacio();
}

        public static void main(String[] args) {
            String textoPrueba = "{(Esto es un texto de prueba)}";
            boolean balanceado = verificarBalance(textoPrueba);

            if (balanceado) {
                System.out.println("El texto tiene llaves y paréntesis balanceados.");
            } else {
                System.out.println("El texto NO tiene llaves y paréntesis balanceados.");
            }
        }
}