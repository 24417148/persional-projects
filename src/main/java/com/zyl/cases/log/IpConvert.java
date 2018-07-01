package com.zyl.cases.log;

import java.net.InetAddress;
import java.net.UnknownHostException;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

/**
 * @author lht on 2017/10/16.
 * @version 1.0
 */
public class IpConvert extends ClassicConverter {

	@Override
	public String convert(ILoggingEvent arg0) {
		// TODO Auto-generated method stub
		return getIpAddress();
	}

	public static String getIpAddress() {
		String ipAddress = null;
		try {
			ipAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipAddress;
	}
}
