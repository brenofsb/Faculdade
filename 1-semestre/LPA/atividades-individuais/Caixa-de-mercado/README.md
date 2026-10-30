# Caixa_de_mercado

**Disciplina:** LPA - Lógica de Programação  
**Última atualização:** 2026-09-24

## Visão geral
Sistema simples de caixa de mercado desenvolvido em Java para registrar produtos por código, identificar sua categoria e calcular o valor total da compra.

## Objetivo
Automatizar a soma dos valores de produtos conforme sua categoria e exibir o total final da compra.

## Funcionalidades
- Registro de produtos até o usuário digitar `0`
- Classificação automática por categoria:
  - `1 a 4`: alimentos perecíveis
  - `5 e 6`: vestuário
  - `7`: higiene pessoal
- Validação de código inválido
- Cálculo automático do valor da compra
- Exibição do total final

## Tecnologias
- Java
- `Scanner`
- Estruturas condicionais
- Estruturas de repetição

## Como rodar
1. Abra o terminal.
2. Acesse a pasta do projeto:
   ```bash
   cd 1-semestre/LPA/atividades-individuais/Caixa-de-mercado
   ```
3. Compile o arquivo:
   ```bash
   javac src/Caixa_de_mercado.java
   ```
4. Execute o programa:
   ```bash
   java -cp src Caixa_de_mercado
   ```

## Arquivo principal
- [src/Caixa_de_mercado.java](./src/Caixa_de_mercado.java)


