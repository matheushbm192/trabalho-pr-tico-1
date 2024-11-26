import java.time.LocalDate;
import java.util.Arrays;

public class Aviao {
    Passageiro  lista[] = new Passageiro[33];
    int topoLista = 0;
    char[][] lugares = new char[11][3];
    LocalDate dataVoo;

    public Aviao(LocalDate dataVoo) {
        this.dataVoo = dataVoo;
    }

    public void atribuiPesosPassageiros(LocalDate dataAtual){

        for (int i = 0; i < topoLista ; i++) {
            Passageiro passageiro = lista[i];
            if (passageiro.isComorbidade()){
                passageiro.acrescentarPrioridade(40000);
            }
            if (passageiro.idoso(dataAtual)){
                passageiro.acrescentarPrioridade(3000);
            }
            if (passageiro.aniversariante(dataAtual)){
                passageiro.acrescentarPrioridade(200);
            }
            if (true){
                passageiro.acrescentarPrioridade(i);
            }
        }

    }
    public void ordenaPassageiros(){
        Passageiro[] v = lista;
        int n = topoLista;
        int i = 0;
        int j = 1;
        Passageiro aux = null;
        while(j < n){
           aux = v[j];
           i = j - 1;
           while ((i >= 0) && (v[i].getPrioridade() < aux.getPrioridade())){
               v[i + 1] = v[i];
               i = i - 1;
           }
           v[i + 1] = aux;
           j = j + 1;
        }
        System.out.println("Fila de embarque/desembarque de passageiros: ");
        for (int k = 0; k < topoLista; k++) {
            System.out.println(v[k].getNome());
        }
    }

    public boolean lugarVago(int fileira, int coluna){
        char poltrona = lugares[fileira][coluna];
        if(poltrona != '0'){
            return true;
        }else{
            return false;
        }
    }

    public int getTopoLista() {
        return topoLista;
    }

    public void addPassageiro(Passageiro passageiro){

        lista[topoLista] = passageiro;

        if(topoLista == 33){
            System.out.println("Não há mais vagas no avião!");

        }else {
            topoLista++;
        }
    }

    public void ocuparLugar(int fileira,int coluna){
        lugares[fileira - 1][coluna] = '0';
    }

    public void popularLugares(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {

                switch (j){
                    case 0:
                        lugares[i][j] = 'A';
                    break;
                    case 1:
                        lugares[i][j] = 'C';
                    break;
                    case 2:
                        lugares[i][j] = 'D';
                    break;
                }

            }
        }
    }

    public void exibeAcentos() {

        char[][] lugares = this.lugares;

        int fileiras = 1;
        for (int i = 0; i < lugares.length; i++) {
            if(i == 9 || i == 10){
                System.out.print(fileiras + " | ");
            }else{
                System.out.print(fileiras + "  | ");
            }

            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    System.out.print(lugares[i][j] + "   ");
                } else {
                    System.out.print(lugares[i][j] + " ");
                }
            }
            System.out.println();
            fileiras++;
        }
    }

}
