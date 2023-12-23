package com.product.Model;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
 public class Categeory {


		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(nullable = false)
		@Size(min =2,max = 10,message = "name should contain between 3 to 10 characters")
		private String categoryName;

		@Column(nullable = false)
		@Size(min =2,max = 10,message = "name should contain between 3 to 10 characters")
	    @NotNull(message = "type is required")
		private String description;
		
		@Column(nullable = false)
		@Size(min =1,max = 5,message = "name should contain between 3 to 10 characters")
	    @NotNull(message = "type is required")
		private String ratings;
		
		@CreatedDate
		private Instant CreatedAt;
		
		@LastModifiedDate
		private Instant UpdatedAt;
		
		@OneToMany(mappedBy = "category")
		@JsonIgnore
        private  List<Product> product;
		
		
	

		
}
