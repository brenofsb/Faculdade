public class SmartTv extends TV {

    private int modo;
    private String login, senha;
    private boolean conectado;

    public SmartTv(String nome) {
        super(nome);
        this.modo = 1;
        this.conectado = false;
        this.login = "123456";
        this.senha = "987654";
    }

    @Override
    public void power() {
        super.power();

        if (cLigada()) {
            this.modo = 1;
        } else {
            this.conectado = false;
        }
    }

    public void conect(String login, String senha) {
        if (!login.equals(this.login) || !senha.equals(this.senha)) {
            System.out.println("Login ou senha incorretos");
        } else {
            System.out.println("Conectado");
            conectado = true;
        }
    }

    public void desconect() {
        if (!cLigada()) {
            System.out.println("A TV está desligada.");
        } else if (!conectado) {
            System.out.println("A TV não está conectada");
        } else {
            System.out.println("Desconectado, mudando para o modo TV...");
            conectado = false;
            modo = 1;
        }
    }

    public void altModo(int modo) {
        if (modo < 1 || modo > 2) {
            System.out.println("Modo inválido");
        } else {
            this.modo = modo;
        } 
    }

    @Override 
    public void altCanal(int canal) {
        if (modo == 1) {
            super.altCanal(canal);
        } else {
            System.out.println("Mude para o modo TV para alterar o canal");
        }
    }

    public void altLogin(String login) {
        if (!cLigada()) {
            System.out.println("A TV está desligada.");
        } else if (!conectado) {
            System.out.println("A TV não está conectada");
        } else if (login.isBlank()) {
            System.out.println("O login não pode ser vazio");
        } else {
            this.login = login;
            System.out.println("Login alterado com sucesso");
        }
    }

    public void altSenha(String senha) {
        if (!cLigada()) {
            System.out.println("A TV está desligada.");
        } else if (!conectado) {
            System.out.println("A TV não está conectada");
        } else if (senha.isBlank()) {
            System.out.println("A senha não pode ser vazia");
        } else {
            this.senha = senha;
            System.out.println("Senha alterada com sucesso");
        }
    }   

    public int cModo() {
        return this.modo;
    }

    public boolean cConectado() {
        return this.conectado;
    }
}
