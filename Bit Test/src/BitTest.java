import java.io.*;
class BitTest{
    public static void main(String args[]){
        int a = 0xffffffff;
        int b = 0xff00ffff;
        String str = Integer.toHexString(a & b);
        System.out.println(str);
    }
}


