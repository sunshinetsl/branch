package com.dragon.dao.community;

import com.dragon.entity.HomeImpress;
import org.springframework.stereotype.Repository;

import com.dragon.common.dao.BaseDAO;
import org.springframework.transaction.annotation.Transactional;

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
}
