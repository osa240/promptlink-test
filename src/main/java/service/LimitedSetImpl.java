package service;

import java.util.HashMap;
import java.util.Map;

public class LimitedSetImpl implements LimitedSet<Object> {
    private static final int INITIAL_CAPACITY = 1_000_000;
    private static final int CUSTOM_LOAD_FACTOR = 1;

    private final Map<Object, Integer> pluralityCountsOfReferences;
    private Object maxCountingObject;

    {
        pluralityCountsOfReferences = new HashMap<>(INITIAL_CAPACITY, CUSTOM_LOAD_FACTOR);
    }

    @Override
    public void add(Object o) {
        if (pluralityCountsOfReferences.size() == INITIAL_CAPACITY
                && !pluralityCountsOfReferences.containsKey(o)) {
            pluralityCountsOfReferences.remove(maxCountingObject);
            newMaxCountingObject();
        }
        if (!pluralityCountsOfReferences.containsKey(o)) {
            pluralityCountsOfReferences.put(o, 0);
        }
    }

    @Override
    public boolean remove(Object o) {
        return pluralityCountsOfReferences.remove(o) != null;
    }

    @Override
    public boolean contains(Object o) {
        if (pluralityCountsOfReferences.containsKey(o)) {
            int countOfReferences = pluralityCountsOfReferences.get(o) + 1;
            pluralityCountsOfReferences.put(o, countOfReferences);
            return true;
        }
        return false;
    }

    private void newMaxCountingObject() {
        int maxCount = 0;
        for (Map.Entry<Object, Integer> entry : pluralityCountsOfReferences.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCountingObject = entry.getKey();
            }
        }
    }
}
