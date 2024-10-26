package ch.heigvd.dai;

/**
 * Représente une opération abstraite entre deux entiers.
 * Les classes dérivées doivent implémenter la méthode de calcul.
 */
public abstract class Operation {
    /**
     * Calcule le résultat de l'opération entre deux entiers.
     * @param lhs la valeur de gauche.
     * @param rhs la valeur de droite.
     * @return le résultat de l'opération entre lhs et rhs.
     */
    public abstract int calcul(int lhs, int rhs);
}

/**
 * Représente une opération d'addition entre deux entiers.
 */
class Addition extends Operation {
    /**
     * Additionne deux entiers.
     * @param lhs la valeur de gauche.
     * @param rhs la valeur de droite.
     * @return la somme de lhs et rhs.
     */
    @Override
    public int calcul(int lhs, int rhs) {
        return lhs + rhs;
    }
}

/**
 * Représente une opération de multiplication entre deux entiers.
 */
class Multiplication extends Operation {
    /**
     * Multiplie deux entiers.
     * @param lhs la valeur de gauche.
     * @param rhs la valeur de droite.
     * @return le produit de lhs et rhs.
     */
    @Override
    public int calcul(int lhs, int rhs) {
        return lhs * rhs;
    }
}

/**
 * Représente une opération de soustraction entre deux entiers.
 */
class Soustraction extends Operation {
    /**
     * Soustrait rhs à lhs.
     * @param lhs la valeur de gauche.
     * @param rhs la valeur de droite.
     * @return la différence entre lhs et rhs.
     */
    @Override
    public int calcul(int lhs, int rhs) {
        return lhs - rhs;
    }
}