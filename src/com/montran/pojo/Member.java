package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "member_master")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_code")
	private int memberCode;

	@Column(name = "member_type")
	private String memberType;

	@Column(name = "member_name")
	private String memberName;

	@Column(name = "no_of_copies")
	private String numberOfCopiesIssued;

	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(int memberCode, String memberType, String memberName, String numberOfCopiesIssued) {
		super();
		this.memberCode = memberCode;
		this.memberType = memberType;
		this.memberName = memberName;
		this.numberOfCopiesIssued = numberOfCopiesIssued;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getNumberOfCopiesIssued() {
		return numberOfCopiesIssued;
	}

	public void setNumberOfCopiesIssued(String numberOfCopiesIssued) {
		this.numberOfCopiesIssued = numberOfCopiesIssued;
	}

	@Override
	public String toString() {
		return "Member [memberCode=" + memberCode + ", memberType=" + memberType + ", memberName=" + memberName
				+ ", numberOfCopiesIssued=" + numberOfCopiesIssued + "]";
	}

}
