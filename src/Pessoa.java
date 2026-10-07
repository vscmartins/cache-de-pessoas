public class Pessoa {

    private final int id;
    private final String nome;
    private final int idade;

    Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Pessoa{id=" + id + ", nome='" + nome + "', idade=" + idade + "}";
    }

}
