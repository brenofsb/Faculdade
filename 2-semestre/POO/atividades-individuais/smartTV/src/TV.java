public class TV {
    private String nome;
    private boolean ligada;
    private int canal, volume;

    public static final int volMax = 100, volMin = 0;

    public TV(String nome) {
        this.nome = nome;
        this.ligada = false;
        this.canal = 1;
        this.volume = 0;
    }

    public void power() {
        if (!this.ligada) {
            this.ligada = true;
        } else {
            this.ligada = false;
        }
    }

    public void altCanal(int canal) {
        if (canal == 1 || canal == 3 || canal == 5 || canal == 7 || canal == 11) {
            this.canal = canal;
        } else {
            System.out.println("Canal inválido");
        }
    }

    public void aumentarVol() {
        if (!this.ligada) {
            System.out.println("Ligue a TV primeiro");
        } else {
            if (volume >= volMax) {
                System.out.println("Volume máximo atingido");
            } else {
                this.volume++;
            }
        } 
    }

    public void diminuirVol() {
        if (this.ligada) {
            if (volume <= volMin) {
                System.out.println("Volume mínimo atingido");
            } else {
                this.volume--;
            }
        } else {
            System.out.println("Ligue a TV primeiro");
        }
    }

    public String cNome() {
        return this.nome;
    }

    public boolean cLigada() {
        return this.ligada;
    }

    public int cCanal() {
        return this.canal;
    }

    public int cVolume() {
        return this.volume;
    }
}
