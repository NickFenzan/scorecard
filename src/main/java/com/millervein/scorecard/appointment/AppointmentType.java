package com.millervein.scorecard.appointment;

import java.util.Arrays;

public enum AppointmentType {
	FREE, NEW, FOLLOWUP, PROCEDURE, VEINERASE, OTHER;
	private static String[] freeTypes = new String[] { "Free Evaluation" };
	private static String[] newTypes = new String[] { "Established Full Consult", "New Patient" };
	private static String[] followupTypes = new String[] { "3 Month Follow Up", "6 Month Follow Up",
			"Yearly Follow Up" };
	private static String[] procedureTypes = new String[] { "EVTA", "EVTA MP", "Microphlebectomy", "MOCA", "Varithena",
			"VenaSeal" };
	private static String[] veineraseTypes = new String[] { "VeinErase - Facial", "VeinErase Legs", "VeinErase MESSA",
			"VeinErase Petitie", "VeinErase Special" };
	@SuppressWarnings("unused")
	private static String[] otherTypes = new String[] { "1 Week", "DVT Study", "EVCA", "FOLLOW UP",
			"Incision and Drainage", "Medical Sclero", "Office Visit", "Ultrasound", "VeinErase Short Term Follow Up",
			"VVEVCA" };

	static public AppointmentType fromString(String string) {
		if (isType(freeTypes, string)) {
			return AppointmentType.FREE;
		} else if (isType(newTypes, string)) {
			return AppointmentType.NEW;
		} else if (isType(followupTypes, string)) {
			return AppointmentType.FOLLOWUP;
		} else if (isType(procedureTypes, string)) {
			return AppointmentType.PROCEDURE;
		} else if (isType(veineraseTypes, string)) {
			return AppointmentType.VEINERASE;
		} else {
			return AppointmentType.OTHER;
		}
	}
	
	static private boolean isType(String[] types, String string){
		return (Arrays.binarySearch(types, string) >= 0);
	}
}
