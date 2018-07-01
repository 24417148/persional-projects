package com.zyl.cases.log;

import ch.qos.logback.classic.PatternLayout;

/**
 * @author lht on 2017/10/16.
 * @version 1.0
 */
public class MyPatternLayout extends PatternLayout {
	static {
		defaultConverterMap.put("ip", IpConvert.class.getName());
	}
}
