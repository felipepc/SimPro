import java.util.*;

public class Conta
{
    private int numero;
    private double saldo;
    private double limite;
    private String status;
    private ArrayList <Movimentacao> movimentos;
    
    public Conta(int n, double s, double l, String st)
    {
        numero=n;
        saldo=s;
        limite=l;
        status=st;
        movimentos = new ArrayList<Movimentacao>();
    }
    
    public void setLimite (double l)
    {
        limite=l;
    }
    
    public void incrementaSaldo(double v)
    {
        saldo=saldo+v;
    }
    
    public void diminuiSaldo(double v)
    {
        saldo=saldo-v;
    }
    
    public String getInformacoes()
    {
        return "Conta: "+numero+" Saldo: "+saldo+" Limite: "+limite+" Tipo: "+status;
    }
    
    public boolean efetuaMovimentacao(Movimentacao m)
    {
        if (m.getTipo()=='C')
        {
            incrementaSaldo(m.getValor());
            movimentos.add(m);
        }
        else
        {
            if (m.getValor()<=(saldo+limite))
            {
                if (m.getValor()<saldo)
                {
                    diminuiSaldo(m.getValor());
                    
                }
                else
                {
                    if(m.getValor() <= (saldo+limite)){
                        diminuiSaldo(m.getValor());
                    }
                }
                movimentos.add(m);
            }
        }
        return true;
    }
        
    public void mostrarMovimentacoes()
    {
        Movimentacao m;
        int i=0;
        while(i<movimentos.size())
        {
            m= movimentos.get(i);
            System.out.println(m.getInformacoes());
            i++;
        }
    }
    
    public int removeMovimentacao(int i)
    {
        if (!movimentos.isEmpty())
        {
            movimentos.get(i).changeTipo();
            efetuaMovimentacao(movimentos.get(i));
            movimentos.remove(i);
            movimentos.remove(i);
            
        }
        return movimentos.size();
    }
}


