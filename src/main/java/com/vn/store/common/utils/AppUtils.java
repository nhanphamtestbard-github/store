package com.vn.store.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

@Component
public class AppUtils {
	public static Timestamp convertStringToTimestamp(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return new Timestamp ((dateFormat.parse(date)).getTime());
	}
}
