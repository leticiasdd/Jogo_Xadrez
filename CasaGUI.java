
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Interface Grafica de uma Casa no tabuleiro do jogo.
 *
 * @author Alan Moraes &lt;alan@ci.ufpb.br&gt;
 * @author Leonardo Villeth &lt;lvilleth@cc.ci.ufpb.br&gt;
 */
public class CasaGUI extends JButton {

    // Constantes 
    public static final Color COR_CLARA = new Color(200, 200, 200);
    public static final Color COR_ESCURA = new Color(0, 128, 0);
    private static final Color COR_DESTAQUE = new Color(0, 1, 0, 0.4f);
    
    // Icones das pecas
    private static final Icon TORRE_BRANCA = new ImageIcon("imagens/torre_branca.png");
    private static final Icon TORRE_PRETA = new ImageIcon("imagens/torre_preta.png");
    private static final Icon BISPO_PRETO = new ImageIcon("imagens/bispo_preto.png");
    private static final Icon BISPO_BRANCO = new ImageIcon("imagens/bispo_branco.png");
    private static final Icon CAVALO_PRETO = new ImageIcon("imagens/cavalo_preto.png");
    private static final Icon CAVALO_BRANCO = new ImageIcon("imagens/cavalo_branco.png");
    private static final Icon PEAO_PRETO = new ImageIcon("imagens/peao_preto.png");
    private static final Icon PEAO_BRANCO = new ImageIcon("imagens/peao_branco.png");
    private static final Icon RAINHA_BRANCA = new ImageIcon("imagens/rainha_branca.png");
    private static final Icon RAINHA_PRETA = new ImageIcon("imagens/rainha_preta.png");
    private static final Icon REI_PRETO = new ImageIcon("imagens/rei_preto.png");
    private static final Icon REI_BRANCO = new ImageIcon("imagens/rei_branco.png");
    
    
    // Cores das pecas
    public static final int SEM_PECA = -1;
    public static final int PECA_BRANCA = 0;
    public static final int PECA_PRETA = 1;
    

    private int x;
    private int y;
    private Color cor;

    public CasaGUI(int x, int y, Color cor, TabuleiroGUI tabuleiro) {
        this.x = x;
        this.y = y;
        this.cor = cor;
        setIcon(null);

        // Layout e cor
        setBackground(cor);
        setOpaque(false);
        setBorder(BorderFactory.createLineBorder(cor, 1));
        setContentAreaFilled(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabuleiro.getJanela().reagir((CasaGUI) e.getSource());
            }
        });
    }

    public int getPosicaoX() {
        return x;
    }

    public int getPosicaoY() {
        return y;
    }

    public void desenharTorre(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(TORRE_BRANCA);
        }
        else {
            setIcon(TORRE_PRETA);
        }
    }
    
    public void desenharBispo(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(BISPO_BRANCO);
        }
        else {
            setIcon(BISPO_PRETO);
        }
    }
    
    public void desenharCavalo(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(CAVALO_BRANCO);
        }
        else {
            setIcon(CAVALO_PRETO);
        }
    }
  
    
    public void desenharPeao(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(PEAO_BRANCO);
        }
        else {
            setIcon(PEAO_PRETO);
        }
    }
    
    
    public void desenharRainha(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(RAINHA_BRANCA);
        }
        else {
            setIcon(RAINHA_PRETA);
        }
    }
    
        
    public void desenharRei(Cor cor) {
        if (cor == Cor.BRANCA) {
            setIcon(REI_BRANCO);
        }
        else {
            setIcon(REI_PRETO);
        }
    }
    

    public void apagarPeca() {
        setIcon(null);
    }

    public boolean possuiPeca() {
        return getIcon() != null;
    }
   
    
    public void destacar() {
        setBackground(COR_DESTAQUE);
    }

    public void atenuar() {
        setBackground(cor);
    }

    /**
     * Pinta o componente com a cor de fundo, aceita valores RGBA
     */
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    public void desenhar(Peca peca) {
        Cor cor = peca.getCor();
        Tipo tipo = peca.getTipo();
        
        switch (tipo) {
            case REI:
                desenharRei(cor);
                break;
            case RAINHA:
                desenharRainha(cor);
                break;
            case TORRE:
                desenharTorre(cor);
                break;
            case BISPO:
                desenharBispo(cor);
                break;
            case CAVALO:
                desenharCavalo(cor);
                break;
            case PEAO:
                desenharPeao(cor);
                break;
        }
        
        
        
                       
        
        
    }

}
