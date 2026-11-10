# SmartTV

**Disciplina:** POO - Programação Orientada a Objetos

## Visão geral
Aplicação de console em Java que simula o controle de televisões comuns e Smart TVs. O usuário escolhe uma TV e pode controlar suas funções pelo menu.

## Objetivo
Praticar programação orientada a objetos com classes, herança, sobrescrita de métodos, encapsulamento e interação entre objetos.

## Funcionalidades
- Controlar TVs da sala, do quarto e da varanda
- Ligar e desligar a TV
- Alterar o canal entre opções válidas
- Aumentar ou diminuir o volume, respeitando os limites
- Conectar e desconectar as Smart TVs
- Alternar entre os modos TV e streaming
- Alterar login e senha da conexão

## Tecnologias
- Java (JDK 11 ou superior)
- Programação orientada a objetos
- Aplicação de console

## Como rodar
Na raiz do repositório, execute:

1. Compile as classes:
   ```bash
   javac -d out 2-semestre/POO/atividades-individuais/smartTV/src/*.java
   ```
2. Inicie o programa:
   ```bash
   java -cp out Main
   ```

As credenciais iniciais das Smart TVs são login `123456` e senha `987654`. Elas podem ser alteradas durante a execução.

## Arquivos principais
- [Main.java](./src/Main.java) — menus e fluxo principal da aplicação
- [TV.java](./src/TV.java) — funcionalidades de uma TV
- [SmartTv.java](./src/SmartTv.java) — funcionalidades adicionais de uma Smart TV
