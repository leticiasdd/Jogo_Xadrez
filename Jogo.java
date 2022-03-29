
/**
 * Armazena o tabuleiro e responsavel por posicionar as pecas.
 * 
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class Jogo {

    private Tabuleiro tabuleiro;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        criarPecas();
    }
    
    /**
     * Posiciona pe�as no tabuleiro.
     * Utilizado na inicializa�ao do jogo.
     */
    private void criarPecas() {
        
        Casa casa1 = tabuleiro.getCasa(0, 0);
        Torre torre1 = new Torre(casa1, Cor.BRANCA, tabuleiro);
        
        Casa casa2 = tabuleiro.getCasa(1, 0);
        Cavalo cavalo1 = new Cavalo(casa2, Cor.BRANCA,tabuleiro);
        
        Casa casa3 = tabuleiro.getCasa(2, 0);
        Bispo bispo1 = new Bispo(casa3, Cor.BRANCA,tabuleiro);
        
        Casa casa4 = tabuleiro.getCasa(3, 0);
        Rainha rainha1 = new Rainha(casa4, Cor.BRANCA,tabuleiro);
        
        Casa casa5 = tabuleiro.getCasa(4, 0);
        Rei rei2 = new Rei(casa5, Cor.BRANCA, tabuleiro);
        
        Casa casa6 = tabuleiro.getCasa(5, 0);
        Bispo bispo2 = new Bispo(casa6, Cor.BRANCA,tabuleiro);
        
        Casa casa7 = tabuleiro.getCasa(6, 0);
        Cavalo cavalo2 = new Cavalo(casa7, Cor.BRANCA,tabuleiro);
        
        Casa casa8 = tabuleiro.getCasa(7, 0);
        Torre torre2 = new Torre(casa8, Cor.BRANCA, tabuleiro);
        
        Casa casa9 = tabuleiro.getCasa(0, 7);
        Torre torre3 = new Torre(casa9, Cor.PRETA, tabuleiro);
        
        Casa casa10 = tabuleiro.getCasa(1, 7);
        Cavalo cavalo3 = new Cavalo(casa10, Cor.PRETA,tabuleiro);
        
        Casa casa11 = tabuleiro.getCasa(2, 7);
        Bispo bispo3 = new Bispo(casa11, Cor.PRETA,tabuleiro);
        
        Casa casa12 = tabuleiro.getCasa(3, 7);
        Rainha rainha2 = new Rainha(casa12, Cor.PRETA, tabuleiro);
        
        Casa casa13 = tabuleiro.getCasa(4, 7);
        Rei rei1 = new Rei(casa13, Cor.PRETA, tabuleiro);

        Casa casa14 = tabuleiro.getCasa(5, 7);
        Bispo bispo4 = new Bispo(casa14, Cor.PRETA,tabuleiro);
        
        Casa casa15 = tabuleiro.getCasa(6, 7);
        Cavalo cavalo4 = new Cavalo(casa15, Cor.PRETA,tabuleiro);
        
        Casa casa16 = tabuleiro.getCasa(7, 7);
        Torre torre4 = new Torre(casa16, Cor.PRETA, tabuleiro);
        
        Casa casa17 = tabuleiro.getCasa(0, 1);
        Peao peao1 = new Peao(casa17, Cor.BRANCA,tabuleiro);

        Casa casa18 = tabuleiro.getCasa(1, 1);
        Peao peao2 = new Peao(casa18, Cor.BRANCA,tabuleiro);

        Casa casa19 = tabuleiro.getCasa(2, 1);
        Peao peao3 = new Peao(casa19, Cor.BRANCA,tabuleiro);

        Casa casa20 = tabuleiro.getCasa(3, 1);
        Peao peao4 = new Peao(casa20, Cor.BRANCA,tabuleiro);

        Casa casa21 = tabuleiro.getCasa(4, 1);
        Peao peao5 = new Peao(casa21, Cor.BRANCA,tabuleiro);

        Casa casa22 = tabuleiro.getCasa(5, 1);
        Peao peao6 = new Peao(casa22, Cor.BRANCA,tabuleiro);

        Casa casa23 = tabuleiro.getCasa(6, 1);
        Peao peao7 = new Peao(casa23, Cor.BRANCA,tabuleiro);

        Casa casa24 = tabuleiro.getCasa(7, 1);
        Peao peao8 = new Peao(casa24, Cor.BRANCA,tabuleiro);
        
        Casa casa25 = tabuleiro.getCasa(0, 6);
        Peao peao9 = new Peao(casa25, Cor.PRETA,tabuleiro);

        Casa casa26 = tabuleiro.getCasa(1, 6);
        Peao peao10 = new Peao(casa26, Cor.PRETA,tabuleiro);

        Casa casa27 = tabuleiro.getCasa(2, 6);
        Peao peao11 = new Peao(casa27, Cor.PRETA, tabuleiro);

        Casa casa28 = tabuleiro.getCasa(3, 6);
        Peao peao12 = new Peao(casa28, Cor.PRETA,tabuleiro);

        Casa casa29 = tabuleiro.getCasa(4, 6);
        Peao peao13 = new Peao(casa29, Cor.PRETA,tabuleiro);

        Casa casa30 = tabuleiro.getCasa(5, 6);
        Peao peao14 = new Peao(casa30, Cor.PRETA, tabuleiro);

        Casa casa31 = tabuleiro.getCasa(6, 6);
        Peao peao15 = new Peao(casa31, Cor.PRETA,tabuleiro);

        Casa casa32 = tabuleiro.getCasa(7, 6);
        Peao peao16 = new Peao(casa32, Cor.PRETA,tabuleiro);
    
    }
    
    /**
     * Comanda uma Pe�a na posicao (origemX, origemY) fazer um movimento 
     * para (destinoX, destinoY).
     * 
     * @param origemX linha da Casa de origem.
     * @param origemY coluna da Casa de origem.
     * @param destinoX linha da Casa de destino.
     * @param destinoY coluna da Casa de destino.
     */
    public void moverPeca(int origemX, int origemY, int destinoX, int destinoY) {
        Casa origem = tabuleiro.getCasa(origemX, origemY);
        Casa destino = tabuleiro.getCasa(destinoX, destinoY);
        Peca peca = origem.getPeca();
        peca.mover(destino);
    }
    
    /**
     * @return o Tabuleiro em jogo.
     */
    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
}
