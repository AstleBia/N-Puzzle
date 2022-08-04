import java.util.Random;
public class Tabuleiro {
    //tamanho NxN - números vao ate NxN-1
    //comecar com 16 e dps mudar para escolha do usuario
    private int tamanho = 4;
    private int[][] tabuleiro = new int[tamanho][tamanho];
    private int[][] solucao = new int[tamanho][tamanho];
    private int[] numeros = new int[tamanho*tamanho];
    int linha = 0, coluna = 0;
    public void preencherNumeros(){
        for(int x = 1;x<numeros.length;x++){
            int y = x-1;
            this.numeros[y] = x;
        }
    }
    public void preencherSolucao(){
        preencherNumeros();
        int i = 0;
        for(int x = 0; x< solucao.length;x++){
            for(int y = 0;y< solucao.length;y++){
                solucao[x][y] = numeros[i];
                i++;
            }
        }
    }
    public int[][] getSolucao(){
        return this.solucao;
    }
    public int[][] getTabuleiro(){
        return this.tabuleiro;
    }

    //metodo para embaralhar o tabuleiro
    public void embaralha(){
        preencherNumeros();
        Random altr = new Random();
        //emabaralhar array
        for (int i =0;i<numeros.length;i++){
            int valorArray = altr.nextInt(numeros.length);
            int temp = numeros[valorArray];
            numeros[valorArray] = numeros[i];
            numeros[i] = temp;
        }
        //embaralhar o tabuleiro
        int i = 0;
        for(int x = 0;x<tamanho;x++){
            for(int y =0;y<tamanho;y++){
                tabuleiro[x][y] = numeros[i];
                i++;
            }
        }
    }

    //gerar um tabuleiro para o jogo
    public void gerarTabuleiro(){
        embaralha();
        for(int x = 0;x<tamanho;x++){
            for(int y =0; y<tamanho;y++){
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //printar tabuleiro
    public void printaTabuleiro(){
        for(int x = 0;x<tamanho;x++){
            for(int y =0; y<tamanho;y++){
                System.out.print(tabuleiro[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //checa se a peca pode ser movida
    public boolean checarMovimento(){
        //quinas
        if(linha == 0 && coluna == 0){
            if((tabuleiro[0][1] == 0) || (tabuleiro[1][0]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        else if(linha == 0 && coluna == (tamanho-1) ){
            if((tabuleiro[0][coluna -1]==0) || (tabuleiro[1][coluna]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        else if(linha == (tamanho-1) && coluna == 0){
            if((tabuleiro[linha-1][coluna]==0) || (tabuleiro[linha][coluna+1]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        else if(linha == (tamanho-1) && coluna == (tamanho - 1)){
            if((tabuleiro[linha][coluna-1]==0)||(tabuleiro[linha-1][coluna]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        //bordas
        else if(linha>0 && linha<tamanho-1 && coluna==0){
            //primeira coluna
            if((tabuleiro[linha-1][coluna]==0)||(tabuleiro[linha+1][coluna]==0)||(tabuleiro[linha][coluna+1]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        //ultima coluna
        else if(linha>0 && linha<tamanho-1 && coluna == tamanho-1){
            if((tabuleiro[linha-1][coluna]==0)||(tabuleiro[linha+1][coluna]==0)||(tabuleiro[linha][coluna-1]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        //primeira linha
        else if(linha == 0 && coluna>0 && coluna<tamanho-1){
            if((tabuleiro[linha][coluna-1]==0)||(tabuleiro[linha][coluna+1]==0)||(tabuleiro[linha+1][coluna]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        //ultima linha
        else if(linha == tamanho-1 && coluna>0 && coluna<tamanho-1){
            if((tabuleiro[linha][coluna-1]==0)||(tabuleiro[linha][coluna+1]==0)||(tabuleiro[linha+1][coluna]==0)){
                return true;
            }
            else{
                return false;
            }
        }
        //meio
        else{
            if((tabuleiro[linha-1][coluna]==0)||(tabuleiro[linha+1][coluna]==0)){
                return true;
            }
            else if((tabuleiro[linha][coluna-1]==0)||(tabuleiro[linha][coluna+1]==0)){
                return true;
            }
            else{
                return false;
            }
        }
    }
    //valor para movimento
    public void setMovimento(int linha, int coluna){
        this.linha = linha;
        this.coluna = coluna;
    }
    //fazer os movimentos
    public void movimentoPeca(int linha,int coluna){
        this.linha = linha;
        this.coluna = coluna;
        int linhaZero = 0, colunaZero = 0;
        //achar a posicao do zero
        for(int x = 0;x<tamanho;x++){
            for(int y = 0;y<tamanho;y++){
                if(tabuleiro[x][y] == 0){
                    linhaZero = x;
                    colunaZero = y;
                }
            }
        }
        if(checarMovimento()){
            tabuleiro[linhaZero][colunaZero] = tabuleiro[this.linha][this.coluna];
            tabuleiro[this.linha][this.coluna] = 0;
        }
    }
}
