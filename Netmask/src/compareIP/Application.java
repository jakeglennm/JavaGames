package compareIP;

public class Application {
    public static void main(String[] args) {
        //TODO
        CompareAddresses CA = new CompareAddresses(150,189,255); //use different values
        System.out.println(CA.compareIPs());
        CA.printBinary();
    }
}
