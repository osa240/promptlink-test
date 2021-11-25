import java.util.Date;
import java.util.Random;
import service.LimitedSet;
import service.LimitedSetImpl;

public class Main {
    public static void main(String[] args) {
        LimitedSet<Object> limitedSet = new LimitedSetImpl();
        limitedSet.add("2");
        limitedSet.add("3");
        limitedSet.contains("2");
        limitedSet.contains("2");
        limitedSet.remove("2");
        limitedSet.add("4");
        limitedSet.add("2");
        Date timeStart = new Date();
        for (int i = 0; i < 1_000_000; i++) {
            limitedSet.add(i);
            System.out.println(limitedSet.contains(new Random().nextInt(1_000_000)));
        }
        for (int i = 0; i < 1_000_000; i++) {
            System.out.println(limitedSet.remove(i));
            System.out.println(limitedSet.contains(new Random().nextInt(1_000_000)));
        }
        Date timeFinish = new Date();
        System.out.println((timeFinish.getTime() - timeStart.getTime()) / 1000
                + " seconds program was in work");
    }
}
