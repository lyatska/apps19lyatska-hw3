package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.stream.Stream;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        Stream<Object> array = Arrays.stream(smartArray.toArray()).distinct();
        if (!Arrays.stream(smartArray.toArray()).equals(array)) {
            return array.toArray();
        } else {
            return smartArray.toArray();
        }
    }

    @Override
    public String operationDescription() {
        return "Distinct Decorator (removes duplicates from the array.)";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }

}
