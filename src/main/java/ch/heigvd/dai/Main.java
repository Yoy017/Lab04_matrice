package ch.heigvd.dai;

public class Main {
    static private final int MODULO = 5;

    public static void main(String[] args) {
        Matrix one = new Matrix(4, 4, MODULO);

        int[][] content = {
                {0, 1, 2},
                {4, 5, 6},
                {7, 8, 9}
        };
        Matrix dos = new Matrix(content, MODULO);
        System.out.println(one);
        System.out.println(dos);
    }
}