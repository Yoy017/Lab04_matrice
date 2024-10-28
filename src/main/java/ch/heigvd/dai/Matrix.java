package ch.heigvd.dai;

/**
 * Représente une matrice avec des valeurs entières.
 * Chaque valeur de la matrice est modifiée par un modulo spécifié.
 */
public class Matrix {

    private int m; //ligne / row : (y)
    private int n; //colonne / index in row : (x)
    private int mod;
    private int[][] content;

    //Accesseurs
    public int getRow()  { return m; }
    public int getColumn() { return n; }
    public int getModulo() { return mod; }
    public int[][] getContent() { return content; }

    /**
     * Crée une matrice de dimensions spécifiées et initialise chaque élément
     * avec une valeur aléatoire comprise entre 0 (inclus) et mod (exclus).
     * @param m    le nombre de lignes de la matrice. Doit être positif.
     * @param n le nombre de colonnes de la matrice. Doit être positif.
     * @param mod     le modulo utilisé pour les éléments de la matrice. Doit être positif.
     * @throws IllegalArgumentException si rows, columns, ou mod est inférieur ou égal à 0.
     */
    public Matrix(int m, int n, int mod) {

        if (m <= 0 || n <= 0 || mod <= 0) {
            throw new IllegalArgumentException("Les dimensions et le modulo doivent être positifs.");
        }

        this.m = m;
        this.n = n;
        this.mod = mod;
        content = new int[m][n];

        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                content[y][x] = (int)(Math.random() * mod);
            }
        }
    }

    /**
     * Crée une matrice à partir d'un contenu existant et d'un modulo.
     * Vérifie que toutes les valeurs du contenu respectent le modulo.
     * @param content le tableau de valeurs pour initialiser la matrice.
     * @param mod     le modulo utilisé pour les éléments de la matrice. Doit être positif.
     * @throws IllegalArgumentException si mod est inférieur ou égal à 0 ou si le contenu n'est pas valide.
     */
    public Matrix(int[][] content, int mod) {
        if (mod <= 0) {
            throw new IllegalArgumentException("Le modulo doit être positif.");
        }
        this.m = content.length;
        this.n = content[0].length;
        this.mod = mod;
        //this.content = content;
        this.content = new int[m][n];

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if (content[y][x] < 0 || content[y][x] >= mod) {
                    throw new IllegalArgumentException("Les valeurs doivent être entre 0 (inclus) et le modulo (exclus).");
                }
                this.content[y][x] = content[y][x];
            }
        }
    }

    /**
     * Effectue une opération sur deux matrices et retourne le résultat.
     * La matrice retournée a les dimensions maximales des deux matrices.
     * Si les dimensions sont différentes, les valeurs manquantes sont considérées comme 0.
     * @param rhs autre matrice.
     * @param op  l'opération à effectuer entre les éléments.
     * @return une nouvelle matrice résultant de l'opération.
     * @throws IllegalArgumentException si les modulos des matrices ne sont pas identiques.
     */
    public Matrix operation(Matrix rhs, Operation op) {
        if(mod != rhs.mod) {
            throw new IllegalArgumentException("Les matrices doivent avoir le même modulo.");
        }

        Matrix res = new Matrix(Math.max(m, rhs.m), Math.max(n, rhs.n), mod);
        for(int y = 0; y < res.m; y++) {
            for(int x = 0; x < res.n; x++) {
                //Fixe issue where one matrice is smaller than the other
                int lhsOp = y >= m || x >= n ? 0 : content[y][x];
                int rhsOp = y >= rhs.m || x >= rhs.n ? 0 : rhs.content[y][x];
                res.content[y][x] = Math.floorMod(op.calcul(lhsOp, rhsOp), res.mod);
            }
        }
        return res;
    }

    /**
     * Retourne une représentation en chaîne de caractères de la matrice.
     * @return la chaîne de caractères représentant la matrice.
     */
    @Override
    public String toString() {
        String res = "";
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                res += content[y][x] + " ";
            }
            res += '\n';
        }
        return res;
    }
}
