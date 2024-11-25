import java.lang.reflect.AccessFlag;
import java.time.LocalDate;
import java.util.Arrays;

public class GerenciadorPartidas {
    Aviao listaAvioes[] = new Aviao[31];
    LocalDate diasVoos[] = new LocalDate[31];

    public void criarDiasVoos(LocalDate dataAtual){

        System.out.println(dataAtual);
        int count = 1;
        for (int i = 0; i < dataAtual.lengthOfMonth(); i++) {
            diasVoos[i] = dataAtual.withDayOfMonth(count);
            count++;
        }
        System.out.println(Arrays.toString(diasVoos));
    }
    
    // vai criar um aviao
    public void criarAvioes(){
        for (int i = 0; i < diasVoos.length ; i++) {
            if(diasVoos[i] != null){
                Aviao novoAviao = new Aviao(diasVoos[i]);
                novoAviao.popularLugares();
                listaAvioes[i] = novoAviao;
            }
        }
        System.out.println(Arrays.toString(listaAvioes));
    }
    public Aviao getAviao(LocalDate data){
        int index = data.getDayOfMonth() - 1;
        return listaAvioes[index];
    }

    public boolean vagasAviao(LocalDate data){
        Aviao aviao = getAviao(data);
        return aviao.topoLista != 33;
    }

    public void  adicionarPassagero(LocalDate data, int[][] poltrona, Passageiro passageiro){

        Aviao aviao = getAviao(data);
        aviao.addPassageiro(passageiro, poltrona);

    }
//    public void realizarPartida(){
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
    //controlando qual dia
    //passageiro e utiliza a data que ele tem amazenada
    //verificar dia atual
    //contabilizar dia da partida ??
    //listar passagereiros confirmados e contabilizar a partida de qualquer forma
}
