package com.millervein.scorecard.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	@Query(value = "SELECT COUNT(id) FROM appointment " + "WHERE date BETWEEN :startDate AND :endDate "
			+ "AND type = :type ", nativeQuery = true)
	public Integer countAppointmentsByDateRangeType(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("type") String type);
	
	@Query(value = "SELECT COUNT(id) FROM appointment " + "WHERE date BETWEEN :startDate AND :endDate "
			+ "AND type = :type " + "AND department = :department", nativeQuery = true)
	public Integer countAppointmentsByDateRangeTypeAndDepartment(@Param("startDate") String startDate,
			@Param("endDate") String endDate, @Param("type") String type, @Param("department") String department);

}
