package com.dragon.controller.func;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dragon.common.BasicContorller;
import com.dragon.common.util.FunctionConstants;
import com.dragon.entity.Area;
import com.dragon.entity.SysFunc;
import com.dragon.entity.University;
import com.dragon.service.func.AreaService;
import com.dragon.service.func.SysDictService;
import com.dragon.service.func.SysFuncService;
import com.dragon.service.func.UniversityService;

/**
 * 系统设置
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/func")
public class SysFuncController extends BasicContorller{

	private Logger logger = LoggerFactory.getLogger(SysFuncController.class);
	
	@Autowired
	private SysFuncService sysFuncService;
	
	@Autowired
	private SysDictService sysDictService;
	
	/**
	 * 取菜单
	 * @return
	 */
	@RequestMapping("/getMenu")
	@ResponseBody
	public ModelMap ajaxGetFunctionMenu(){
		logger.debug("ajaxGetFunctionMenu --.start");
		List<SysFunc> funcList = sysFuncService.ajaxGetFunctionMenu(FunctionConstants.FUNCTION_MENU_TYPE,FunctionConstants.OFTEN_STATUS_ACTIVE);
		ModelMap model = new ModelMap();
		model.addAttribute("list", funcList);
		return model;
	}
}
