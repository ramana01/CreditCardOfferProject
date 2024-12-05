package com.CreditCardOffer.Credit.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "offers")
public class CreditCardOffer {
    @Id
    private String id;
    private String title;
    private String description;
    private Double discountPercentage;
    private String terms;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getDiscountPercentage() { return discountPercentage; }
    public void setDiscountPercentage(Double discountPercentage) { this.discountPercentage = discountPercentage; }

    public String getTerms() { return terms; }
    public void setTerms(String terms) { this.terms = terms; }
}
