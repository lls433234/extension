package com.jiuyao.boot.utils.security;

import java.text.ParseException;

public class TimeUtil {

	public static String getTime() throws ParseException{
	    return String.valueOf(System.currentTimeMillis());
	}
}
