package com.softskill.exam.domain;

import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 
 * @description:  Web工具类.实现获取Request/Response/Session等
 * @author: dirk
 * @date：2017年8月30日 下午9:42:49 
 */

public class WebUtil {

	/**
	 * 取得HttpRequest的简化函数.
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = null;
		try{
			RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
			if(requestAttributes == null) {
				return null;
			}
			request = ((ServletRequestAttributes)requestAttributes).getRequest();
		}
		catch(Exception e) {
			
		}		
		return request;
	}
	
	/**
	 * 取得HttpSession的简化函数.
	 */
	public static HttpSession getSession(boolean isNew) {
		HttpServletRequest request = getRequest();
		if(request == null){
			return null;
		}
		return request.getSession(isNew);
	}
	
	/**
	 * 取得HttpSession的简化函数.
	 */
	public static HttpSession getSession(HttpServletRequest request, boolean isNew) {
		if(request == null){
			return null;
		}
		return request.getSession(isNew);
	}
	
	/**
	 * 取得HttpResponse的简化函数.
	 */
	public static HttpServletResponse getResponse() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
		if(requestAttributes == null) {
			return null;
		}
		return ((ServletRequestAttributes)requestAttributes).getResponse();
	}
	
	/**
	 * 取得HttpRequest中URL的简化方法.
	 */
	public static String getRequestUrl() {
		HttpServletRequest request = getRequest();
		return (request != null ? request.getRequestURL().toString() : "");
	}
	
	/**
	 * 取得HttpRequest中URI的简化方法.
	 */
	public static String getRequestUri() {
		HttpServletRequest request = getRequest();
		return (request != null ? request.getRequestURI() : "");
	}
	
	/**
	 * 取得HttpRequest中Referer的简化方法.
	 */
	public static String getRequestReferer() {
		HttpServletRequest request = getRequest();
		return (request != null ? request.getHeader("referer") : "");
	}
	
	/**
	 * 取得HttpRequest中Referer的简化方法.
	 */
	public static String getRequestReferer(HttpServletRequest request) {
		String referer = "";
		if(request != null && request.getHeader("referer") != "") {
			referer = request.getHeader("referer");
		}
		return referer;
	}
	
	/**
	 * 取得HttpRequest中Parameter的简化方法.
	 */
	public static String getParameter(String name) {
		HttpServletRequest request = getRequest();
		return (request != null ? request.getParameter(name) : "");
	}
	
	/**
	 * 取得HttpRequest中Parameter数组的简化方法.
	 */
	public static String[] getParameterValues(String name) {
		HttpServletRequest request = getRequest();
		return (request != null ? request.getParameterValues(name) : null);
	}	

	/**
	 * 取得HttpSession中Attribute的简化函数.
	 */
	public static Object getSessionAttribute(String name) {
		HttpSession session = getSession(false);
		return (session != null ? session.getAttribute(name) : null);
	}
	
	/**
	 * 设置HttpSession中Attribute的简化函数.
	 */
	public static void setSessionAttribute(Object object, String name) {
		HttpSession session = getSession(false);
		if(session != null)session.setAttribute(name, object);
	}
	
	/**
	 * 设置禁止客户端缓存的Header.
	 */
	public static void setDisableCacheHeader(HttpServletResponse response) {
		// Http 1.0 header
		response.setDateHeader("Expires", 1L);
		response.addHeader("Pragma", "no-cache");
		// Http 1.1 header
		response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
	}
	
	/**
	 * 获取客户端IP
	 * @return
	 */
	public static String getClientIp() {
		return getClientIp(getRequest());
	}
	
	/**
	 * 获取客户端IP
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {
		 String ip = "";
		 try {
			 if(request == null) {
				 return "";
			 }
			 ip = request.getHeader("X-Forwarded-For");
	         if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	             //多次反向代理后会有多个ip值，第一个ip才是真实ip
	             int index = ip.indexOf(",");
	             if(index != -1){
	                 return ip.substring(0,index);
	             }else{
	                 return ip;
	            }
	        }
	        ip = request.getHeader("X-Real-IP");
	        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
	            return ip;
	        } else {
	        	ip = request.getRemoteAddr();
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}        
        
        return ip;
	}
	
	/**
	 * 获取SessionId
	 * @param request
	 * @return
	 */
	public static String GetSessionId(HttpServletRequest request) {
		String sessionId = "";
		try {
			if(request != null) {
				sessionId = request.getRequestedSessionId();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionId;
	}
	
	/**
	 * 获取UserAgent
	 * @param request
	 * @return
	 */
    public static String GetUserAgentString(HttpServletRequest request) {
		if(request == null || request.getHeader("User-Agent") == null) {
			 return "";
		}
		return request.getHeader("User-Agent");  
    }
	
    /**
     * 获取UserAgent对象
     * @param userAgentString
     * @return
     */
    public static UserAgent GetUserAgent(String userAgentString){
    	if(StringUtils.isBlank(userAgentString)){
    		return null;
    	}
    	return UserAgent.parseUserAgentString(userAgentString);   
    }
    
    /**
     * 获取手机型号
     * @param userAgentString
     * @return
     */
    public static String GetMobileModel(String userAgentString) {
    	if(StringUtils.isBlank(userAgentString)){
    		return "";
    	}
    	Pattern pattern = Pattern.compile(";\\s?(\\S*?\\s?\\S*?)\\s?(Build)?/");
        Matcher matcher = pattern.matcher(userAgentString);
        String model = "";
        if(matcher.find()) {    
            model = matcher.group(1).trim();      
        }  
		return model;  
    }
    
    
	/**
	 * 获取参数
	 * @return
	 */
    public static String getParamers(){
    	return getParamers(getRequest());
    }
	
    /**
     * 获取参数
     * @return
     */
    public static String getParamers(HttpServletRequest request)
    {
        String result = "";
        try
        {
            if (request != null)
            {
            	StringBuffer sb = new StringBuffer();
            	Enumeration enu = request.getParameterNames();
            	while(enu.hasMoreElements()){  
	            	String paraName=(String)enu.nextElement();
	            	sb.append(paraName+": "+request.getParameter(paraName) + ",");	            	
            	}
            	result = sb.toString().trim();
            }
        }
        catch (Exception ex)
        {            
        }
        return result;
    }
    
    /**
     * 获取参数存到paramsMap
     * @return
     */
    public static void getParamersMap(HttpServletRequest request, Map<String, Object> params)
    {     
        try
        {
            if (request != null)
            {
        		Map<String, String[]> paramsMap = request.getParameterMap();
        		String value = "";
        		for (String key : paramsMap.keySet()) {
        			String[] values = paramsMap.get(key);
        			for (int i = 0; i < values.length; i++) {
        				if(!params.containsKey(key) || params.get(key) == null  || params.get(key) == "") {
        					value = (values[i] != null ? StringUtils.trim(values[i]) : ""); 
        					params.put(key, value);
        				}
        			}
        		}
            }
        }
        catch (Exception ex)
        {            
        }
    }    
    
    /**
     * 自测用例
     * @param args
     */
    public static void main(String[] args) {
    	Boolean isNewVersion = null;
		String requestAppVersion = "6.2.5.0626";
		String appointAppVersion = "6.2.4.0911";
    	String[] appointVersion = appointAppVersion.split("\\.");
		String[] requestVersion = requestAppVersion.split("\\.");
		if(requestVersion!=null && appointVersion!=null && requestVersion.length>=0 && appointVersion.length>=0) {
			int smallSize = appointVersion.length<=requestVersion.length ? appointVersion.length : requestVersion.length;
			for (int i = 0; i < smallSize; i++) {
				if(Integer.parseInt(!"".equals(requestVersion[i].trim())?requestVersion[i].trim():"0")
					> Integer.parseInt(!"".equals(appointVersion[i].trim())?appointVersion[i].trim():"0")) {
					isNewVersion = true;
					System.out.println("新版本");
					break;
				}else if(Integer.parseInt(!"".equals(requestVersion[i].trim())?requestVersion[i].trim():"0")
					== Integer.parseInt(!"".equals(appointVersion[i].trim())?appointVersion[i].trim():"0")) {
					isNewVersion = null;
					System.out.println("不确定新版本");
					continue;
				}else {
					break;
				}
			}
			isNewVersion = (isNewVersion!=null && isNewVersion) || (isNewVersion==null && requestVersion.length>appointVersion.length 
					&& !"0".equals(requestVersion[smallSize]))? true : false;
		}
		System.out.println("是否新版本：" + isNewVersion);
    }
}
