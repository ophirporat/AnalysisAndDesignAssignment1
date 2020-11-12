public class Address {

private String address;
private int counter;

    public Address() {
        counter++;
        this.address = "BEER SHEVA "+String.valueOf(counter);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}
