import java.util.Scanner;
import java.util.Arrays;
public class Jogo extends Tabuleiro {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        int linha = 0, coluna = 0;
        tab.preencherSolucao();
        tab.gerarTabuleiro();
        while(!Arrays.equals(tab.getSolucao(),tab.getTabuleiro())){
            System.out.println("Digite a posicao da peca que voce deseja mover: linhaXcoluna");
            linha = input.nextInt();
            coluna = input.nextInt();
            tab.movimentoPeca(linha,coluna);
            tab.printaTabuleiro();
        }

    }
}
