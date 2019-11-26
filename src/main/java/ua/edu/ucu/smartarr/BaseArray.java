package ua.edu.ucu.smartarr;
import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] arr;
    public BaseArray(Object[] newArray) {
        this.arr = newArray.clone();
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "This is Base Array!";
    }

    @Override
    public int size() {
        return arr.length;
    }
}
