package com.dragon.service.community;

import com.dragon.entity.HomeImpress;
import org.springframework.stereotype.Service;

@Service("homeImpressService")
public interface HomeImpressService {

    int saveHomeImpress(HomeImpress homeImpress);
}
