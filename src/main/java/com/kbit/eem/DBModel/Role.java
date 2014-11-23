package com.kbit.eem.DBModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

import com.kbit.eem.DBModel.util.BaseAuditEntity;
import com.kbit.eem.DBModel.util.DBConstants;

@Entity
@Table(name = "ROLES", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "ROLES_SEQ")
public class Role extends BaseAuditEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Column(name = "NAME", length = 20, unique=true)
	@NotNull
	private String name;
	
	public Role(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*@ManyToOne
	private User user;*/

	@Override
	public String getAuthority() {
		return this.name;
	}
}
