
import java.util.Random;

public class Jogo {

    // ATRIBUTOS
    int altura;
    int largura;
    Cobra cobra;
    Ponto comida;
    int pontuacao;

    // MÉTODOCONSTRUTOR
    Jogo(int altura, int largura) {
        this.altura = altura;
        this.largura = largura;
        this.cobra = new Cobra(altura / 2, largura / 2);
        this.pontuacao = 0;
        gerarComida();
    }

    // MÉTODOS
    void gerarComida() {
        Random random = new Random();
        int x = random.nextInt(altura);
        int y = random.nextInt(largura);
        comida = new Ponto(x, y);
    }

    void atualizarLogica() {
        cobra.mover();
        cobra.verificarColisao(altura, largura);

        if (!cobra.viva) {
            return; // Se morreu, não faz mais nada
        }

        // Verifica se a cabeça da cobra atingiu a comida
        Ponto cabeca = cobra.corpo.get(0);
        if (cabeca.x == comida.x && cabeca.y == comida.y) {
            cobra.crescer();
            pontuacao = pontuacao + 10;
            gerarComida();
        }
    }

    void desenharTabuleiro() {
        // Limpa a tela com linhas em branco
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }

        System.out.println("============================");
        System.out.println("       JOGO DA COBRINHA");
        System.out.println("       Pontos: " + pontuacao);
        System.out.println("============================");

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                
                boolean ehCorpoCobra = false;
                for (Ponto p : cobra.corpo) {
                    if (p.x == i && p.y == j) {
                        ehCorpoCobra = true;
                        break;
                    }
                }

                if (ehCorpoCobra) {
                    System.out.print("O ");
                } else if (comida.x == i && comida.y == j) {
                    System.out.print("X ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}