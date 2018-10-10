package br.com.eric.custom;

import java.time.LocalDateTime;

public class Timestamps {

	private LocalDateTime ldt = LocalDateTime.now();
	private String created_at;
	
	private int day;
	private int month;
	private int year;
	
	private int hour;
	private int minute;
	private int second;
	
	public Timestamps() {
		
		this.day = ldt.getDayOfMonth();
		this.month = ldt.getMonthValue();
		this.year = ldt.getYear();
		
		this.hour = ldt.getHour();
		this.minute = ldt.getMinute();
		this.second = ldt.getSecond();
		
		this.created_at = "";
		this.created_at += this.day + " ";
		this.created_at += Month.get(this.month) + " ";
		this.created_at += this.year;
		this.created_at += " ";
		this.created_at += this.hour + ":";
		this.created_at += this.minute + ":";
		this.created_at += this.second;
	
	}
	
	public String toJson() {
		String json = "{\n";
		
		json += "\t";
		json += Custom.marks("day") + ":\t" + this.day + ",\n";
		
		json += "\t";
		json += Custom.marks("month") + ":\t" + this.month + ",\n";
		
		json += "\t";
		json += Custom.marks("year") + ":\t" + this.year + ",\n";
		
		json += "\t";
		json += Custom.marks("hour") + ":\t" + this.hour + ",\n";
		
		json += "\t";
		json += Custom.marks("minute") + ":\t" + this.minute + ",\n";
		
		json += "\t";
		json += Custom.marks("second") + ":\t" + this.second + "\n";
	
		json += "}";
		
		return json;
	}

	public LocalDateTime getLdt() {
		return ldt;
	}

	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public static void main(String []args) {
		Timestamps t = new Timestamps();
		System.out.println(t.created_at);
	}
	
}
