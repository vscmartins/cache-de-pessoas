import static java.lang.IO.*;

import java.util.ArrayList;
import java.util.List;

// Configuração inicial do limite do cache
final int LIMITE_CACHE = 10;

void main() {

    List<Pessoa> banco = new ArrayList<>();
    List<Pessoa> cache = new ArrayList<>();

    banco.add(new Pessoa(1, "Ana", 25));
    banco.add(new Pessoa(2, "Bruno", 30));
    banco.add(new Pessoa(3, "Carla", 22));
    banco.add(new Pessoa(4, "Diego", 28));
    banco.add(new Pessoa(5, "Elisa", 35));
    banco.add(new Pessoa(6, "Felipe", 27));
    banco.add(new Pessoa(7, "Gabriela", 31));
    banco.add(new Pessoa(8, "Hugo", 24));
    banco.add(new Pessoa(9, "Isabela", 29));
    banco.add(new Pessoa(10, "João", 33));
    banco.add(new Pessoa(11, "Karen", 26));
    banco.add(new Pessoa(12, "Lucas", 21));


    // O metodo readln aceita uma mensagem de texto diretamente como prompt
    String input = readln("Digite o ID da pessoa: ");
    int id = Integer.parseInt(input.trim());

    Pessoa pessoa = BuscaPessoa.buscarPorId(cache, id);
    if (pessoa != null) {
        cache.remove(pessoa);
        cache.add(pessoa);
        println("Pessoa encontrada no cache: " + pessoa);
        return;
    }


    pessoa = BuscaPessoa.buscarPorId(banco, id);
    if (pessoa != null) {
        if (cache.size() == LIMITE_CACHE) {
            cache.remove(0); // Remove o elemento mais antigo do cache (FIFO simples)
        }
        cache.add(pessoa);
        println("Pessoa buscada no banco e adicionada ao cache: " + pessoa);
    } else {
        println("Pessoa não encontrada no banco.");
    }
}
