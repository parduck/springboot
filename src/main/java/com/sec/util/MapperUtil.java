package com.sec.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sec.vo.BoardVO;

@Service
public class MapperUtil {
    /*
     * 공통 매퍼
     */
	/*
	 * private Class<T> targetType;
	 * 
	 * public MapperUtil(Class<T> targetType) { this.targetType = targetType; }
	 * 
	 * public List<T> copy(List<S> src) { List<T> target = new ArrayList<T>(); for (
	 * S s : src ) { T t = BeanUtils.instantiateClass(targetType);
	 * BeanUtils.copyProperties(s, t); target.add(t); } return target; }
	 */
    
    public static  <T, S> T domainMapper(S source, T classLiteral) {
    	
    	BeanUtils.copyProperties(source, classLiteral);
    	
    	return (T)classLiteral;
    }
    
    //넘겨주는게 안 된다...
    public static  <T, S> T domainMapper2(S source) {
    	T target = (T) new Object();
    	BeanUtils.copyProperties(source, target);
    	
    	return target;
    }
    
    public static  <T, S> List<T> domainListMapper(List<S> sourceL) {
    	//S source;
    	//T target ;
    	
    	
    //	객체 정의가 안됨.. 그냥 copyProperties 써라..
	    Vector<T> targetList = new Vector<T>();
	    
        return targetList;
	
    }

}
