package com.dragon.service.community;

import com.dragon.dao.community.ImageRepositoryDAO;
import com.dragon.entity.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2015/6/23 0023.
 */
@Service("imageRepositoryServiceImpl")
public class ImageRepositoryServiceImpl implements ImageRepositoryService{

    private Logger logger = LoggerFactory.getLogger(ImageRepositoryServiceImpl.class);

    @Autowired
    private ImageRepositoryDAO imageRepositoryDAO;

    /**
     * ±£´æÍ¼Æ¬
     * @param repository
     * @return
     */
    @Override
    @Transactional
    public int saveImages(ImageRepository repository) {
        int count = 0;
        try {
            count = imageRepositoryDAO.save(repository);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
