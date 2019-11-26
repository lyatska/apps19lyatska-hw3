package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;
import java.util.stream.Stream;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;

    public FilterDecorator(SmartArray smartArray, MyPredicate predicate) {
        super(smartArray);
        this.predicate = predicate;

    }
    @Override
    public Object[] toArray() {
        Stream<Object> array = Arrays.stream(smartArray.toArray()).filter(predicate::test);
        if (!Arrays.stream(smartArray.toArray()).equals(array)) {
            return array.toArray();
        }
        return smartArray.toArray();
    }
    @Override
    public String operationDescription() {
        return "Filter Decorator (if predicate is not suited, this decorator removes that element.)";
    }

    @Override

    public int size() {
        return this.toArray().length;
    }
}


