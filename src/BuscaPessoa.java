import java.util.List;

public class BuscaPessoa {

    public static Pessoa buscarPorId(List<Pessoa> pessoas, int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getId() == id) {
                return pessoa;
            }
        }
        return null;
    }
}
