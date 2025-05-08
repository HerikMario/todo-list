package todo_list;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Usuario> todosUsuarios = new ArrayList<Usuario>();
    private Usuario usuarioLogado = null;

    public void cadastrarUsuario(String cargo, String login, String senha) {
        Usuario novoUsuario = new Usuario(login,senha, cargo);
        todosUsuarios.add(novoUsuario);
    }

    public void logarUsuario(String login, String senha) {
        if (usuarioLogado == null) {
            for (Usuario usuario : todosUsuarios) {
                if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                    usuarioLogado = usuario;
                    System.out.println("\n" + usuarioLogado.getLogin()+" logou com sucesso!\n");
                    return;
                }
            }
            System.out.println("Usuário não encontrado.");
        } else {
            System.out.println("Já existe um usuário logado!");
        }
    }

    public void deslogarUsuario() {
        if (usuarioLogado != null) {
            System.out.println("\n"+usuarioLogado.getLogin()+" deslogou com sucesso\n");
            usuarioLogado = null;
        } else {
            System.out.println("Nenhum usuário logado!");
        }
    }

    public void criarTarefas(String titulo, String descricao, String dataDeEntraga, int prioridade) {
        if (usuarioLogado != null) {
            System.out.println("\nCriou tarefa nova!\n");
            usuarioLogado.criarTarefas(titulo, descricao, dataDeEntraga, prioridade);
        } else {
            System.out.println("Não há nenhum usuário logado!");
        }
    }

    public void marcarConcluida(String titulo) {
        if (usuarioLogado != null) {
            usuarioLogado.marcarConcluida(titulo);
        } else {
            System.out.println("Não há nenhum usuário logado!");
        }
    }

    public void vizualizarHistorico() {
        if (usuarioLogado != null) {
            usuarioLogado.vizualizarHistorico();
        } else {
            System.out.println("Não há nenhum usuário logado!");
        }
    }

    public void visualizarTodasTarefasParaFazer() {
        if (usuarioLogado == null) {
            System.out.println("Não há nenhum usuário logado!");
            return;
        }
    
        if (!usuarioLogado.getCargo().equalsIgnoreCase("administrador")) {
            System.out.println("Você não tem permissão para fazer isso.");
            return;
        }
    
        System.out.println("===============");
        System.out.println("Todas as tarefas");
        System.out.println("===============\n");
    
        for (Usuario usuario : todosUsuarios) {
            System.out.println("Tarefas de: " + usuario.getLogin());
            for (Tarefa tarefa : usuario.getTarefas()) {
                System.out.println("- " + tarefa.getTitulo() + " | Status: " + (tarefa.isConcluida() ? "Concluída" : "Pendente"));
            }
            System.out.println(); // linha em branco entre usuários
        }
    }   
    
    public void editarTarefas(String titulo, String responsavel, String atributoParaEdicao) {
        Scanner scan = new Scanner(System.in);
        if (usuarioLogado == null) {
            System.out.println("Não há nenhum usuário logado!");
            return;
        }
    
        if (!usuarioLogado.getCargo().equalsIgnoreCase("administrador")) {
            System.out.println("Você não tem permissão para fazer isso.");
            return;
        }
        for (Usuario usuario : todosUsuarios) {
            for (Tarefa tarefa : usuario.getTarefas()) {
                if (tarefa.getTitulo().equals(titulo) && usuario.getLogin().equals(responsavel)) {
                    switch (atributoParaEdicao) {
                        case "titulo" -> {
                            System.out.print("Digite o novo título: ");
                            String novoTitulo = scan.nextLine();
                            tarefa.setTitulo(novoTitulo);
                        }
                        case "descricao" -> {
                            System.out.print("Digite a nova descrição: ");
                            String novaDesc = scan.nextLine();
                            tarefa.setDescricao(novaDesc);
                        }
                        case "dataDeEntrega" -> {
                            System.out.print("Digite a nova data de entrega: ");
                            String novaData = scan.nextLine();
                            tarefa.setDataDeEntrega(novaData);
                        }
                        case "prioridade" -> {
                            System.out.print("Digite a nova prioridade (número): ");
                            int novaPrioridade = Integer.parseInt(scan.nextLine());
                            tarefa.setPrioridade(novaPrioridade);
                            break;
                        }
                        default -> {
                            System.out.println("Opção inválida.");
                        }     
                    }
                } else {
                    System.out.println("nenhuma tarefa com essas especificações encontrada");
                }
            }
        }


    }

    public ArrayList<Usuario> getTodosUsuarios() {
        return todosUsuarios;
    }

    public boolean isLogado() {
        return usuarioLogado != null;
    }

    
}
