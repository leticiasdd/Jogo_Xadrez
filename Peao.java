
/**
 * Escreva a descrição da classe Peao aqui.
 * 
 * @author Luana Macêdo
 * @version (número de versão ou data)
 */
public class Peao extends Peca
{
    private boolean primeiroMovimento;
    private boolean movimentoDuplo;

    
    public Peao(Casa casa, Cor cor, Tabuleiro tabuleiro) {
        super(casa, cor, tabuleiro);
        primeiroMovimento = true;
        movimentoDuplo = false;
    }

    public boolean podeMover(Casa destino){
         movimentoDuplo = false;
         int delta_x = Math.abs(destino.getX()-casa.getX());
         int delta_y = destino.getY()-casa.getY();
         
          if(cor!=jogador) { 
              return false;
            }
          
          if(enPassant(destino)){
            return true;
        
          }  
          
         //verificar movimento caso esteja capturando
          if (Captura(destino))
          {  

            if (cor == Cor.BRANCA)
            {
                if (delta_x==1 && delta_y==1)
                {
                    return true;
                }
                else 
                {
                    return false;
                }
            }
            else
            {
                if (delta_x==1 && delta_y==-1)
                {
                    return true;
                }
                
                else 
                {
                    return false;
                }
            }
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
        //cor branca
        if (cor == Cor.BRANCA)
        { 
          
            if(primeiroMovimento)
            {
                if ((delta_y==1 && delta_x == 0)|| (delta_y==2 && delta_x == 0)){
                    if((delta_y==2 && delta_x == 0)){
                        movimentoDuplo = true;
                    }
                    primeiroMovimento = false;
                    return true;
                }
            }
            else if(delta_y==1 && delta_x == 0)
            {
                return true;
            }
            
        }
        else
        {
            if(primeiroMovimento)
            {
                if ((delta_y==-1 && delta_x == 0 )|| (delta_y==-2 && delta_x == 0)){
                    if((delta_y==-2 && delta_x == 0)){
                        movimentoDuplo = true;
                    }
                    primeiroMovimento = false;
                    return true;
                }
            }
            else if(delta_y==-1 && delta_x == 0)
            {
                return true;
            }
            
            
        }
        
        return false;
    }
     
    private boolean Captura(Casa destino)
    {
        if (destino.possuiPeca())
        {
            Peca pecadestino = destino.getPeca();
            
            if (!ehMesmaCor(pecadestino))
            {
                 return true;
            }
        }
        return false;
    }
    
    public boolean getMovimentoDuplo(){
        return movimentoDuplo;
    }
    
    public boolean enPassant(Casa destino){
        int x = destino.getX();
        int y = destino.getY();
        Casa casa; 
        if(cor == cor.BRANCA){
            casa = tabuleiro.getCasa(x,y-1);
        
        }
        else{
            casa = tabuleiro.getCasa(x,y+1);
        }
           
        Peca pecaAlvo = casa.getPeca();
        if(casa.possuiPeca()){
            if(pecaAlvo.getTipo() == Tipo.PEAO){
                if(pecaAlvo.getMovimentoDuplo()){
                    casa.removerPeca();
                    return true;
                }
            }
        }
        return false;
    }
    
    public Tipo getTipo() 
    {
        return Tipo.PEAO;
        
    }
    
}
