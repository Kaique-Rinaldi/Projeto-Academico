
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        Jogo jogo = new Jogo(10, 15);

        // Ciclo principal do jogo
        while (jogo.cobra.viva) {
            jogo.desenharTabuleiro();
            
            System.out.print("\nMovimento (W=Cima, S=Baixo, A=Esquerda, D=Direita, Q=Sair): ");
            String input = entrada.next().toUpperCase();

            // Sair do jogo
            if (input.equals("Q")) {
                System.out.println("Saiu do jogo a meio.");
                break;
            }

            // Validar movimento
            if (input.equals("W") || input.equals("S") || input.equals("A") || input.equals("D")) {
                jogo.cobra.direcao = input.charAt(0);
            }

            // Atualiza as posições após o input
            jogo.atualizarLogica();
        }

        System.out.println("\n============================");
        System.out.println("       FIM DE JOGO!");
        System.out.println("============================");
        System.out.println("Pontuacao final: " + jogo.pontuacao);

        entrada.close();
    }
}