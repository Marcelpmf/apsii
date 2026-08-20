class Banco {

    private String nome;
    private String cpf;
    private double saldo;

    public Banco(String nome, String cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public Banco() {
        this.nome = "sem nome";
        this.cpf = "sem cpf";
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

public class AtividadeAPS2 {
    public static void main(String[] args) {

        Banco banco = new Banco("João", "123.456.789-00", 1000.0);
        System.out.println("Nome: " + banco.getNome());
        System.out.println("CPF: " + banco.getCpf());
        System.out.println("Saldo: " + banco.getSaldo());

        System.out.println("-----------------------------");

        Banco banco2 = new Banco();
        System.out.println("Nome: " + banco2.getNome());
        System.out.println("CPF: " + banco2.getCpf());
        System.out.println("Saldo: " + banco2.getSaldo());

        System.out.println("--------------Imprimir valor de B1---------------");
        System.out.println("Nome: " + banco.getNome());
        System.out.println("CPF: " + banco.getCpf());
        System.out.println("Saldo: " + banco.getSaldo());

        //"--------------Alterar B1---------------"
        banco.setSaldo(2000.0);

        System.out.println("--------------Imprimir valor de B1 após alteração---------------");
        System.out.println("Nome: " + banco.getNome());
        System.out.println("CPF: " + banco.getCpf());
        System.out.println("Saldo: " + banco.getSaldo());
    }
}