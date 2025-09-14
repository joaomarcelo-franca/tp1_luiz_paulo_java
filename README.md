# Exercício 1: Explicar por que a qualidade do código é importante


## Tarefa:
- Explique três problemas estruturais neste código.
- Justifique por que esses problemas impactam a qualidade e manutenção do software.
- Refatore a classe para torná-la mais organizada e modular.

---

## ⚠️ Problemas estruturais do código
O código inicial apresentava alguns problemas estruturais:

1. **Listas paralelas (`contas` e `valores`)**  
   - Guardava contas em uma lista e saldos em outra.  
   - Isso gerava risco de inconsistência e dificultava manutenção.
   - Risco de falta de correlação.

2. **Falta de tipagem genérica (`List contas`, `List valores`)**  
   - Permitindo inserir qualquer tipo de dado na lista.  
   - Podia causar erros apenas em tempo de execução.
   - Erro no processarPagamentos(), a operação de subtração não funcionava, pois o valores.get(i) era enxergado como Object, não como Double.

3. **Baixa coesão e ausência de encapsulamento**  
   - A classe misturava responsabilidades (conta, saldo, relatório e pagamentos).  
   - Não existia uma entidade `Conta` própria.

---

## ✅ Solução
O código foi refatorado da seguinte forma:

- Criada a classe **`Conta`** para representar cada conta com seus dados.  
- O **`SistemaFinanceiro`** agora gerencia uma lista de contas (`List<Conta>`).  
- Responsabilidades bem separadas:  
  - `Conta` → encapsula nome e saldo.  
  - `SistemaFinanceiro` → adiciona contas, gera relatórios e processa pagamentos.  

---

# Exercício 2: Enumerar os quatro objetivos que um código de alta qualidade deve alcançar

## Tarefa:
- Explique como este código falha em atingir os quatro objetivos de um código de alta qualidade:
  - Legibilidade;
  - Redução de duplicação;
  - Facilidade de modificação;
  - Eficácia na comunicação.
Refatore o código para atender a esses princípios.
---
## ⚠️ Problemas no código atual
1. **Legibilidade**
 - Muitos if aninhados dificultam entender o fluxo.
 - O código só de relance não mostra a intenção clara.

2. **Redução de duplicação**
- Toda validação (null, vazio, tamanho) está embutida no mesmo método.
- Se o critério mudar (ex.: mínimo de 15 caracteres), será preciso alterar várias partes.

3. **Facilidade de modificação**
- As regras de negócio estão "hardcoded" dentro do método.
- Não existe separação entre validação e processamento → difícil evoluir.

4. **Eficácia na comunicação**
- Mensagens estão espalhadas dentro de condicionais.
- O método não expressa claramente sua intenção ("validar dado e processar").

---
## ✅ Solução

### Refatoração proposta

- Separar responsabilidades:

  - Um método para validar.

  - Outro para processar a lógica.

  - Uso de guard clauses (retornos antecipados) para evitar if aninhados.
---
### 🎯 Como a refatoração atende os princípios

**Legibilidade** → métodos isValido e isMuitoCurto deixam o código autoexplicativo.

**Redução de duplicação** → regras centralizadas em métodos reutilizáveis.

**Facilidade de modificação** → se o tamanho mínimo mudar, basta alterar a constante TAMANHO_MINIMO.

**Eficácia na comunicação** → o fluxo do processar comunica claramente a regra de negócio.

---

# Exercício 3: Garantir a qualidade do código estrategicamente

## Tarefa:
- Identifique problemas estruturais nesta classe.
- Explique como essas falhas afetam a manutenibilidade e a extensibilidade do código.
- Refatore a classe para torná-la mais modular, seguindo boas práticas de OOP.

## ⚠️ Problemas estruturais na classe

1. Listas paralelas (produtos, precos, quantidades)
 - Mantém informações em listas diferentes, mas que dependem de estarem sincronizadas pelo índice.
 - Alto risco de inconsistência (ex.: adicionar em uma lista e esquecer outra).
 - Difícil de entender e manter.

