package kw.test.desktop;

public class App {
    public static void main(String[] args) {
        int dd = 5;
        for (int i = 0; i < 10; i++) {
            System.out.print((int)(dd * Math.floor(i/dd))+" ");
        }
    }
}
//0 0 0 0 0 5 5 5 5 5