package com.dragon.service.community;

import com.dragon.dto.BaseSearchConditionDTO;
import com.dragon.entity.HomeImpress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeImpressService")
public interface HomeImpressService {

    int saveHomeImpress(HomeImpress homeImpress);

    BaseSearchConditionDTO selectHomeImpressList(BaseSearchConditionDTO searchDTO);
}
