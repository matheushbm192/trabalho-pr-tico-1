import java.time.LocalDate;

public class Aviao {
    Passageiro  lista[] = new Passageiro[33]; //
    int topoLista = 0;
    char[][] lugares = new char[11][3];
    LocalDate dataVoo;

    public Aviao(LocalDate dataVoo) {
        this.dataVoo = dataVoo;
    }

    public void addPassageiro(Passageiro passageiro, int[][] poltrona){

        lista[topoLista] = passageiro;

        if(topoLista == 33){
            System.out.println("Não há mais vagas no avião!");

        }else {
            topoLista++;
        }
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



}
