package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class LoanDetails {
	
	@Id
	@SequenceGenerator(name="mysequence", initialValue=567893)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mysequence")
	private Long loanappno;
	private Long accno;
	private String employment;
	private String business;
	private String experience;
	private BigDecimal income;
	private String carmodel;
	private BigDecimal amount;
	private Long creditscore;
	private String tenure;
	private String status;
	
	public Long getLoanappno() {
		return loanappno;
	}
	public void setLoanappno(Long loanappno) {
		this.loanappno = loanappno;
	}
	public Long getAccno() {
		return accno;
	}
	public void setAccno(Long accno) {
		this.accno = accno;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(Long creditscore) {
		this.creditscore = creditscore;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "LoanDetails [loanappno=" + loanappno + ", accno=" + accno + ", employment=" + employment + ", business="
				+ business + ", experience=" + experience + ", income=" + income + ", carmodel=" + carmodel
				+ ", amount=" + amount + ", creditscore=" + creditscore + ", tenure=" + tenure + ", status=" + status
				+ "]";
	}
	public LoanDetails(Long loanappno, Long accno, String employment, String business, String experience,
			BigDecimal income, String carmodel, BigDecimal amount, Long creditscore, String tenure, String status) {
		super();
		this.loanappno = loanappno;
		this.accno = accno;
		this.employment = employment;
		this.business = business;
		this.experience = experience;
		this.income = income;
		this.carmodel = carmodel;
		this.amount = amount;
		this.creditscore = creditscore;
		this.tenure = tenure;
		this.status = status;
	}
	public LoanDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(accno, amount, business, carmodel, creditscore, employment, experience, income, loanappno,
				status, tenure);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanDetails other = (LoanDetails) obj;
		return Objects.equals(accno, other.accno) && Objects.equals(amount, other.amount)
				&& Objects.equals(business, other.business) && Objects.equals(carmodel, other.carmodel)
				&& Objects.equals(creditscore, other.creditscore) && Objects.equals(employment, other.employment)
				&& Objects.equals(experience, other.experience) && Objects.equals(income, other.income)
				&& Objects.equals(loanappno, other.loanappno) && Objects.equals(status, other.status)
				&& Objects.equals(tenure, other.tenure);
	}
}