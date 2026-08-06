# Caixa_de_mercado
Sistema simples de caixa de mercado desenvolvido em Java. A aplicação permite registrar produtos por código, identificar automaticamente sua categoria, adicionar o valor correspondente à compra e calcular o total final da compra.

## Funcionalidades
**Registro de Produtos:** Permite inserir códigos de produtos até que o usuário digite `0` para encerrar.
- **Classificação Automática:**
  - **1 a 4:** Alimentos perecíveis
  - **5 e 6:** Vestuário
  - **7:** Higiene pessoal
- **Validação de Código:** Informa quando o código digitado não possui categoria cadastrada.
- **Adição Automática de Valores:**
  - Alimentos perecíveis: **R$ 8,75**
  - Vestuário: **R$ 69,90**
  - Higiene pessoal: **R$ 4,90**
- **Acúmulo da Compra:** Soma automaticamente o valor de todos os produtos válidos.
- **Total da Compra:** Exibe o valor total ao final da operação.

## Tecnologias utilizadas
- Java
- Estruturas de repetição e condicionais
- Variáveis e operadores aritméticos
- Entrada de dados com Scanner
- Aplicação Console (CLI)


