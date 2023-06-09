package ex1;

import ex1.entity.Items;
import ex1.parser.JasksonParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static List<Items> Parser(String inputLink) throws IOException {
        final String token = ""; // Вставить свой access-token VK
        if (!inputLink.matches("^vk.com/[A-Za-z0-9_.]+$") && !inputLink.matches("^https://vk.com/[A-Za-z0-9_.]+$")) {
            System.out.println("Некорректный формат ссылки");
            return null;
        }
        Pattern pattern = Pattern.compile("[A-Za-z0-9_.]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputLink);
        String userDomain = "";
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            userDomain = inputLink.substring(start, end);
        }

        String getIdUrl = "https://api.vk.com/method/users.get?user_id=" + userDomain +
                "&access_token=" + token + "&fields=counters&v=5.131";

        if (JasksonParser.getId(getIdUrl) == 0) {
            System.out.println("Такого профиля не существует");
            return null;
        }

        if (JasksonParser.isClosed(getIdUrl)) {
            System.out.println("Профиль закрыт");
            return null;
        }

        final int count = 5000;
        double a = JasksonParser.getFriendsCount(getIdUrl);
        int q = (int) Math.ceil(a / count);
        System.out.println("ID пользователя: " + JasksonParser.getId(getIdUrl) + "\nСписок друзей пользователя:");
        String parseUrl = "https://api.vk.com/method/friends.get?user_id=" + JasksonParser.getId(getIdUrl) +
                "&fields=domain&access_token=" + token + "&count=5000&v=5.131";
//        if (JasksonParser.parseJson(parseUrl) == null) {
//            return null;
//        }
        var res = new ArrayList<>(Objects.requireNonNull(JasksonParser.parseJson(parseUrl)));
        JasksonParser.printList(parseUrl);
        if (q > 1) {
            for (int i = 1; i < q; i++) {
                parseUrl = "https://api.vk.com/method/friends.get?user_id=" + JasksonParser.getId(getIdUrl) +
                        "&fields=domain&access_token=" + token + "&count=5000&offset=" + count * i + "&v=5.131";
                res.addAll(JasksonParser.parseJson(parseUrl));
                JasksonParser.printList(parseUrl);
            }
        }
        return res;
    }

}


