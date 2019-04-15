package com.dancheng.bs.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dancheng on 2018/12/16.
 * 首页加载
 */
@Controller
public class PageController {

	@RequestMapping(value = "/index", method = {RequestMethod.GET, RequestMethod.HEAD})
	public String toFrontPage(){ return "index"; }

    @RequestMapping(value = "/index1", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String toFrontPag1e(){ return "index1"; }

}
