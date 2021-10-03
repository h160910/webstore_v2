package hvl.dat152.model;

public class Product {

    private final int pid;
    private final String name;
    private double priceInEuros;
    private final String imageFile;

    public Product(int pid, String name, double priceInEuros, String imageFile) {
        this.pid = pid;
        this.name = name;
        this.priceInEuros = priceInEuros;
        this.imageFile = imageFile;
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

    public String getImageFile() {
        return imageFile;
    }

    public void convertPrice(double priceInEuros) {
        this.priceInEuros = priceInEuros;
    }

    @Override
    public String toString() {
        return "[" + pid + "] " + name + " (" +  priceInEuros + ")";
    }

}