2. Falta de tipagem genérica nas listas (List sem <Tipo>)
 - Permite inserir qualquer tipo de objeto, quebrando a segurança de tipos.
 - Erros só são detectados em tempo de execução.

3. Baixa coesão e falta de encapsulamento
 - CarrinhoDeCompras lida diretamente com produto, preço e quantidade, quando isso deveria estar encapsulado em uma entidade própria (ex.: ItemDeCompra).
 - Isso viola princípios de OOP e prejudica extensibilidade (ex.: se for preciso adicionar desconto ou categoria do produto).

## 🚨 Impacto na manutenção e extensibilidade

 - Dificuldade de evolução: qualquer mudança na estrutura dos itens exige alterar várias listas e métodos.
 - Baixa legibilidade: não fica claro o que cada índice representa.
 - Risco de inconsistência: fácil ocorrer erro de sincronização entre listas.
 - Difícil adicionar novas funcionalidades: ex.: aplicar cupom de desconto, calcular imposto, etc.

## ✅ Solução
 
### Refatoração proposta com OOP

 - Criar uma classe ItemDeCompra para representar cada item.
 - CarrinhoDeCompras passa a gerenciar uma lista de itens.

## 🎯 Benefícios da refatoração

- Maior coesão: cada classe tem responsabilidade clara (ItemDeCompra representa produto, preço e quantidade; CarrinhoDeCompras gerencia a lista).
- Segurança de tipos: uso de List<ItemDeCompra>.
- Extensibilidade: fácil adicionar desconto, impostos, ou métodos como removerProduto.
- Legibilidade: código expressa claramente a intenção.

# Exercício 4: Dividir um problema em subproblemas com camadas de abstração

## Tarefa:
- Analise o código e identifique problemas de separação de responsabilidades.
- Refatore-o criando classes separadas para Livro e Biblioteca.

## ⚠️ Problemas no código

1. Listas paralelas (livros e disponibilidade)

 - Como no caso do carrinho, há dependência por índice.

 - Isso quebra encapsulamento e aumenta risco de inconsistência.

2. Baixa coesão

 - A classe SistemaBiblioteca cuida tanto da lista de livros quanto do estado de cada livro (se está disponível ou não).

 - Isso deveria estar dentro da própria classe Livro.

3. Dificuldade de extensão

 - Se quiser adicionar novos atributos (ex.: autor, ano de publicação), teria que criar mais listas paralelas, deixando o sistema ainda mais confuso.

## 🎯 Benefícios da refatoração

1. Separação clara de responsabilidades:

 - Livro → cuida do seu próprio estado (disponível ou não).

 - Biblioteca → apenas gerencia a coleção de livros.

2. Extensibilidade: fácil adicionar atributos (autor, gênero, ano).

3. Legibilidade: cada classe tem uma função clara.

4. Manutenibilidade: menos chance de erro de sincronização.

---

# Exercício 5: Dividir códigos em diferentes camadas de abstração usando métodos, classes e interfaces

## 🎯 Como ficou melhor:

1. Legibilidade: agora é claro onde está o modelo, a lógica e a interface.

2. Separação de responsabilidades: cada classe tem sua função.

3. Facilidade de modificação: se quiser trocar System.out por GUI ou API REST, só muda a camada de interface.

4. Abstração: Conta encapsula saldo e titular, evitando listas paralelas difíceis de manter.

---
# Exercício 6: Escrever funções pequenas e coesas

## 🚀 Melhorias aplicadas:

1. Divisão de responsabilidades

- imprimirCabecalho() → só cuida do cabeçalho.

- imprimirLinhaCliente() → imprime cliente individual.

- imprimirRodape() → cuida do rodapé.

2. Reutilização

- O método imprimirLinhaCliente() pode ser reutilizado em outros relatórios.

3. Facilidade de modificação

