package generics;

public class Instructor {

    ObjectPair op;

    public Instructor(ObjectPair op) {
        this.op = op;
    }


    String getName(){
        return (String) op.name;
    }
}
