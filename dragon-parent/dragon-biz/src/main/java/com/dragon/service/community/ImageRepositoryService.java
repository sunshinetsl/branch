package com.dragon.service.community;

import com.dragon.entity.ImageRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/6/23 0023.
 */
@Service("imageRepositoryService")
public interface ImageRepositoryService {
    int saveImages(ImageRepository repository);
}
