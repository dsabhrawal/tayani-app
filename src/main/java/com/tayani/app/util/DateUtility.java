package com.tayani.app.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public final class DateUtility {
	
	
	public static LocalDate convertUtilDateToLocalDate(Date utilDate){
		
		
		// For more info : http://stackoverflow.com/questions/21242110/convert-java-util-date-to-java-time-localdate
		Instant instant = utilDate.toInstant();
		ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		LocalDate localDate = zdt.toLocalDate();
		
		return localDate;
		
	}
	
	public static Date convertLocalDateToUtilDate(LocalDate localDate){
		
		
		// For more info : http://stackoverflow.com/questions/22929237/convert-java-time-localdate-into-java-util-date-type
		Date utilDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		return utilDate;
	}

}
