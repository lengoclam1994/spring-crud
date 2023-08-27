package com.crud.springcrud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "new")
@Data
public class NewEntity extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "shortdescription")
    private String shortDescription;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;
}
