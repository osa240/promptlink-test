package service;

public class LimitedSetImpl implements LimitedSet<Object> {
    private final Object[] plurality;
    private final int[] countOfReferences;
    private int indexOfLastNotPopularObject;

    {
        plurality = new Object[10];
        countOfReferences = new int[10];
    }

    @Override
    public void add(Object o) {
        for (int i = 0; i < plurality.length; i++) {
            if (plurality[i] == null || plurality[i].equals(o)) {
                plurality[i] = o;
                return;
            }
        }
        remove(returnNotPopularObject());
        plurality[indexOfLastNotPopularObject] = o;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < plurality.length; i++) {
            if (plurality[i] != null && plurality[i].equals(o)) {
                plurality[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < plurality.length; i++) {
            if (plurality[i] != null && plurality[i].equals(o)) {
                countOfReferences[i]++;
                return true;
            }
        }
        return false;
    }

    private Object returnNotPopularObject() {
        int minPopularity = countOfReferences[0];
        for (int i = 0; i < countOfReferences.length; i++) {
            if (countOfReferences[i] < minPopularity) {
                minPopularity = countOfReferences[i];
                indexOfLastNotPopularObject = i;
            }
        }
        return plurality[indexOfLastNotPopularObject];
    }
}
