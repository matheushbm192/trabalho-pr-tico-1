import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);

    public static void comprarPassagem(){

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
        Passageiro novoPassageiro = new Passageiro(nome,email,endereco,data,comorbidade);

        System.out.println("Deseja comprar passagem para qual dia ?(AAAA-MM-DD) ");
        String stringDataViagem = entrada.nextLine();
        LocalDate dataViagem = LocalDate.parse(stringDataViagem);
                //se ele ja possui passagem nessa data, se data é maior que atual, se a data esta nesse mes, se tem espaço no voo para esse dia

    }
    public static void main(String[] args) {
            comprarPassagem();
//        LocalDate data = LocalDate.of(1950,11,18);
//        Passageiro leandro = new Passageiro("leo","ksnaksdn","sad",data,false);
//        boolean bool =  leandro.idoso();
//        System.out.println(bool);
//        bool = leandro.aniversariante();
//        System.out.println(bool);

    }
}