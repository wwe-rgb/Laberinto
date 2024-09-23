package ico.fes.aragon.unam.mx.clases;

import java.util.LinkedList;

public class Pila<E> {
    private LinkedList<E> stack;

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
    public void push(E item) {
        stack.addFirst(item);
    }
    public char pop() {
        stack.removeLast();
        return 0;
    }
   public E peek() {
        return stack.getFirst();
   }

    @Override
    public String toString() {
        return "Pila{" +
                "stack=" + stack +
                '}';
    }
}