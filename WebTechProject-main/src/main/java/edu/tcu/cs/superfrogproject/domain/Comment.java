package edu.tcu.cs.superfrogproject.domain;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    private Integer id;
    private String text = null;

    @ManyToOne
    private Product product;
    
    
    public Comment() {
        super();
    }

    public Comment(final Integer id, final String text) {
        this.id = id;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
