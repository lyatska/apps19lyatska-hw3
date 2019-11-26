package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;
import java.util.stream.Stream;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
    }
    @Override
    public Object[] toArray() {
        Stream<Object> array = Arrays.stream(smartArray.toArray()).map(function::apply);
        if (!Arrays.stream(smartArray.toArray()).equals(array)) {
            return array.toArray();
        } else {
            return smartArray.toArray();
        }
    }
    @Override
    public String operationDescription() {
        return "Map Decorator (uses a function to apply to each element)";
    }
    @Override
    public int size() {
        return this.toArray().length;
    }
}
