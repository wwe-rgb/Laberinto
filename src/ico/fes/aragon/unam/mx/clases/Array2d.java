package ico.fes.aragon.unam.mx.clases;

public class Array2d {
    private int[][] data;
    private int filas;
    private int columnas;
    public Array2d(int filas, int columnas) {
        this.data = new int[filas][columnas];
    }

    public int getData(int x, int y) {
        return data [x][y];
    }

    public void setData(int x, int y, int valor) {
        this.data[x][y] = valor;
    }

    public int getFilas() {
        return data.length;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return data[0].length;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

}
