package pojo;

public class smallBig {
    private  Smallclass sma;
    private  Bigclass big;

    public smallBig(Smallclass sma, Bigclass big) {
        this.sma = sma;
        this.big = big;
    }

    public smallBig() {
    }

    public Smallclass getSma() {
        return sma;
    }

    public void setSma(Smallclass sma) {
        this.sma = sma;
    }

    public Bigclass getBig() {
        return big;
    }

    public void setBig(Bigclass big) {
        this.big = big;
    }
}
