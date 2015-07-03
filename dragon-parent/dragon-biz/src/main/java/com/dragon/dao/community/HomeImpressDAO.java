package com.dragon.dao.community;

import com.dragon.entity.HomeImpress;
import com.dragon.entity.ImageRepository;
import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HomeImpressDAO<T> extends BaseDAO<T>{


    /**
     * 保存家乡印象
     * @param homeImpress
     * @return
     */
    @Transactional
    public int saveHomeImpress(HomeImpress homeImpress) {
        int count = 0;
        try {
            count = super.save((T) homeImpress);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 查询列表
     * @param page
     * @param rows
     * @return
     */
    public List<HomeImpress> selectHomeImpressList(Integer page, Integer rows) {
        List<Object> params = new ArrayList<Object>();
        StringBuffer buffer = new StringBuffer();
//        buffer.append("from HomeImpress h, ImageRepository r where h.id = r.homeImpress.id ");
//        buffer.append("and r.imgType = 'IMPRESS' ");
//        buffer.append(" order by h.createTime desc");
        buffer.append("from HomeImpress h ");
        buffer.append(" order by h.createTime desc");
        String hql = buffer.toString();
        List<HomeImpress> list = (List<HomeImpress>) super.find(hql, params, page, rows);
        for (HomeImpress home :list){
            System.out.print(home.getImages());
        }
        return list;
    }

    /**
     * 查询总记录数
     * @return
     */
    public long selectHomeImpressListCount() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("from HomeImpress h");
        String hql = buffer.toString();
        long count = super.count(hql);
        return count;
    }
}
