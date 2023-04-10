package ex1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseUser {
    private int id;
    @JsonProperty("is_closed")
    private boolean status;
    private Counters counters;

    public ResponseUser() {
    }

    public ResponseUser(int id, boolean status, Counters counters) {
        this.id = id;
        this.status = status;
        this.counters = counters;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Counters getCounters() {
        return counters;
    }

    public void setCounters(Counters counters) {
        this.counters = counters;
    }

    @Override
    public String toString() {
        return "ResponseUser{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", counters=" + counters +
                '}';
    }
}
