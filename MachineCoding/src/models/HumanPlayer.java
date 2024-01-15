package models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class HumanPlayer extends Player {
    private int rank;
    private int age;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
