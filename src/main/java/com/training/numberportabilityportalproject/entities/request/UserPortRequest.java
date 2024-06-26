package com.training.numberportabilityportalproject.entities.request;


import java.time.LocalDate;
import com.training.numberportabilityportalproject.entities.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserPortRequest {

	private Integer customerId;
	private LocalDate requestDate;
	
}