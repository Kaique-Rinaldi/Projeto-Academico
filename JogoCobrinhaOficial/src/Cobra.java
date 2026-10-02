
import java.util.ArrayList;

public class Cobra {

    // ATRIBUTOS
    ArrayList<Ponto> corpo;
    char direcao;
    boolean viva;

    // MÉTODO CONSTRUTOR
    Cobra(int linhaInicial, int colunaInicial) {
        corpo = new ArrayList<>();
        corpo.add(new Ponto(linhaInicial, colunaInicial)); // Adiciona a cabeça
        direcao = 'D'; // Começa a ir para a Direita
        viva = true;
    }

    // MÉTODOS
    void mover() {
        Ponto cabeca = corpo.get(0);
        int novaLinha = cabeca.x;
        int novaColuna = cabeca.y;

        if (direcao == 'W') novaLinha--;
        if (direcao == 'S') novaLinha++;
        if (direcao == 'A') novaColuna--;
        if (direcao == 'D') novaColuna++;

        // Adiciona a nova posição da cabeça no início da lista
        corpo.add(0, new Ponto(novaLinha, novaColuna));
        
        // Remove a cauda para dar a ilusão de movimento
        corpo.remove(corpo.size() - 1);
    }

    void crescer() {
        // Pega no último pedaço da cauda e duplica-o
        Ponto cauda = corpo.get(corpo.size() - 1);
        corpo.add(new Ponto(cauda.x, cauda.y));
    }

    void verificarColisao(int altura, int largura) {
        Ponto cabeca = corpo.get(0);

        // Bateu nas paredes do tabuleiro
        if (cabeca.x < 0 || cabeca.x >= altura || cabeca.y < 0 || cabeca.y >= largura) {
            viva = false;
        }

        // Bateu no próprio corpo
        for (int i = 1; i < corpo.size(); i++) {
            Ponto parteDoCorpo = corpo.get(i);
            if (cabeca.x == parteDoCorpo.x && cabeca.y == parteDoCorpo.y) {
                viva = false;
            }
        }
    }
}