package ch.heigvd.dai;

public abstract class Operation
{
    public abstract int calcul(int lhs, int rhs);
}

class Addition extends Operation
{
    @Override
    public int calcul(int lhs, int rhs)
    {
        return lhs + rhs;
    }
}

class Multiplication extends Operation
{
    @Override
    public int calcul(int lhs, int rhs) {
        return lhs * rhs;
    }
}

class Soustraction extends Operation
{
    @Override
    public int calcul(int lhs, int rhs) {
        return lhs - rhs;
    }
}