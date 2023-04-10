package ex1.entity;

import java.util.List;

public class Response {

    private int count;
    private List<Items> items;

    public Response() {
    }

    public Response(int count, List<Items> items) {
        this.count = count;
        this.items = items;
    }

    public int getCount() {
        return count;
    }

    public List<Items> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Response{" +
                "count=" + count +
                ", items=" + items +
                '}';
    }

}
