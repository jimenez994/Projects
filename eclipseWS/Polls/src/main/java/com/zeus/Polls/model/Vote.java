package com.zeus.Polls.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.zeus.Polls.model.audit.DateAudit;

import lombok.Data;

@Entity
@Table(name = "votes", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"poll_id",
				"user_id"
		})
})
@Data
public class Vote extends DateAudit{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poll_id", nullable = false)
	private Poll poll;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "choice_id", nullable = false)
	private Choice choice;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
}
