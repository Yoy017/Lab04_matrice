package ch.heigvd.dai;

public class Main {
    static private final int MODULO = 5;

    public static void main(String[] args) {
        AdditionTemplate();
        testMatrixCreationValid();
        testMatrixCreationInvalidDimensions();
        testMatrixCreationInvalidMod();
        testMatrixOperationDifferentSizes();
        testMatrixOperationDifferentMod();
    }

    public static void AdditionTemplate()
    {
        int[][] content1 = {
                {1 ,3 ,1 ,1},
                {3 ,2 ,4 ,2},
                {1 ,0 ,1 ,0}
        };
        Matrix one = new Matrix(content1, MODULO);
        System.out.println("one\n" + one);
        int[][] content2 = {
                {1 ,4 ,2 ,3 ,2},
                {0 ,1 ,0 ,4 ,2},
                {0 ,0 ,2 ,0 ,2}
        };
        Matrix two = new Matrix(content2, MODULO);
        System.out.println("two\n" + two);

        Matrix add = Matrix.operation(one, two, new Addition());
        System.out.println("one + two\n" + add);

        Matrix sub = Matrix.operation(one, two, new Soustraction());
        System.out.println("one - two\n" + sub);

        Matrix mul = Matrix.operation(one, two, new Multiplication());
        System.out.println("one x two\n" + mul);
    }

    public static void testMatrixCreationValid() {
        try {
            Matrix matrix = new Matrix(3, 3, 10);
            if (matrix.getRow() != 3 || matrix.getColumn() != 3) {
                System.out.println("testMatrixCreationValid: FAILED (Dimensions incorrectes)");
                return;
            }
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    if (matrix.getContent()[y][x] < 0 || matrix.getContent()[y][x] >= 10) {
                        System.out.println("testMatrixCreationValid: FAILED (Valeur hors du modulo)");
                        return;
                    }
                }
            }
            System.out.println("testMatrixCreationValid: PASSED");
        } catch (Exception e) {
            System.out.println("testMatrixCreationValid: FAILED (Exception : " + e.getMessage() + ")");
        }
    }

    public static void testMatrixCreationInvalidDimensions() {
        try {
            new Matrix(-1, 5, 10);
            System.out.println("testMatrixCreationInvalidDimensions: FAILED (Exception non levée)");
        } catch (IllegalArgumentException e) {
            System.out.println("testMatrixCreationInvalidDimensions: PASSED");
        }

        try {
            new Matrix(5, 0, 10);
            System.out.println("testMatrixCreationInvalidDimensions: FAILED (Exception non levée)");
        } catch (IllegalArgumentException e) {
            System.out.println("testMatrixCreationInvalidDimensions: PASSED");
        }
    }

    public static void testMatrixCreationInvalidMod() {
        try {
            new Matrix(3, 3, -10);
            System.out.println("testMatrixCreationInvalidMod: FAILED (Exception non levée)");
        } catch (IllegalArgumentException e) {
            System.out.println("testMatrixCreationInvalidMod: PASSED");
        }
    }

    public static void testMatrixOperationDifferentSizes() {
        try {
            Matrix m1 = new Matrix(new int[][]{{1, 2}}, 10); // 1x2
            Matrix m2 = new Matrix(new int[][]{{3}, {4}}, 10); // 2x1
            Matrix result = Matrix.operation(m1, m2, new Addition());

            if (result.getContent()[0][0] == 4 && result.getContent()[0][1] == 2 &&
                    result.getContent()[1][0] == 4 && result.getContent()[1][1] == 0) {
                System.out.println("testMatrixOperationDifferentSizes: PASSED");
            } else {
                System.out.println("testMatrixOperationDifferentSizes: FAILED");
            }
        } catch (Exception e) {
            System.out.println("testMatrixOperationDifferentSizes: FAILED (Exception : " + e.getMessage() + ")");
        }
    }

    public static void testMatrixOperationDifferentMod() {
        try {
            Matrix m1 = new Matrix(new int[][]{{1, 2}}, 10);
            Matrix m2 = new Matrix(new int[][]{{3, 4}}, 5);
            Matrix.operation(m1, m2, new Addition());
            System.out.println("testMatrixOperationDifferentMod: FAILED");
        } catch (IllegalArgumentException e) {
            System.out.println("testMatrixOperationDifferentMod: PASSED");
        }
    }
}