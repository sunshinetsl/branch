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
    private Integer sourceId;
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

    @Basic
    @Column(name = "source_id")
    @ManyToOne(targetEntity = HomeImpress.class)
    @JoinColumn(name="id")
    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageRepository that = (ImageRepository) o;
        if (id != that.id) return false;
        if (imgType != null ? !imgType.equals(that.imgType) : that.imgType != null) return false;
        if (sourceId != null ? !sourceId.equals(that.sourceId) : that.sourceId != null) return false;
        if (imageAddress != null ? !imageAddress.equals(that.imageAddress) : that.imageAddress != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imgType != null ? imgType.hashCode() : 0);
        result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
        result = 31 * result + (imageAddress != null ? imageAddress.hashCode() : 0);
        return result;
    }
}
