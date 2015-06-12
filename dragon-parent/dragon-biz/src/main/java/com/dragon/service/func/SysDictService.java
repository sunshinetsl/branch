package com.dragon.service.func;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dragon.entity.SysDict;

@Service("sysDictService")
public interface SysDictService {

	
	public List<SysDict> queryByCode(String dictCode);
	
	public SysDict queryByCodeAndItem(String dictCode, String itemCode);
	
	public SysDict queryById(Integer id);
}
