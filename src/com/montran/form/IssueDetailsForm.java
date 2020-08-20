package com.montran.form;

import java.time.LocalDate;

import org.apache.struts.action.ActionForm;

import com.montran.pojo.Book;
import com.montran.pojo.Member;

public class IssueDetailsForm extends ActionForm {
	private int issueCode;
	private int memberCode;
	private String memberName;
	private int bookCode;
	private String title;
	private String author;
	private String issueDate;
	private String returnDate;

	public int getIssueCode() {
		return issueCode;
	}

	public void setIssueCode(int issueCode) {
		this.issueCode = issueCode;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getBookCode() {
		return bookCode;
	}

	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "IssueDetailsForm [issueCode=" + issueCode + ", memberCode=" + memberCode + ", memberName=" + memberName
				+ ", bookCode=" + bookCode + ", title=" + title + ", author=" + author + ", issueDate=" + issueDate
				+ ", returnDate=" + returnDate + "]";
	}

}
