package ex1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Counters {
    @JsonProperty("friends")
    private int friendsNumber;

    public Counters() {
    }

    public Counters(int friendsNumber) {
        this.friendsNumber = friendsNumber;
    }

    public int getFriendsNumber() {
        return friendsNumber;
    }

    public void setFriendsNumber(int friendsNumber) {
        this.friendsNumber = friendsNumber;
    }

    @Override
    public String toString() {
        return "Counters{" +
                "friendsNumber=" + friendsNumber +
                '}';
    }
}
