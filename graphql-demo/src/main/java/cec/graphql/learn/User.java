package cec.graphql.learn;

import java.util.List;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/29
 */
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private List<Book> books;

    public User(Integer id, String name, Integer age, List<Book> books) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
