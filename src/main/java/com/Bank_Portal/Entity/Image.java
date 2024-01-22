package com.Bank_Portal.Entity;


import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

import java.sql.Blob;
import java.util.Date;

@Entity
@Validated
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    private Blob image;
    private Date date = new Date();
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Blob getImage() {
        return image;
    }
    public void setImage(Blob image) {
        this.image = image;
    }
    public Date getDate() {
        return date;
    }
}


