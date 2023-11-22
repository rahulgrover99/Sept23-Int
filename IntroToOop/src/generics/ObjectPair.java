package generics;

import java.util.Objects;

public class ObjectPair {
    Object id;
    Object name;

    public ObjectPair(Object id, Object name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectPair{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // Representing a child as a parent -> we need not specify type conversion explicitly
    // Representing a parent type as a child type -> explicit conversion is required.
    @Override
    public boolean equals(Object x) {
        if (!(x instanceof ObjectPair)) {
            return false;
        }
        return ((ObjectPair) x).name.equals(name) &&
                ((ObjectPair) x).id.equals(id);

    }
}
