package pojo;

public class goodsSmaSell{
    private  Smallclass sma;
    private  Seller sel;
    private  Goods good;
    private  Discount dis;

    public goodsSmaSell(Smallclass sma, Seller sel, Goods good, Discount dis) {
        this.sma = sma;
        this.sel = sel;
        this.good = good;
        this.dis = dis;
    }

    public Smallclass getSma() {
        return sma;
    }

    public void setSma(Smallclass sma) {
        this.sma = sma;
    }

    public Seller getSel() {
        return sel;
    }

    public void setSel(Seller sel) {
        this.sel = sel;
    }

    public Goods getGood() {
        return good;
    }

    public void setGood(Goods good) {
        this.good = good;
    }

    public goodsSmaSell() {
    }

    public Discount getDis() {
        return dis;
    }

    public void setDis(Discount dis) {
        this.dis = dis;
    }
}
