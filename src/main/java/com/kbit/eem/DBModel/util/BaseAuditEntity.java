package com.kbit.eem.DBModel.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class BaseAuditEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Size(max = 20)
	@Column(name = "UPDATED_BY", length = 20)
	@NotNull
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date updatedOn;

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	/** 
     * Sets createdOn before insert 
     */  
   /* @PrePersist
    @PreUpdate
    public void setUpdatedDate() {  
        this.updatedOn = new Date();  
    }*/
}
