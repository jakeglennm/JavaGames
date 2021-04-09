package compareIP;

public class CompareAddresses {
    int binary1[];
    int binary2[];
    int binarymask[];
    public CompareAddresses(int address1, int address2, int netmask){
        //TODO
        //Take String input in format "255.xxx.xxx.xxx" and convert to binary
        binary1 = decimalToBinary(address1);
        binary2 = decimalToBinary(address2);
        binarymask = decimalToBinary(netmask);
    }

    /*
    convert decimal to binary with given decimal value
     */
    private int[] decimalToBinary(int decimal){
        //TODO
        //convert input from "xxx.xxx.xxx.xxx" to binary in int array
        int[] binary = new int[32];
        int index = 0;
        while(decimal > 0){
            binary[index++] = decimal%2;
            decimal = decimal/2;
        }
        return binary;
    }

    /*
    compare array values
     */
    public String compareIPs(){
        int i = 0;
        while(binarymask[i] == 1){
            if(binary1[i] != binary2[i]) return "The IP addresses are not on local network";
        }
        return "The IP addresses are on the same local network";
    }

    /*
    print out entire binary bit by bit
     */
    public void printBinary(){
        for(int i = 0; i<binary1.length; i++){
            System.out.print(binary1[i]);
        }
        System.out.println(": address 1");
        for(int i = 0; i<binary2.length; i++){
            System.out.print(binary2[i]);
        }
        System.out.println(": address 2");
        for(int i = 0; i<binarymask.length; i++){
            System.out.print(binarymask[i]);
        }
        System.out.println(": address mask");
    }
}
