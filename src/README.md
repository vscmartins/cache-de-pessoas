# Simulador de Banco de Dados + Cache (Java)

Programa simples de console que simula como um **cache** funciona na frente de um **banco de dados**. Primeiro ele procura a pessoa no cache; se não achar, procura no banco e guarda no cache.

## O que tem no projeto

| Arquivo | Para que serve |
|---|---|
| `Pessoa.java` | Classe com `id`, `nome` e `idade`. Tem `getId()` e `toString()`. |
| `Main.java` | Todo o programa: menu, busca, cadastro e cache. |

## Como rodar

Precisa de **Java 25 ou superior**, por causa do `import static java.lang.IO.*;` e do `void main()` sem `public static`.

- **Pelo terminal** (com os dois arquivos na mesma pasta):
  ```
  java Main.java
  ```
- **Pela IDE** (IntelliJ, por exemplo): abra a pasta e execute a `Main`.

## Como funciona

Ao iniciar, o programa cria duas listas:

- `banco`: representa o banco de dados. Começa com 5 pessoas mockadas (Ana, Bruno, Carla, Diego e Elisa).
- `cache`: guarda as pessoas buscadas recentemente. O limite é de **10 pessoas**.

Depois entra em um loop com este menu:

```
1 - Buscar pessoa | 2 - Cadastrar pessoa | 3 - Mostrar cache | 0 - Sair
```

### Opção 1: Buscar pessoa
1. O usuário digita um ID.
2. O programa procura no `cache`.
    - Achou: imprime `Pessoa encontrada no cache: ...`
3. Se não achou, procura no `banco`.
    - Achou: adiciona ao cache e imprime `Pessoa buscada no banco e adicionada ao cache: ...`
    - Não achou: imprime `Pessoa nao encontrada no banco.`
4. Se o cache já tem 10 pessoas, a **mais antiga** (a primeira da lista) é removida antes de adicionar a nova.

### Opção 2: Cadastrar pessoa
O usuário digita nome e idade. O ID é gerado automaticamente (`tamanho do banco + 1`) e a pessoa vai para o `banco`. Ela só entra no cache quando alguém a buscar pelo ID.

### Opção 3: Mostrar cache
Imprime o conteúdo atual do cache sem encerrar o programa. Se estiver vazio, avisa.

### Opção 0: Sair
Encerra o loop e imprime o resultado final:
- Se o cache foi usado: mostra o cache final.
- Se o cache ficou vazio: mostra os **últimos 10 inseridos no banco** (mockados + cadastrados pelo usuário).
