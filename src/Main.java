import static java.lang.IO.*;

void main() {

    List<Pessoa> banco = new ArrayList<>();
    List<Pessoa> cache = new ArrayList<>();

    // dados mockados do banco
    banco.add(new Pessoa(1, "Ana", 25));
    banco.add(new Pessoa(2, "Bruno", 30));
    banco.add(new Pessoa(3, "Carla", 22));
    banco.add(new Pessoa(4, "Diego", 28));
    banco.add(new Pessoa(5, "Elisa", 35));

    while (true) {
        int opcao = Integer.parseInt(readln("\n|        MENU         |" +
                                                   "\n|1 - Buscar pessoa    |" +
                                                   "\n|2 - Cadastrar pessoa |" +
                                                   "\n|3 - Mostrar cache    |" +
                                                   "\n|0 - Sair: "));

        if (opcao == 0) {
            break;
        }

        if (opcao == 3) {
            if (cache.isEmpty()) {
                println("Cache vazio.");
            } else {
                println("Cache atual (" + cache.size() + "/10):");
                for (Pessoa p : cache) {
                    println(p.toString());
                }
            }
            continue;
        }


        if (opcao == 2) {
            String nome = readln("Digite o nome: ");
            int idade = Integer.parseInt(readln("Digite a idade: "));
            Pessoa nova = new Pessoa(banco.size() + 1, nome, idade);
            banco.add(nova);
            println("Pessoa cadastrada no banco: " + nova);
            continue;
        }

        if (opcao != 1) {
            println("Opcao invalida.");
            continue;
        }


        int id = Integer.parseInt(readln("Digite o ID da pessoa: "));

        Pessoa achada = null;
        for (Pessoa p : cache) {
            if (p.getId() == id) {
                achada = p;
            }
        }
        if (achada != null) {
            println("Pessoa encontrada no cache: " + achada);
            continue;
        }


        for (Pessoa p : banco) {
            if (p.getId() == id) {
                achada = p;
            }
        }
        if (achada == null) {
            println("Pessoa nao encontrada no banco.");
            continue;
        }


        if (cache.size() == 10) {
            cache.remove(0);
        }
        cache.add(achada);
        println("Pessoa buscada no banco e adicionada ao cache: " + achada);
    }


    if (!cache.isEmpty()) {
        println("\nCache final:");
        for (Pessoa p : cache) {
            println(p.toString());
        }
    } else {

        println("\nCache vazio. Ultimos inseridos:");
        int inicio = Math.max(0, banco.size() - 10);
        for (int i = inicio; i < banco.size(); i++) {
            println(banco.get(i).toString());
        }
    }
}

