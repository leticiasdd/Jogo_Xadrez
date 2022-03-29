/**
 * Descrição da classe Rainha.
 * 
 * @author Letícia
 * @version (02/06/2021)
 */
public class Rainha extends Peca {

    
    public Rainha(Casa casa, Cor cor, Tabuleiro tabuleiro) 
    {
        super(casa, cor, tabuleiro);
    }        
                  
    
    public boolean podeMover(Casa destino){
        
        int delta_x = Math.abs(destino.getX()-casa.getX());
        int delta_y = Math.abs(destino.getY()-casa.getY());
        
        if(cor!=jogador) { 
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
        
        int direcaoX = 0;
        int direcaoY = 0;
        //movimento diagonal
        if(delta_x == delta_y){

        
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
        //movimento horizontal
        if((delta_x==0 && delta_y != 0)|| (delta_y == 0 && delta_x!=0)){
            
            if (delta_x==0)
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
        
            if (delta_y==0)
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
            return true;
        }
            return false;
        
    }
    
    public Tipo getTipo() 
    {
        return Tipo.RAINHA;
    }
    
}
    
        