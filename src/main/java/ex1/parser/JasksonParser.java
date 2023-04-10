package ex1.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ex1.entity.Items;
import ex1.entity.Raw;
import ex1.entity.RawUserData;
import ex1.entity.ResponseUser;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class JasksonParser {
    public static int getId(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RawUserData rawUserData = objectMapper.readValue(new URL(url), RawUserData.class);
        int userId = 0;
        for (ResponseUser responseUser : rawUserData.getResponseUser()) {
            userId = responseUser.getId();
        }
        return userId;
    }

    public static boolean isClosed(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        RawUserData rawUserData = objectMapper.readValue(new URL(url), RawUserData.class);
        boolean privacyStatus = true;
        for (ResponseUser responseUser : rawUserData.getResponseUser()) {
            privacyStatus = responseUser.getStatus();
        }
        return privacyStatus;
    }

    public static int getFriendsCount(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RawUserData raw = objectMapper.readValue(new URL(url), RawUserData.class);

        int friendsQuantity = 0;
        for (ResponseUser responseUser : raw.getResponseUser()) {
            friendsQuantity = responseUser.getCounters().getFriendsNumber();
        }
        return friendsQuantity;
    }

    public static List<Items> parseJson(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Raw raw = objectMapper.readValue(new URL(url), Raw.class);

        if (raw.getError() != null) {
            System.out.println("Ошибка");
            return null;
        }
        return raw.getResponse().getItems();
    }

    public static void printList(String url) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Raw raw = objectMapper.readValue(new URL(url), Raw.class);

        for (Items item : raw.getResponse().getItems()) {
            System.out.println("id: " + item.getId() + ", ФИО: " + item.getFirstName() + " " + item.getLastName() + ", Никнейм: " + item.getNickName());
        }
    }
}
