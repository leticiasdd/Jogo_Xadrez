
/**
 * Escreva a descrição da classe Bispo aqui.
 * 
 * @author Luana Macêdo 
 * @version (número de versão ou data)
 */
public class Bispo extends Peca
{
    
    public Bispo(Casa casa, Cor cor, Tabuleiro tabuleiro) 
    {
        super(casa, cor, tabuleiro);
    }

    
    public boolean podeMover(Casa destino){
        
         int delta_x = Math.abs(destino.getX()-casa.getX());
         int delta_y = Math.abs(destino.getY()-casa.getY());
         
         if(cor!=jogador) { 
              return false;
            }
         // movimento do Bispo
        if (delta_x!=delta_y)
        {
            return false;
        }
        
        // Verificação se tem uma peça da mesma cor no destino 
        if (destino.possuiPeca())
        {
            Peca pecadestino = destino.getPeca();
            
            if (ehMesmaCor(pecadestino))
            {
                 return false;
            }
        }
        
        int direcaoX;
        int direcaoY;
        
        if (destino.getX()>casa.getX()){
            direcaoX = 1;
        }
        else{
            direcaoX=-1;
        }
        
        if (destino.getY()>casa.getY()){
            direcaoY = 1;
        }
        else{
            direcaoY=-1;
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
        
        return true;
        
    }
    
    
    public Tipo getTipo() 
    {
        return Tipo.BISPO;
        
    }
   
}
