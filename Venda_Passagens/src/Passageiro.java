import java.time.LocalDate;

public class Passageiro {
    private String nome;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;
    private boolean comorbidade;
    private int prioridade;
    private int quantidadeViagensFeitas;
    private LocalDate listaViagemPendentes[] = new LocalDate[31];
    private int contListaViagensPendente;


    public Passageiro(String nome, String email, String endereco, LocalDate dataNascimento, boolean comorbidade) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.comorbidade = comorbidade;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
    public void acrescentarPrioridade(int prioridade) {
        this.prioridade += prioridade;
    }

    public boolean dataLivre(LocalDate data){
        for (int i = 0; i < listaViagemPendentes.length; i++) {
            if (listaViagemPendentes[i].equals(data)) {
                return false;
            }
        }
        return true;
    }
    //todo melhorar para abordar data
    public boolean idoso(LocalDate dataAtual){
        LocalDate idade = dataAtual.minusYears(this.dataNascimento.getYear());
        return (idade.getYear() >= 60);
    }

    public boolean aniversariante(LocalDate dataAtual){

        return (dataAtual.getDayOfMonth() == this.dataNascimento.getDayOfMonth());
    }

    public boolean isComorbidade() {
        return comorbidade;
    }

    public void acrescentarViagensFeitas() {
        quantidadeViagensFeitas ++;
    }

    public int getQuantidadeViagensFeitas() {
        return quantidadeViagensFeitas;
    }

    public boolean limiteViagens(){
        if(this.contListaViagensPendente == 31) {
            System.out.println("O limite maximo de viagens para esse mês foi atingido");
            return false;
        }
        return true;
    }

    public void comprarViagem(LocalDate dataViagem){
        for (int i = 0; i <listaViagemPendentes.length ; i++) {
            if(listaViagemPendentes[i] == null){
                this.listaViagemPendentes[i] = dataViagem;
                this.contListaViagensPendente++;
                break;
            }
        }
    }

    public void realizarViagem(LocalDate data){
        for (int i = 0; i < listaViagemPendentes.length; i++) {
            if(listaViagemPendentes[i].equals(data)){
                this.listaViagemPendentes[i] = null;
                this.contListaViagensPendente--;
                this.quantidadeViagensFeitas++;
            }
        }
    }
}
