package ch.heigvd.dai;

public class Matrix {
    int n, m, mod;
    int[][] content;

    public Matrix(int n, int m, int mod){
        this.n = n;
        this.m = m;
        this.mod = mod;

        content = new int[n][m];
    }

    public Matrix(int[][] content, int mod){
        this.n = content[0].length;
        this.m = content.length;
        this.mod = mod;
        this.content = content;
    }

    static public Matrix addition(Matrix lhs, Matrix rhs){
        return new Matrix(0, 0, 0);
    }

    static public Matrix soustraction(Matrix lhs, Matrix rhs){
        return new Matrix(0, 0, 0);
    }

    static public Matrix produit(Matrix lhs, Matrix rhs){
        return new Matrix(0, 0, 0);
    }

    static public Matrix modulo(Matrix lhs, int mod){
        return new Matrix(0, 0, 0);
    }

    @Override
    public String toString(){
        String res = "";
        for(int y = 0; y < n; ++y){
            for(int x = 0; x < m; ++x) {
                res += content[y][x];
            }
            res += '\n';
        }

        return res;
    }
}