- Se mudar o formato (ex: gerar relatório em arquivo ou HTML), basta trocar os métodos de impressão sem mexer no fluxo geral.

---

# Exercício 7: Assegurar a clareza e robustez do código com contratos explícitos, validações e prevenção de estados inválidos

## ⚠️ Problemas no código
1.  Permite depósito negativo – alguém poderia chamar depositar(-100), o que na prática é um saque escondido.

2.  Permite saque maior que o saldo – isso pode gerar saldo negativo sem controle.

3.  Não há contrato explícito – não está claro para o usuário da classe quais são as regras de uso.

## 🎯 Melhorias aplicadas

1. Contratos explícitos (pré-condições)

- Construtor garante que não exista conta sem titular ou com saldo inicial negativo.

- depositar só aceita valores positivos.

- sacar exige valor positivo e menor ou igual ao saldo.

2. Consistência de estado

- Nunca teremos um saldo negativo indevido.

- O titular nunca será null ou vazio.

3. Clareza para o usuário da classe

- As exceções informam claramente a violação da regra de negócio.
---

# Exercício 8: Escrever comentários claros, com explicações essenciais e sem redundâncias ou ruídos desnecessários

## 🚨 Bons modos:
1. Usar nomes autoexplicativos → elimina a necessidade de comentários repetitivos.

2. Manter comentários só quando agregam contexto (ex.: regras de negócio, exceções, decisões de design).

## 🎯 Melhorias aplicadas

1. Nomes claros (descricao em vez de descriçao com acento → evita problemas de encoding).

2. Comentários úteis apenas no nível da classe → descrevem o propósito geral da classe (Representa um pedido de compra).

3. Validações adicionadas → impedem estados inválidos (valor negativo ou descrição vazia).

4. Remoção de comentários redundantes (como "método que retorna o ID") → já está explícito pelo nome getId().

# Exercício 9: Escrever códigos organizados, legíveis e bem estruturados

## 🎯 O que melhorar:
1. Indentação consistente

2. Espaçamento adequado

3. Nomes de variáveis mais claros (valor em vez de v)

4. Responsabilidade explícita no método

## ✅ Melhorias

Clareza: variável valor em vez de v.

Legibilidade: blocos bem separados e identação correta.

Comentário útil no método: explica o propósito e não o óbvio.

# Exercício 10: Promover a robustez do código com tratamento claro de erros e falhas visíveis

## ⚠️ Problemas no código original:

1. Erro de digitação: tolUpperCase() deveria ser toUpperCase().

2. Risco de NullPointerException: se dado for null, o código quebra em tempo de execução.

3. Sem validação clara: não há tratamento para valores inválidos ou mensagens úteis ao usuário.

## ✅ Melhorias aplicadas

1. Correção do erro de digitação (toUpperCase).

2. Validação explícita para null e string vazia.

3. Mensagens de erro claras via IllegalArgumentException.

4. Contrato explícito → garante que apenas dados válidos sejam processados.

# Exercício 11: Implementar sinalização explícita e implícita de erros

## 🔑 Melhorias que foram aplicadas

1. Mensagens claras de erro → explica exatamente por que falhou.

2. Exceção específica (CpfInvalidoException) → melhora manutenção e tratamento.

3. Escalabilidade → fácil adicionar novas regras sem mexer no contrato.

4. Segurança → garante que apenas CPFs válidos avancem no fluxo.

---

# Exercício 12: Tratar erros através da utilização de exceções

## ⚠️ Problemas no código original

1. Oculta a falha em sistemas maiores (não propaga o erro);

2. Não permite tratamento estruturado (try/catch);

3. Deixa o fluxo confuso em casos de falha.

## 🔑 Melhorias aplicadas

1. Exceções customizadas → comunicam o erro de forma clara.

2. Fluxo seguro → falhas não passam despercebidas.

3. Tratamento estruturado (try/catch) → permite recuperação ou logging.

4. Escalabilidade → fácil adicionar novos métodos de pagamento no futuro (ex: pix, transferencia).
