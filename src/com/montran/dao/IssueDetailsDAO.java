package com.montran.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.montran.pojo.Book;
import com.montran.pojo.IssueDetails;
import com.montran.pojo.Member;
import com.montran.util.SessionFactoryUtil;

public class IssueDetailsDAO {

	private Session session;
	private Transaction transaction;
	private int issueSerialNumber;

	public List<IssueDetails> getAllBookIssueDetails() {
		session = SessionFactoryUtil.getFactory().openSession();
		org.hibernate.query.Query query = session.createQuery("from book_issue_master");
		List<IssueDetails> bookIssueList = query.list();
		session.close();
		return bookIssueList;
	}

	public Member getMemberByMemberCode(int memberCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Member member = session.get(Member.class, memberCode);
		System.out.println(member);
		session.close();
		return member;
	}

	public Book getBookByBookCode(int bookCode) {
		session = SessionFactoryUtil.getFactory().openSession();
		Book book = session.get(Book.class, bookCode);
		System.out.println(book);
		session.close();
		return book;
	}

	public void issueNewBook(IssueDetails details) {
		session = SessionFactoryUtil.getFactory().openSession();
		transaction = session.beginTransaction();
		session.save(details);
		transaction.commit();
		session.close();
	}

	
}
