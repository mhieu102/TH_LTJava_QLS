package com.example.TH_LTJava_QLS.Model;

import com.example.TH_LTJava_QLS.Validator.annotation.ValidCategoryId;
import com.example.TH_LTJava_QLS.Validator.annotation.ValidUserId;
import com.example.TH_LTJava_QLS.Validator.annotation.ValidUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50, min = 1, message = "Title must be less than 50 characters")
    private String title;

    @Column(name = "author")
    @NotNull(message = "Price is required")
    private String author;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name ="category_id", referencedColumnName = "id")
    @ValidCategoryId
    private Category category;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id")
    @ValidUserId
    private User user;
}
