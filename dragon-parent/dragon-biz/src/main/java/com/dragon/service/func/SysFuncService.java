package com.dragon.service.func;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dragon.entity.SysFunc;

@Service("sysFuncService")
public interface SysFuncService {

	List<SysFunc> ajaxGetFunctionMenu(String functionMenuType,
			String oftenStatusActive);

}
