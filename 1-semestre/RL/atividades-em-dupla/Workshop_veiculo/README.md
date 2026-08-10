# Workshop_veiculo
Sistema de verificação lógica de segurança veicular desenvolvido em **C++**. A aplicação simula um mecanismo de controle de movimento de um veículo utilizando conceitos de **lógica proposicional**, verificando as condições do **cinto de segurança** e do **motor** para permitir ou bloquear o movimento.

O programa gera automaticamente uma **tabela verdade**, apresenta a expressão lógica completa, sua forma simplificada e o resultado final do sistema de segurança.

## Funcionalidades
- **Verificação do Cinto de Segurança (P):** Identifica se o cinto está afivelado ou não.
- **Verificação do Motor (Q):** Identifica se o motor está ligado ou desligado.
- **Expressão Lógica Completa:** Avalia a expressão:
  - `(P ∧ Q) ∨ (¬P ∧ Q)`
- **Simplificação Lógica:** Demonstra que a expressão pode ser reduzida para:
  - `Q`
- **Bloqueio de Movimento:** Impede o movimento quando o motor não está ligado.
- **Tabela Verdade Automática:** Exibe todas as combinações possíveis dos estados do sistema.
- **Resultado Final:** Informa se o movimento do veículo está **permitido** ou **bloqueado**.

## Tecnologias utilizadas
- C++
- Biblioteca iostream
- Estruturas de repetição
- Vetores bidimensionais
- Variáveis booleanas
- Operadores lógicos

## Autores
Desenvolvido por [@brenofsb](https://github.com/brenofsb) e [@mathribz](https://github.com/mathzribz) para o Workshop proposto como atividade da matéria de raciocínio lógico.
