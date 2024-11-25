import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static  LocalDate dataPartida = LocalDate.of(2024,11,1);
    static GerenciadorPartidas partida = new GerenciadorPartidas();
    public static void gerenciadorPartida(){

        partida.criarDiasVoos(dataPartida);
        partida.criarAvioes();

        for (int i = 0; i < dataPartida.lengthOfMonth(); i++) {
            /*
            loop de cadastro e compra:
                //cadastra usuario
                //compra passagem obs.: em loop caso usuario queira mais de uma passagem
                    //cadastrar outro usuario?
           */

            //realiza o voo
            dataPartida.plusDays(1);
        }
    }

    public static  Passageiro  cadastro(){
        System.out.println("Vamos realizar o seu cadastro!");
        System.out.println();
        System.out.println("Insira o seu nome: ");
        String nome = entrada.nextLine();
        System.out.println("Insira o seu e-mail: ");
        String email = entrada.nextLine();
        System.out.println("Insira o seu endereço: ");
        String endereco = entrada.nextLine();

        //todo fazer verificação para o formato de data inserido
        System.out.println("Insira a sua data de nascimento:(AAAA-MM-DD) ");
        String stringData = entrada.nextLine();
        LocalDate data = LocalDate.parse(stringData);

        boolean comorbidade = false;
        int cont = 0;
        while (cont == 0){
            System.out.println("Você possui alguma comorbidade?(Sim ou Não) ");
            String stringComorbidade = entrada.nextLine();
            switch (stringComorbidade){
                case "Sim":
                    comorbidade = true;
                    cont = 1;
                    break;
                case "Não":
                    comorbidade = false;
                    cont = 1;
                    break;
                default:
                    System.out.println("A opçao escolhida não é valida!");
                    System.out.println("Tente novamente!");
                    cont = 0;
            }

        }
        return new Passageiro(nome,email,endereco,data,comorbidade);
    }

    public static boolean dataViagemValida(LocalDate data){

        if(data.isBefore(dataPartida) || data.isEqual(dataPartida)){
            return false;
        }
        return true;
    }
    public static void comprarPassagem(Passageiro passageiro){

        //todo criar funçao de validação do formato data
        while (true){
            System.out.println("Deseja comprar passagem para qual dia ?(AAAA-MM-DD) ");
            String stringDataViagem = entrada.nextLine();
            LocalDate dataViagem = LocalDate.parse(stringDataViagem);
            if(!partida.vagasAviao(dataViagem)){
                System.out.println("O avião está atingiu sua capacidade maxima, escolha outra data!");
            }else if(dataViagemValida(dataViagem)){
                break;
            }else {
                System.out.println("Data invalida! A data deve ser maior que a atual!!! ");
            }
        }
        //escolher lugar

        //acrescentar lista de viagem pendentes



        System.out.println("Qual");
        //passar lista de acentos disponiveis para o usuario de acordo com o dia especifico

        //adicionar passagem ao usuario

                //se ele ja possui passagem nessa data, se data é maior que atual, se a data esta nesse mes, se tem espaço no voo para esse dia

    }
    public static void main(String[] args) {
        Passageiro passageiro = cadastro();
        comprarPassagem(passageiro);
//        LocalDate data = LocalDate.of(1950,11,18);
//        Passageiro leandro = new Passageiro("leo","ksnaksdn","sad",data,false);
//        boolean bool =  leandro.idoso();
//        System.out.println(bool);
//        bool = leandro.aniversariante();
//        System.out.println(bool);

    }
}