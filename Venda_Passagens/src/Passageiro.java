import java.time.LocalDate;

public class Passageiro {
    private String nome;
    private String email;
    private String endereco;
    private LocalDate dataNascimento;
    private boolean comorbidade;

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

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    //todo melhorar para abordar data
    public boolean idoso(){
        LocalDate dataAtual = LocalDate.now();

        LocalDate idade = dataAtual.minusYears(this.dataNascimento.getYear());

        return (idade.getYear() >= 60);
    }

    public boolean aniversariante(){
        LocalDate dataAtual = LocalDate.now();
        return (dataAtual.getDayOfMonth() == this.dataNascimento.getDayOfMonth());

    }

    public boolean isComorbidade() {
        return comorbidade;
    }

    public void acrescentarViagensFeitas() {
        quantidadeViagensFeitas ++;
    }

    public void comprarViagem(LocalDate dataViagem){
        if(this.contListaViagensPendente == 31){
            System.out.println("O limite maximo de viagens para esse mês foi atingido");
        }else{
            this.listaViagemPendentes[this.contListaViagensPendente + 1] = dataViagem;
            this.contListaViagensPendente++;
        }

    }
}
