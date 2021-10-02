package hvl.dat152.model;

public class Product {

    private int pid;
    private String name;
    private double priceInEuros;

    public Product(int pid, String name, double priceInEuros) {
        this.pid = pid;
        this.name = name;
        this.priceInEuros = priceInEuros;
    }

    public int getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public double getPriceInEuros() {
        return priceInEuros;
    }

    @Override
    public String toString() {
        return "[" + pid + "] " + name;
    }

}
