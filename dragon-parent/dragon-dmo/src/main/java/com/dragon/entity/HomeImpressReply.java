package com.dragon.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Administrator on 2015/6/18 0018.
 */
@Entity
@Table(name = "t_home_impress_reply", schema = "", catalog = "dragon")
public class HomeImpressReply {
    private int id;
    private Integer impressId;
    private Integer replyId;
    private String replyName;
    private Integer byReplyId;
    private String byReplyName;
    private Timestamp createTime;
    private String tHomeImpressReplycol;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "impress_id")
    public Integer getImpressId() {
        return impressId;
    }

    public void setImpressId(Integer impressId) {
        this.impressId = impressId;
    }

    @Basic
    @Column(name = "reply_id")
    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    @Basic
    @Column(name = "reply_name")
    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    @Basic
    @Column(name = "by_reply_id")
    public Integer getByReplyId() {
        return byReplyId;
    }

    public void setByReplyId(Integer byReplyId) {
        this.byReplyId = byReplyId;
    }

    @Basic
    @Column(name = "by_reply_name")
    public String getByReplyName() {
        return byReplyName;
    }

    public void setByReplyName(String byReplyName) {
        this.byReplyName = byReplyName;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "t_home_impress_replycol")
    public String gettHomeImpressReplycol() {
        return tHomeImpressReplycol;
    }

    public void settHomeImpressReplycol(String tHomeImpressReplycol) {
        this.tHomeImpressReplycol = tHomeImpressReplycol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HomeImpressReply that = (HomeImpressReply) o;

        if (id != that.id) return false;
        if (impressId != null ? !impressId.equals(that.impressId) : that.impressId != null) return false;
        if (replyId != null ? !replyId.equals(that.replyId) : that.replyId != null) return false;
        if (replyName != null ? !replyName.equals(that.replyName) : that.replyName != null) return false;
        if (byReplyId != null ? !byReplyId.equals(that.byReplyId) : that.byReplyId != null) return false;
        if (byReplyName != null ? !byReplyName.equals(that.byReplyName) : that.byReplyName != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (tHomeImpressReplycol != null ? !tHomeImpressReplycol.equals(that.tHomeImpressReplycol) : that.tHomeImpressReplycol != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (impressId != null ? impressId.hashCode() : 0);
        result = 31 * result + (replyId != null ? replyId.hashCode() : 0);
        result = 31 * result + (replyName != null ? replyName.hashCode() : 0);
        result = 31 * result + (byReplyId != null ? byReplyId.hashCode() : 0);
        result = 31 * result + (byReplyName != null ? byReplyName.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (tHomeImpressReplycol != null ? tHomeImpressReplycol.hashCode() : 0);
        return result;
    }
}
