package com.nagarro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hr_manager")
public class HR {
	@Id
	@Column(name = "HR_id")
	private String hrId;

	@Column(name = "HR_pswd")
	private String hrPswd;

	public String getHrId() {
		return hrId;
	}

	public HR(String hrId, String hrPswd) {
		this.hrId = hrId;
		this.hrPswd = hrPswd;
	}

	public HR() {
	}

	public void setHrId(String hrId) {
		this.hrId = hrId;
	}

	public String getHrPswd() {
		return hrPswd;
	}

	public void setHrPswd(String hrPswd) {
		this.hrPswd = hrPswd;
	}
}
