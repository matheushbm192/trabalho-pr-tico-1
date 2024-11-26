import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    static LocalDate dataPartida = LocalDate.of(2024, 11, 1);
    static GerenciadorPartidas partida = new GerenciadorPartidas();
    static int countPartidas= 0;

    public static void menu(){
        System.out.println("Dia atual: " + dataPartida);
        System.out.println("Bem vindo ao guichê. Informe qual ação deseja fazer:");
        System.out.println("1- Comprar passagem!");
        System.out.println("2- Realizar voo!");
        System.out.println("3- Sair!");
        int escolha = entrada.nextInt();
        switch (escolha){
            case 1:
                cadastro();
            break;
            case 2:
                passarDia();
                break;
            case 3:
                sair();
            break;
            default:
                System.out.println("Opção inválida. Tente novamente!");
                menu();
        }
    }

    public static void sair(){
        System.exit(0);
    }

    public static void passarDia() {
        Aviao aviao = partida.getAviao(dataPartida);
        LocalDate dataLimite = LocalDate.of(2024,12,1);
        if (aviao.getTopoLista() != 0){
            aviao.atribuiPesosPassageiros(dataPartida);
            aviao.ordenaPassageiros();
            System.out.println();
            System.out.println("Viagem realizada com sucesso!!!");
        }else{
            System.out.println("Não háviam passageiros suficientes para a viagem ser realizada!");
        }

        countPartidas++;

        dataPartida = dataPartida.plusDays(1);
        if(dataPartida.isEqual(dataLimite)){
            System.out.println("Todas as viagens do mês foram completadas");
            System.exit(0);
        }
        System.out.println(dataPartida);
        menu();
    }

    public static void cadastro() {
        System.out.println("Vamos realizar o seu cadastro!");
        System.out.println();
        System.out.println("Insira o seu nome:");
        String nome = entrada.nextLine();

        entrada.nextLine();
        System.out.println("Insira o seu e-mail:");
        String email = entrada.nextLine();
        System.out.println("Insira o seu endereço:");
        String endereco = entrada.nextLine();

        // todo fazer verificação para o formato de data inserido
        //verificar se o passageiro informou uam data válida(menor que a atual)
        System.out.println("Insira a sua data de nascimento:(AAAA-MM-DD)");
        String stringData = entrada.nextLine();
        LocalDate data = LocalDate.parse(stringData);

        boolean comorbidade = false;
        int cont = 0;
        while (cont == 0) {
            System.out.println("Você possui alguma comorbidade?(Sim ou Não)");
            String stringComorbidade = entrada.nextLine();

            switch (stringComorbidade) {
                case "Sim":
                    comorbidade = true;
                    cont = 1;
                    break;
                case "Não":
                    comorbidade = false;
                    cont = 1;
                    break;
                default:
                    System.out.println("A opção escolhida não é válida. Tente novamente.");
                    cont = 0;
            }
        }
        Passageiro novoPassageiro = new Passageiro(nome, email, endereco, data, comorbidade);
        comprarPassagem(novoPassageiro);
    }

    public static boolean dataViagemValida(LocalDate data) {

        if (data.isBefore(dataPartida) || data.isEqual(dataPartida)) {
            return false;
        }
        return true;
    }

    public static void valores(Passageiro passagero){
        double desconto = 0;
        if(passagero.getQuantidadeViagensFeitas() <= 10){
            desconto += passagero.getQuantidadeViagensFeitas() * 0.05;
        }else if(passagero.getQuantidadeViagensFeitas() > 10){
            desconto += 0.5;
        }
        if(passagero.isComorbidade()){
            desconto += 0.15;
        }
        if(passagero.idoso(dataPartida)){
            desconto += 0.05;
        }
        if(passagero.aniversariante(dataPartida)){
            desconto += 0.05;
        }

        System.out.println("Valores das poltronas sem desconto:");

        System.out.println("Janlea lado direirto: R$720.00");

        System.out.println("Janlea lado esquerdo: R$850.00");

        System.out.println("Corredor: R$550.00");

        System.out.println("----------------------------------");

        System.out.println("Valores das poltronas com desconto:");

        System.out.println("Janlea lado direito: R$" + (720.00-(720.00 * desconto )) );

        System.out.println("Janlea lado esquerdo: R$" + (850.00-(850.00 * desconto)) );

        System.out.println("Corredor: R$" + (550 - (550.00 * desconto)) );
    }

    public static void comprarPassagem(Passageiro passageiro) {
        LocalDate dataViagem;
        Aviao aviao;
        // todo criar funçao de validação do formato data
        while (true) {
            System.out.println("Deseja comprar passagem para qual dia ?(AAAA-MM-DD) ");

            String stringDataViagem = entrada.nextLine();
            dataViagem = LocalDate.parse(stringDataViagem);

            if (!partida.vagasAviao(dataViagem)) {
                System.out.println("O avião atingiu sua capacidade máxima. Escolha outra data.");
            }else if(!passageiro.dataLivre(dataViagem)){

                if (dataViagemValida(dataViagem)) {
                    aviao = partida.getAviao(dataViagem);
                    break;
                } else {
                    System.out.println("Data inválida! A data deve ser maior que a atual.");
                }
            } else{
                System.out.println("O passageiro ja possui uma viagem agendada para esse dia, escolha outro!");
            }
        }

        System.out.println("Informe o acento que você deseja (Os acentos númerados como 0 já estão ocupados!):");
        aviao.exibeAcentos();
        valores(passageiro);
        int fileira;
        int coluna = 3;
        String poltrona;
        while(true){
            // escolher lugar
            System.out.println("Informe o número da fila que deseja!");
            fileira = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Insira a letra da poltrona que deseja!");
            poltrona = entrada.nextLine();

            switch (poltrona){
                case "A":
                    coluna = 0;
                    break;
                case "C":
                    coluna = 1;
                    break;
                case "D":
                    coluna = 2;
                    break;
                default:
                    System.out.println("A poltrona esolhida deve ser a A, C ou D!");
            }

            if(fileira > 0 && fileira < 12 && coluna < 3 && coluna > -1){
                if (aviao.lugarVago(fileira,coluna)){
                    break;
                }else{
                    System.out.println("O lugar escolhida já está ocupado.");
                }

            }
        }
        //atribuie o passageiro ao aviao
        aviao.addPassageiro(passageiro);
        //ocupar o lugar
        aviao.ocuparLugar(fileira, coluna);

        aviao.exibeAcentos();
        // acrescentar lista de viagem pendentes
        passageiro.comprarViagem(dataViagem);

        System.out.println("Deseja comprar mais passagens: 1- Sim, 2- Não");
        int escolha = entrada.nextInt();
        switch (escolha){
            case 1:
                if(passageiro.limiteViagens()){
                    entrada.nextLine();
                    comprarPassagem(passageiro);
                }else{
                    System.out.println("O limite maximo de passagens foi atingido!");
                    menu();
                }
            break;
            case 2:
                menu();
            break;
        }
    }

    public static void main(String[] args) {
        partida.criarDiasVoos(dataPartida);
        partida.criarAvioes();
        menu();
    }
}