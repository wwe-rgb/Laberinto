package ico.fes.aragon.unam.mx.clases;

import java.util.LinkedList;

public class Pila<T> {
    private LinkedList<T> stack;

    public Pila() {
        stack = new LinkedList<>();
    }


    public boolean estVacio() {
        boolean res = false;
        if(this.stack.size()== 0){
            res = true;

        }
        return res;
}
    public int longitud(){
        return this.stack.size();
    }
    public void push(T item) {
        stack.addFirst(item);
    }
    public char pop() {
        stack.removeLast();
        return 0;
    }
   public T peek() {
        return stack.getFirst();
   }

    @Override
    public String toString() {
        return "Pila{" +
                "stack=" + stack +
                '}';
    }
}