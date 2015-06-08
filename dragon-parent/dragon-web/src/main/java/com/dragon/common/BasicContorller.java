package com.dragon.common;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * contorller
 * 
 * @author tsl
 * 
 * 2015-5-8
 */
public class BasicContorller {

	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private Map<String, Object> session;
	protected ServletContext servletContext;
	protected String path;
	protected String basePath;
	public Gson gson = new Gson();
	
	public BasicContorller() {
		
	}
	

	public String getBasePath() {
		basePath = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + path + "/";
		return basePath;
	}
	
	public String getPath() {
		path = request.getContextPath();
		return path;
	}
	
	protected boolean POST() {
		if (request.getMethod().equals("POST"))
			return true;
		else
			return false;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
	
}
