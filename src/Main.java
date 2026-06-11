import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de alunos: ");
        int quantidadeAlunos = scanner.nextInt();

        System.out.print("Digite a quantidade de provas feitas no ano: ");
        int quantidadeProvas = scanner.nextInt();

        Aluno[] alunos = new Aluno[quantidadeAlunos];

        for (int i = 0; i < alunos.length; i++) {
            scanner.nextLine();

            System.out.println("\nCadastro do aluno " + (i + 1));

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            double[] notas = new double[quantidadeProvas];

            for (int j = 0; j < notas.length; j++) {
                double nota;

                while (true) {
                    System.out.print("Digite a nota da prova " + (j + 1) + ": ");
                    nota = scanner.nextDouble();

                    if (nota >= 0 && nota <= 10) {
                        notas[j] = nota;
                        break;
                    } else {
                        System.out.println("Nota inválida! Digite uma nota entre 0 e 10.");
                    }
                }
            }

            alunos[i] = new Aluno(nome, matricula, notas);
        }

        System.out.println("\n===== DADOS DOS ALUNOS =====");

        for (Aluno aluno : alunos) {
            aluno.exibirDados();
            System.out.println("----------------------------");
        }

        scanner.close();
    }
}

class Aluno {
    private String nome;
    private String matricula;
    private double[] notas;

    public Aluno(String nome, String matricula, double[] notas) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.length;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);

        System.out.print("Notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);

            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.printf("\nMédia: %.2f%n", calcularMedia());
    }
}