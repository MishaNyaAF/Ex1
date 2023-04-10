package ex1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Items {

    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("domain")
    private String nickName;
    @JsonProperty("id")
    private int id;

    public Items() {
    }

    public Items(String firstName, String lastName, String nickName, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Items{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", id=" + id +
                '}';
    }
}
