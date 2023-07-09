package com.micro1service.user.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rating {
	
	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	private String feedback;

}
