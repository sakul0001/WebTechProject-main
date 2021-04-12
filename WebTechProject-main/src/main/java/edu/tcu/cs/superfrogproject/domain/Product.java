package edu.tcu.cs.superfrogproject.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name = null;
    @Column(length = 1000)
    private String description = null;
    private BigDecimal price = null;
    private boolean inStock = false;
    private String imageURL = null;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<Comment>();

    public Product() {

    }

    public Product(final String name, final boolean inStock, final BigDecimal price) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
        comment.setProduct(this);
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String img) {
        this.imageURL = img;
    }
}
