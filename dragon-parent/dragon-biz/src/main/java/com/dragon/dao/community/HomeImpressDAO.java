package com.dragon.dao.community;

import com.dragon.entity.HomeImpress;
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
    public List<HomeImpress> selectHomeImpressList(int page, int rows) {
        List<Object> params = new ArrayList<Object>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("from HomeImpress home left join ImageRepository image ");
        buffer.append("on image.sourceId = home.id where image.imgType = 'IMPRESS' ");
        buffer.append(" order by home.createTime desc");
        String hql = buffer.toString();
        List<HomeImpress> list = (List<HomeImpress>) super.find(hql, params, page, rows);
        return list;
    }

}
