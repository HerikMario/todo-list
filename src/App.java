import java.util.Scanner;
import todo_list.Sistema;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Sistema sistema = new Sistema();
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n======= MENU PRINCIPAL =======");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Logar");
            System.out.println("3. Deslogar");
            System.out.println("4. Criar tarefa");
            System.out.println("5. Marcar tarefa como concluída");
            System.out.println("6. Visualizar histórico de tarefas");
            System.out.println("7. Visualizar todas as tarefas (ADMIN)");
            System.out.println("8. Editar tarefa (ADMIN)");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            String opcao = scan.nextLine();

            switch (opcao) {
                case "1" -> {
                    System.out.print("Cargo (administrador/usuario): ");
                    String cargo = scan.nextLine();
                    System.out.print("Login: ");
                    String login = scan.nextLine();
                    System.out.print("Senha: ");
                    String senha = scan.nextLine();
                    sistema.cadastrarUsuario(cargo, login, senha);
                }
                case "2" -> {
                    if (sistema.isLogado()) {
                        System.out.print("\nJá existe um usuario logado!\n");
                    } else {
                        System.out.print("Login: ");
                        String login = scan.nextLine();
                        System.out.print("Senha: ");
                        String senha = scan.nextLine();
                        sistema.logarUsuario(login, senha);
                    }
                    
                }
                case "3" -> sistema.deslogarUsuario();

                case "4" -> {
                    if (sistema.isLogado()){
                        System.out.print("Título: ");
                        String titulo = scan.nextLine();
                        System.out.print("Descrição: ");
                        String descricao = scan.nextLine();
                        System.out.print("Data de entrega: ");
                        String data = scan.nextLine();
                        System.out.print("Prioridade (número): ");
                        int prioridade = Integer.parseInt(scan.nextLine());
                        sistema.criarTarefas(titulo, descricao, data, prioridade);
                    } else {
                        System.out.print("Precisa estar logado");
                    }
                }

                case "5" -> {
                    if (sistema.isLogado()){
                        System.out.print("Digite o título da tarefa a marcar como concluída: ");
                        String titulo = scan.nextLine();
                        sistema.marcarConcluida(titulo);
                    } else {
                        System.out.print("Precisa estar logado");
                    }
                }

                case "6" -> sistema.vizualizarHistorico();

                case "7" -> sistema.visualizarTodasTarefasParaFazer();

                case "8" -> {
                    if (sistema.isLogado()){
                        System.out.print("Título da tarefa: ");
                        String titulo = scan.nextLine();
                        System.out.print("Responsável (login): ");
                        String responsavel = scan.nextLine();
                        System.out.println("Atributo para editar (titulo, descricao, dataDeEntrega, prioridade): ");
                        String atributo = scan.nextLine();
                        sistema.editarTarefas(titulo, responsavel, atributo);
                    } else {
                        System.out.print("Precisa estar logado");
                    }
                }

                case "9" -> {
                    rodando = false;
                    System.out.println("Saindo...");
                }

                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scan.close();
    }
}
