package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.stream.Stream;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator{
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
    }
    @Override
    public Object[] toArray() {
        Stream<Object> array = Arrays.stream(smartArray.toArray()).sorted(comparator);
        if (!Arrays.stream(smartArray.toArray()).equals(array)) {
            return array.toArray();
        } else {
            return smartArray.toArray();
        }
    }
    @Override
    public String operationDescription() {
        return "Sort Decorator (sorts all the elements)";
    }

    @Override
    public int size() {
        return this.toArray().length;
    }




    
}
