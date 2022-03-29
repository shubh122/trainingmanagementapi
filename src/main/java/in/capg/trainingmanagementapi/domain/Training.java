package in.capg.trainingmanagementapi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
public class Training {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String Name;
	@Column(updatable = false, unique = true)
	private String Trainingname;
	@NotBlank(message="description is required")
	@Size(min=1, max=20,message="Please use less than 20 characters")
	private String description;
	@Size(min=4, max=5,message="Please use 4 to 5  characters")
	private String trainingId;
	
	
	private Date start_date;
	private Date end_date;
	private Date created_At;
	private Date updated_At;
	
	public Training() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getTrainingname() {
		return Trainingname;
	}
	public void setTrainingname(String trainingname) {
		Trainingname = trainingname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	@PrePersist
	public void onCreate() {
		this.created_At=new Date();
		
	}
	@PreUpdate
	public void onUpdate() {
		this.updated_At=new Date();
	}

}
