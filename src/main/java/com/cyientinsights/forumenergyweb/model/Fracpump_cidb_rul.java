/*package com.cyientinsights.forumenergyweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="fracpump_cidb_rul")
public class Fracpump_cidb_rul {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Machine_id")
	String Machine_id;
	
	@Column
	float Data_taken_till;
	@Column
	float Duration_hrs;
	@Column
	float EoL_date;
	@Column
	float Health;
	@Column
	String LogDateTime;
	@Column
	float ROD_per_day__;
	@Column
	float RUL_max;
	@Column
	float RUL_mean;
	@Column
	float RUL_min;
	@Column
	float Runtime_per_day_hrs;
	public Fracpump_cidb_rul(String machine_id, float data_taken_till, float duration_hrs, float eoL_date, float health,
			String logDateTime, float rOD_per_day__, float rUL_max, float rUL_mean, float rUL_min,
			float runtime_per_day_hrs) {
		
		Machine_id = machine_id;
		Data_taken_till = data_taken_till;
		Duration_hrs = duration_hrs;
		EoL_date = eoL_date;
		Health = health;
		LogDateTime = logDateTime;
		ROD_per_day__ = rOD_per_day__;
		RUL_max = rUL_max;
		RUL_mean = rUL_mean;
		RUL_min = rUL_min;
		Runtime_per_day_hrs = runtime_per_day_hrs;
	}
	@Override
	public String toString() {
		return "Fracpump_cidb_rul [Machine_id=" + Machine_id + ", Data_taken_till=" + Data_taken_till
				+ ", Duration_hrs=" + Duration_hrs + ", EoL_date=" + EoL_date + ", Health=" + Health + ", LogDateTime="
				+ LogDateTime + ", ROD_per_day__=" + ROD_per_day__ + ", RUL_max=" + RUL_max + ", RUL_mean=" + RUL_mean
				+ ", RUL_min=" + RUL_min + ", Runtime_per_day_hrs=" + Runtime_per_day_hrs + "]";
	}
	
}
*/