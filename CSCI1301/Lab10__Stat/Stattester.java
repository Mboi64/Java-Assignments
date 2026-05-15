
public class Stattester {

    public static void main(String[] args) {
        double[] data = {1,2,2,3,3,4};
        Stat stat1 = new Stat(data);
        System.out.println(stat1.getData());
        System.out.println("stat1 data = " + stat1.toString());
        System.out.println("stat1 min = " + stat1.min());
        System.out.println("stat1 max = " + stat1.max());
        System.out.println("stat1 average = " + stat1.average());
        System.out.println("stat1 mode = " + stat1.mode());
        System.out.println("stat1 data = " + stat1.toString());
    }

}
