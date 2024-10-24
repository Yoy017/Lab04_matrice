package ch.heigvd.dai;

public class Main {
    static private final int MODULO = 5;

    public static void main(String[] args) {
        Matrix one = new Matrix(3, 4, MODULO);

        int[][] content = {
                {0, 1, 2},
                {4, 0, 3},
                {2, 1, 4}
        };
        Matrix dos = new Matrix(content, MODULO);

        System.out.println(one);
        System.out.println(dos);
    }
}