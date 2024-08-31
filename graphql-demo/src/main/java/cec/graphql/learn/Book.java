package cec.graphql.learn;

/**
 * @author huay@cecjiutian.com
 * @date 2024/8/29
 */
public class Book {
    private Integer id;
    private String name;
    private String author;
    private Integer price;

    public Book() {}

    public Book(Integer bookId, String bookName, String authorName, Integer price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }

        this.id = bookId;
        this.name = bookName;
        this.author = authorName;
        this.price = price;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String amount) {
        this.author = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
