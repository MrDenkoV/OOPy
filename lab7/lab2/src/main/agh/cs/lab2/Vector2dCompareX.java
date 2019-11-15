package agh.cs.lab2;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Vector2dCompareX implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if(o2==o1) return 0;
        if(!(o1 instanceof Vector2d) || !(o2 instanceof Vector2d))
            return 0;
        Vector2d v1 = (Vector2d) o1;
        Vector2d v2 = (Vector2d) o2;
        if(v1.equals(v2)) return 0;
        if(v1.x == v2.x) return v1.y > v2.y ? -1:1;
        return v1.x > v2.x ? -1:1;

    }
}
