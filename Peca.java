
/**
 * Representa uma Pe�a do jogo.
 * Possui uma casa e um tipo associado.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 * modificações para superclasse realizadas por Luana Macêdo;
 */
public abstract class Peca {
    protected static Cor jogador = Cor.BRANCA ;
    protected Casa casa;    
    protected Cor cor;
    protected Tabuleiro tabuleiro;
    public boolean movimentoDuplo;
    public boolean primeiroMovimento;
    
    public Peca(Casa casa, Cor cor, Tabuleiro tabuleiro) {        
        this.casa = casa;
        this.cor = cor;        
        this.tabuleiro = tabuleiro;
        casa.colocarPeca(this);
    }

    
    /**
     * Movimenta a peca para uma nova casa.
     * @param destino nova casa que ira conter esta peca.
     */
    //Não mexam nessa classe
    public void mover(Casa destino) {
        if(podeMover(destino)){
            casa.removerPeca();
            destino.colocarPeca(this);
            casa = destino;
            if(getTipo()==Tipo.PEAO){
                if(destino.getY()==7){
                 destino.removerPeca();
                 Peca peca = new Rainha(destino, cor.BRANCA, tabuleiro);
            
                }
                if(destino.getY()==0){
                  destino.removerPeca();
                  Peca peca = new Rainha(destino, cor.PRETA, tabuleiro);
            
                }
                
            }
            if(jogador==Cor.BRANCA) { 
                    jogador=Cor.PRETA;
                }
            else {
                    jogador=Cor.BRANCA;
                }
            
            }
        else{
                System.out.println("Não se pode mover da Casa (" + casa.getX() + "," + casa.getY() + ") para a Casa (" + 
                destino.getX() + "," + destino.getY() + ")");
            }
    }
    
    // Para restringir os movimentos utilize essa classe(ou seja reescreva ela na sua classe peça utilizando polimorfismo)
    public abstract boolean podeMover(Casa destino);
    
    public Cor getCor()
    {
        return cor;
    }
    
    public abstract Tipo getTipo();
    
    public boolean getPrimeiroMovimento()
    {
        return primeiroMovimento;
    }
    
    public boolean getMovimentoDuplo()
    {
        return movimentoDuplo;
    }
    
    public boolean ehMesmaCor(Peca outra) 
    {
        return this.cor == outra.cor;
    }
}
