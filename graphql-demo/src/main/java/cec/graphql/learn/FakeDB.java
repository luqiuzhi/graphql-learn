package cec.graphql.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/30
 */
public class FakeDB {

    public static List<Book> books = new ArrayList<>();
    public static List<User> users = new ArrayList<>();

    static {
        books.add(new Book(1, "Java", "huay", 100));
        books.add(new Book(2, "Python", "huay", 200));
        books.add(new Book(3, "C++", "huay", 300));
        // 针对users数组进行初始化
        users.add(new User(10, "huay", 18, List.of(books.get(0), books.get(1))));
        users.add(new User(20, "bob", 30, List.of(books.get(0), books.get(2))));
        users.add(new User(30, "jerry", 60, List.of(books.get(1), books.get(2))));
    }
}
