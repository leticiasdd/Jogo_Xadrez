

//Torre
public class Torre extends Peca
{
    private boolean primeiroMovimento;
            
    public Torre(Casa casa, Cor cor, Tabuleiro tabuleiro) 
    {
        super(casa, cor, tabuleiro);
        primeiroMovimento = true;
    }
    
    //mover a peca
    public boolean podeMover(Casa destino){
        
         int x = Math.abs(destino.getX()-casa.getX());
         int y = Math.abs(destino.getY()-casa.getY());
         
         if(cor!=jogador) { 
              return false;
            }

        if (x > 0 && y > 0)
        {
            return false;
        }
        
        int direcaoX=0;
        int direcaoY=0;
        
        if (x==0)
        {
            if(destino.getY()>casa.getY())
            {
                direcaoY = 1;
            }
            else
            {
                direcaoY = -1;
            }
        }
        
        if (y==0)
        {
            
            if(destino.getX()>casa.getX())
            {
                direcaoX = 1;
            }
            else
            {
                direcaoX = -1;
            }
        }
        
        //Verificação se há alguma peça no caminho
        Casa intermediaria = tabuleiro.getCasa(casa.getX() + direcaoX, casa.getY() + direcaoY);
        
          while(intermediaria != destino)
            {
                if(intermediaria.possuiPeca())
                {
                    return false;
                }
                else
                {
                    intermediaria = tabuleiro.getCasa(intermediaria.getX() + direcaoX, intermediaria.getY() + direcaoY);
                }
               
           }
        // verificar se tem peca da mesma cor
        if (destino.possuiPeca())
        {
            Peca pecadestino = destino.getPeca();
            
            if (ehMesmaCor(pecadestino))
            {
                 return false;
            }
        }
        primeiroMovimento = false;
        return true;
    }
    
    public boolean getPrimeiroMovimento() 
    {
        return primeiroMovimento;
    }
    
    public Tipo getTipo() 
    {
        return Tipo.TORRE;
        
    }
    
}