package ex1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RawUserData {
    @JsonProperty("response")
    private List<ResponseUser> responseUser;

    public RawUserData() {
    }

    public RawUserData(List<ResponseUser> responseUser) {
        this.responseUser = responseUser;
    }

    public List<ResponseUser> getResponseUser() {
        return responseUser;
    }

    public void setResponseUser(List<ResponseUser> responseUser) {
        this.responseUser = responseUser;
    }

    @Override
    public String toString() {
        return "RawUserData{" +
                "responseUser=" + responseUser +
                '}';
    }
}
