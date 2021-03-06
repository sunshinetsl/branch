package com.dragon.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Administrator on 2015/6/18 0018.
 */
@Entity
@Table(name = "t_image_repository", schema = "", catalog = "dragon")
public class ImageRepository {
    private int id;
    private String imgType;
    private HomeImpress homeImpress;
    private String imageAddress;
    private String smallImageAddress;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "img_type")
    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL,optional = false)
    @JoinColumn(name = "source_id")
    public HomeImpress getHomeImpress() {
        return homeImpress;
    }

    public void setHomeImpress(HomeImpress homeImpress) {
        this.homeImpress = homeImpress;
    }

    @Basic
    @Column(name = "image_address")
    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    @Basic
    @Column(name = "small_image_address")
    public String getSmallImageAddress() {
        return smallImageAddress;
    }

    public void setSmallImageAddress(String smallImageAddress) {
        this.smallImageAddress = smallImageAddress;
    }


}
