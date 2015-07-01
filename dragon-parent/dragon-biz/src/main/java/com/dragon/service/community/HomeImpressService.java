package com.dragon.service.community;

import com.dragon.entity.HomeImpress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeImpressService")
public interface HomeImpressService {

    int saveHomeImpress(HomeImpress homeImpress);

    List<HomeImpress> selectHomeImpressList(int currentPage, int pageSize);
}
