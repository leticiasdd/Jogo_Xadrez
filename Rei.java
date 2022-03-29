
/**
 * Write a description of class Rei here.
 *
 * @author Abne
 * @version (a version number or a date)
 */
public class Rei extends Peca
{
    private boolean primeiroMovimento;

    public Rei(Casa casa, Cor cor, Tabuleiro tabuleiro) 
    {
        super(casa, cor, tabuleiro);
        primeiroMovimento = true;
    }

    public boolean podeMover(Casa destino){
        
         int delta_x = Math.abs(destino.getX()-casa.getX());
         int delta_y = Math.abs(destino.getY()-casa.getY());
         
         if(cor!=jogador) { 
              return false;
            }
         
          if(roque(destino)){
              return true;
            }  
        // movimento do Rei
            if (delta_x > 1 || delta_y > 1)
         {
            return false;
         }       
        
        // Verificar se tem alguma peça da mesma cor no destino 
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
    
    public boolean roque(Casa destino)
    {
        int delta_x = destino.getX()-casa.getX();
        int delta_y = destino.getY()-casa.getY();
        int direcaoX=0;
        Peca torreRoque;
        Casa casafinal;
        if(primeiroMovimento){
                if((delta_x==2||delta_x==-2)&& delta_y==0){
                    if(delta_x==2){
                        
                         direcaoX=1;
                         casafinal = tabuleiro.getCasa(casa.getX() + 3, casa.getY());
                         Casa casaTorreFinal = tabuleiro.getCasa(destino.getX() - 1, destino.getY());
                         torreRoque= casafinal.getPeca();
                         Cor cordatorre = getCor();
                         if ((torreRoque.getTipo()==Tipo.TORRE)&& torreRoque.getPrimeiroMovimento()){
                                Casa intermediaria = tabuleiro.getCasa(casa.getX() + direcaoX, casa.getY());  
                                while(intermediaria != destino)
                                {
                   
                                    if(intermediaria.possuiPeca())
                                    {
                                        return false;
                                    }
                                    else
                                    {
                                        intermediaria = tabuleiro.getCasa(intermediaria.getX() + direcaoX, intermediaria.getY());
                                    }
                
                                }
                                casafinal.removerPeca();
                                Torre torre = new Torre(casaTorreFinal, cordatorre, tabuleiro);
                                return true;
                         }
                                        
                  }
            
            }
            if(delta_x==-2){
                
                         direcaoX=-1;
                         casafinal = tabuleiro.getCasa(casa.getX() - 4, casa.getY());
                         Casa casaTorreFinal = tabuleiro.getCasa(destino.getX() + 1, destino.getY());
                         torreRoque= casafinal.getPeca();
                         Cor cordatorre = getCor();
                         if ((torreRoque.getTipo()==Tipo.TORRE)&& torreRoque.getPrimeiroMovimento()){
                                Casa intermediaria = tabuleiro.getCasa(casa.getX() + direcaoX, casa.getY());  
                                while(intermediaria != casafinal)
                                {
                   
                                    if(intermediaria.possuiPeca())
                                    {
                                        return false;
                                    }
                                    else
                                    {
                                        intermediaria = tabuleiro.getCasa(intermediaria.getX() + direcaoX, intermediaria.getY());
                                    }
                
                                }
                                casafinal.removerPeca();
                                Torre torre = new Torre(casaTorreFinal, cordatorre, tabuleiro);
                                return true;
                         }
                
            }
     }
     return false;
}
    
    public Tipo getTipo() 
    {
        return Tipo.REI;        
    }
    
}
