
import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

public class Main {

    public static void main(String arg[]) {

        List<Dev> listaDevs = new LinkedList<Dev>();
        List<Jogo> listaJogos = new LinkedList<Jogo>();

        int idDevs = iniciarListaDevs(listaDevs);
        int idJogos = iniciarListaJogos(listaJogos, listaDevs);

        Dev d;
        Jogo f;
        int idDev = -1;
        int idJogo = -1;
        int opcao2 = -1;

        int opcao = 1;
        Scanner input = new Scanner(System.in);

        while (opcao != 0) {
            System.out.println("Digite no terminal:"
                    + "\n0 para Sair"
                    + "\n1 para Cadastrar uma Desenvolvedora"
                    + "\n2 para Listar todas as Desenvolvedoras cadastradas"
                    + "\n3 para Cadastrar um no Jogo"
                    + "\n4 Para lista todos os jogos Cadastrados"
                    + "\n5 Para editar as informacoes de uma Desenvolvedora"
                    + "\n6 para editar um jogo"
                    + "\n7 para remover uma Desenvolvedora"
                    + "\n8 para Remover um jogo");

            opcao = Integer.valueOf(input.nextLine());
            switch (opcao) {
                case 1:

                    d = new Dev();
                    d.cod = idDevs;
                    idDevs++;
                    System.out.print("Digite o nome da Desenvolvedora: ");
                    d.nome = input.nextLine();
                    System.out.print("Digite o ano de fundação da Desenvolvedora: ");
                    d.anoFund = Integer.valueOf(input.nextLine());
                    System.out.print("Digite o pais de origem Desenvolvedora: ");
                    d.pais = input.nextLine();
                    listaDevs.add(d);
                    System.out.println("Operação bem Sucedida!");
                    break;

                case 2:
                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        System.out.println("Id: " + d.cod
                                + "\tnome: " + d.nome);
                    }
                    System.out.println("\n");
                    break;
                case 3:

                    f = new Jogo();
                    f.cod = idJogos;
                    idJogos++;
                    System.out.print("digite o nome do Jogo:  ");
                    f.nome = input.nextLine();
                    System.out.print("Digite o ano de lançamento do Jogo:  ");
                    f.ano = Integer.valueOf(input.nextLine());
                    System.out.print("Digite o genero do Jogo:  ");
                    f.genero = input.nextLine();
                    System.out.print("Digite a plataforma do Jogo:  ");
                    f.plataforma = input.nextLine();

                    for (int i = 0; i < listaDevs.size(); i++) {

                        d = listaDevs.get(i);
                        System.out.println(
                                "id:  " + d.cod
                                        + "\tnome: " + d.nome);

                    }
                    System.out.print("Digite o codigo da Desenvolvedora:  ");
                    idDev = Integer.valueOf(input.nextLine());

                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        if (idDev == d.cod) {
                            f.dev = d;
                            break;

                        }
                    }
                    if (f.dev == null) {
                        System.out.println("Desenvolvedora não encontrada!\n\n");
                        idJogos--;
                    } else {
                        listaJogos.add(f);
                        System.out.println("Operação bem Sucedida!\n\n");
                    }
                    break;
                case 4:
                    for (int i = 0; i < listaJogos.size(); i++) {
                        f = listaJogos.get(i);
                        System.out.println(
                                "id: " + f.cod
                                        + "\tnome: " + f.nome
                                        + "\tdiretor: " + f.dev.nome);
                    }
                    System.out.println("\n");
                    break;

                case 5:
                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        System.out.println(
                                "id:  " + d.cod
                                        + "\tnome:  " + d.nome);
                    }
                    System.out.println("Digite o id da Desenvolvedora que deseja edita: ");
                    idDev = Integer.valueOf(input.nextLine());

                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        if (idDev == d.cod) {
                            System.out.println("Qual informação você quer editar:  "
                                    + "\n1 - Nome"
                                    + "\n2 - Ano de Fundacao"
                                    + "\n3 - Pais ");
                            opcao2 = Integer.valueOf(input.nextLine());
                            switch (opcao2) {
                                case 1:
                                    System.out.print("Digite o Nome da Desenvolvedora:  ");
                                    d.nome = input.nextLine();
                                    System.out.println("Operação bem Sucedida!\n\n");
                                    break;
                                case 2:
                                    System.out.print("Digite o ano de fundação da Desenvolvedora:  ");
                                    d.anoFund = Integer.valueOf(input.nextLine());
                                    System.out.println("Operação bem Sucedida!\n\n");
                                    break;
                                case 3:
                                    System.out.print("Digite o Pais da Desenvolvedora:  ");
                                    d.nome = input.nextLine();
                                    System.out.println("Operação bem Sucedida!\n\n");
                                    break;
                                default:
                                    System.out.println("Opção invalida");
                            }

                        }
                    }
                    break;
                case 6:
                    for (int i = 0; i < listaJogos.size(); i++) {
                        f = listaJogos.get(i);
                        System.out.println(
                                "id: " + f.cod
                                        + "\tnome: " + f.nome
                                        + "\tdev: " + f.dev.nome);

                    }
                    System.out.println("Digite o codigo do jogo que deseja edita: ");
                    idJogo = Integer.valueOf(input.nextLine());

                    for (int i = 0; i < listaJogos.size(); i++) {
                        f = listaJogos.get(i);
                        if (f.cod == idJogo) {
                            System.out.println("Qual informação você quer editar:  "
                                    + "\n1 - nome"
                                    + "\n2 - dev");
                            opcao2 = Integer.valueOf(input.nextLine());
                            switch (opcao2) {
                                case 1:
                                    System.out.print("Digite o nome do jogo:  ");
                                    f.nome = input.nextLine();
                                    System.out.println("Operação bem Sucedida!\n\n");
                                    break;
                                case 2:
                                    for (int j = 0; j < listaDevs.size(); j++) {
                                        d = listaDevs.get(j);
                                        System.out.println(
                                                "id: " + d.cod
                                                        + "\tnome: " + d.nome);
                                    }
                                    System.out.println("Digite o codigo da desenvolvedora:  ");
                                    idDev = Integer.valueOf(input.nextLine());
                                    for (int j = 0; j < listaDevs.size(); j++) {
                                        d = listaDevs.get(j);
                                        if (d.cod == idDev) {
                                            f.dev = d;
                                            System.out.println("Operação bem Sucedida!\n\n");
                                            break;
                                        }
                                        if (j == listaDevs.size() - 1) {
                                            System.out.println("Desenvolvedora não encontrada!\n\n");
                                            break;
                                        }

                                    }
                                    break;
                                default:
                                    System.out.println("Opção invalida!\n\n");
                            }
                            if (i == listaJogos.size() - 1) {
                                System.out.println("Jogo não encontrado!");
                            }

                        }
                    }
                    break;
                case 7:
                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        System.out.println(
                                "id: " + d.cod
                                        + "\tnome:  " + d.nome);
                    }
                    System.out.println("Digite o codigo do Diretor que deseja remover:  ");
                    idDev = Integer.valueOf(input.nextLine());
                    for (int i = 0; i < listaDevs.size(); i++) {
                        d = listaDevs.get(i);
                        if (d.cod == idDev) {
                            listaDevs.remove(i);
                            System.out.println("Operação bem Sucedida!\n\n");
                            break;
                        }
                        if (i == listaDevs.size() - 1) {
                            System.out.println("Desenvolvedora não foi encontrada\n\n");
                        }
                    }
                    break;
                case 8:
                    for (int i = 0; i < listaDevs.size(); i++) {
                        f = listaJogos.get(i);
                        System.out.println(
                                "id: " + f.cod
                                        + "\tnome: " + f.nome
                                        + "\ndev: " + f.dev.nome);
                    }
                    System.out.println("Digite o codigo do jogo que deseja remover: ");
                    idJogo = Integer.valueOf(input.nextLine());

                    for (int i = 0; i < listaJogos.size(); i++) {
                        f = listaJogos.get(i);
                        if (f.cod == idDev) {
                            listaJogos.remove(i);
                            System.out.println("Operação bem Sucedida!\n\n");
                            break;
                        }
                        if (i == listaJogos.size() - 1) {
                            System.out.println("Jogo não encontrado!\n\n");
                        }
                    }
                    break;
                default:
                    System.out.println("Opção invalida!\n\n");
                    break;
            }

            input.close();
        }

    }

    private static int iniciarListaJogos(List<Jogo> listaJogos, List<Dev> listaDevs) {
        return 0;
    }

    private static int iniciarListaDevs(List<Dev> listaDevs) {
        return 0;
    }
}
