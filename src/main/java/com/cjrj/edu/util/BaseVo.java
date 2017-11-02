package com.cjrj.edu.util;

import java.io.Serializable;

/**
 * 鍩虹VO锛屾鏋朵娇鐢�.
 * @author liuqing
 *
 */
public abstract class BaseVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1169083819505759557L;

	@Override
	public String toString(){
		return ConvertUtil.toJsonString(this);
	}

}
