package ch.heigvd.dai;

public class Addition extends Operation
{
    @Override
    public int calcul(int lhs, int rhs)
    {
        return lhs + rhs;
    }
}
