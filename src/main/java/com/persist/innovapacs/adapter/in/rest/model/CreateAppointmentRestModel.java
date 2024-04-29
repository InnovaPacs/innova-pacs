package com.persist.innovapacs.adapter.in.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class CreateAppointmentRestModel {
	String id;
	String patientId;
	String physicianId;
	String studyId;
	String medicalOfficeId;
	LocalDate appointmentDate;
	LocalTime appointmentTime;
	String purpose;
	String status;
	String controlNumber;
	StudyRestModel study;
}
