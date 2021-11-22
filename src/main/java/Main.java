import java.util.Random;
import service.LimitedSet;
import service.LimitedSetImpl;

public class Main {
    public static void main(String[] args) {
        LimitedSet<Object> limitedSet = new LimitedSetImpl();
        for (int i = 0; i < 100; i++) {
            limitedSet.add(i);
            System.out.println(limitedSet.contains(new Random().nextInt(25)));
        }
        for (int i = 0; i < 100; i++) {
            System.out.println(limitedSet.remove(i));
            System.out.println(limitedSet.contains(new Random().nextInt(25)));
        }
    }
}
