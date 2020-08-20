package com.montran.pojo;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "book_issue_master")
public class IssueDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_issue_gen")
	//@SequenceGenerator(sequenceName = "book_issue_sequence", name = "book_issue_gen")
	@Column(name = "book_issue")
	private int issueCode;

	@Column(name = "date_of_issue")
	private Date issueDate;

	@Column(name = "date_of_return")
	private Date returnDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_code")
	private Book book;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_code")
	private Member member;

	public IssueDetails() {
		// TODO Auto-generated constructor stub
	}

	public IssueDetails(int issueCode, Date issueDate, Date returnDate, Book book, Member member) {
		super();
		this.issueCode = issueCode;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.book = book;
		this.member = member;
	}

	public int getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(int issueCode) {
		this.issueCode = issueCode;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "IssueDetails [issueCode=" + issueCode + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", book=" + book + ", member=" + member + "]";
	}

}
