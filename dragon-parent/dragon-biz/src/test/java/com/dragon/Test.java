package com.dragon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dragon.entity.SysDict;
import com.dragon.service.func.SysDictService;
import com.dragon.service.func.SysDictserviceImpl;

public class Test {

	@Autowired
	private SysDictService sysDictService;
	
	@org.junit.Test
	public void getTest(){
		List<SysDict> list = sysDictService.queryByCode("A");
		System.out.println(list);
	}
	
	public static void main(String[] args) {
		SysDictService s = new SysDictserviceImpl<Object>();
		List<SysDict> list = s.queryByCode("A");
		System.out.println(list);
	}
}
