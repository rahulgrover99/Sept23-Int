package generics;

public class GenericPair<V1, V2> {

    V1 first;
    V2 second;

    public GenericPair(V1 first, V2 second) {
        this.first = first;
        this.second = second;
    }

    public V1 getFirst() {
        return first;
    }

    public V2 getSecond() {
        return second;
    }
}
