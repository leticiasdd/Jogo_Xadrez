
/**
 * Escreva a descrição da classe Cavalo aqui.
 * 
 * @author Lucas Freire 
 * @version 04/06/21
 */
public class Cavalo extends Peca
{


    
    public Cavalo(Casa casa, Cor cor, Tabuleiro tabuleiro) 
    {
        super(casa, cor, tabuleiro);
    }

    /**
     * podeMover - verifica se o cavalo pode se mover em um certo espaço do tabuleiro
     * 
     * @param destino   
     * @return boolean
     */
    public boolean podeMover(Casa destino)
    {
        //calcular o delta x e y:
        int deltaX = Math.abs(destino.getX() - casa.getX());
        int deltaY = Math.abs(destino.getY() - casa.getY());
        boolean destinoTemPecaAliada;
        
        if(cor!=jogador) { 
              return false;
            }
        //ver se não existe peça aliada ocupando a casa de destino:
        if (destino.possuiPeca())
        {
            Peca pecaDestino = destino.getPeca();   
            destinoTemPecaAliada = (ehMesmaCor(pecaDestino));
        }
        else {
            destinoTemPecaAliada = false;
        }
        
        
        //logica de movimentação do cavalo
        
        if( ((deltaX == 2 && deltaY ==1) || (deltaX == 1 && deltaY == 2)) && !destinoTemPecaAliada) { 
            return true;
        }
        return false;
    }
    
    public Tipo getTipo() 
    {
        return Tipo.CAVALO;
        
    }

    
    
    
}
