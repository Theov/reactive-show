package fr.thiiozz.model;

public class Wine {
    private String name;
    private int year;
    private int price;
    private long creationInstant;

    public Wine() {
        this.creationInstant = System.currentTimeMillis();
    }

    public Wine(String name, int year, int price) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.creationInstant = System.currentTimeMillis();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCreationInstant() {
        return creationInstant;
    }

    public void setCreationInstant(long creationInstant) {
        this.creationInstant = creationInstant;
    }

    public void display(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Wine{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", creationInstant=" + creationInstant +
                '}';
    }
}

