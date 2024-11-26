import java.time.LocalDate;

public class GerenciadorPartidas {
    Aviao listaAvioes[] = new Aviao[31];
    LocalDate diasVoos[] = new LocalDate[31];

    public void criarDiasVoos(LocalDate dataAtual){

        int count = 1;
        for (int i = 0; i < dataAtual.lengthOfMonth(); i++) {
            diasVoos[i] = dataAtual.withDayOfMonth(count);
            count++;
        }

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

    }
    public Aviao getAviao(LocalDate data){
        int index = data.getDayOfMonth() - 1;
        return listaAvioes[index];
    }

    public boolean vagasAviao(LocalDate data){
        Aviao aviao = getAviao(data);
        return aviao.topoLista != 33;
    }

//
    //controlando qual dia
    //passageiro e utiliza a data que ele tem amazenada
    //verificar dia atual
    //contabilizar dia da partida ??
    //listar passagereiros confirmados e contabilizar a partida de qualquer forma
}
