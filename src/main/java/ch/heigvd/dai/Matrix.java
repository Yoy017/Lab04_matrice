package ch.heigvd.dai;

public class Matrix {

    int m; //ligne / row : (y)
    int n; //colonne / index in row : (x)
    int mod;
    int[][] content;

    public Matrix(int m, int n, int mod){
        this.m = m;
        this.n = n;
        this.mod = mod;
        content = new int[m][n];

        for(int y = 0; y < m; y++){
            for(int x = 0; x < n; x++) {
                content[y][x] = (int)(Math.random() * mod);
            }
        }
    }

    public Matrix(int[][] content, int mod){

        for(int y = 0; y < content.length; ++y){
            for(int x = 0; x < content[0].length; ++x) {
                if(content[y][x] >= 0 && content[y][x] < mod) continue;
                throw new ArithmeticException();
            }
        }

        this.m = content.length;
        this.n = content[0].length;
        this.mod = mod;
        this.content = content;
    }

    public static Matrix operation(Matrix lhs, Matrix rhs, Operation op)
    {
        if(lhs.mod != rhs.mod)
        {
            throw new ArithmeticException();
        }

        Matrix res = new Matrix(Math.max(lhs.m, rhs.m), Math.max(lhs.n, rhs.n), lhs.mod);
        for(int y = 0; y < res.m; ++y){
            for(int x = 0; x < res.n; ++x) {
                //Fixe issue where one matrice is smaller than the other
                int lhsOp = y >= lhs.m || x >= lhs.n ? 0 : lhs.content[y][x];
                int rhsOp = y >= rhs.m || x >= rhs.n ? 0 : rhs.content[y][x];
                res.content[y][x] = Math.floorMod(op.calcul(lhsOp, rhsOp), res.mod);
            }
        }
        return res;
    }

    @Override
    public String toString(){
        String res = "";
        for(int y = 0; y < m; ++y){
            for(int x = 0; x < n; ++x) {
                res += content[y][x] + " ";
            }
            res += '\n';
        }
        return res;
    }
}
