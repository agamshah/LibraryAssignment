package com.montran.action;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.IssueDetailsDAO;
import com.montran.form.IssueDetailsForm;
import com.montran.pojo.Book;
import com.montran.pojo.IssueDetails;
import com.montran.pojo.Member;

public class IssueNewBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		IssueDetailsForm detailsForm = (IssueDetailsForm) form;
		IssueDetailsDAO issueDetailsDAO = new IssueDetailsDAO();
		Member member = null;
		Book book = null;
		IssueDetails details = null;

		
		if (request.getParameter("member") != null) {
			if (request.getParameter("member").equals("getMember")) {
				System.out.println("getMember Button Clicked");
				System.out.println(detailsForm.getMemberCode());
				member = issueDetailsDAO.getMemberByMemberCode(detailsForm.getMemberCode());
				detailsForm.setMemberName(member.getMemberName());
				return mapping.findForward("book");
			}
		}
		if (request.getParameter("book") != null) {
			if (request.getParameter("book").equals("getBook")) {
				System.out.println("getBook Button Clicked");
				System.out.println(detailsForm.getBookCode());
				book = issueDetailsDAO.getBookByBookCode(detailsForm.getBookCode());
				detailsForm.setAuthor(book.getAuthor());
				detailsForm.setTitle(book.getTitle());

				LocalDate issueDate = LocalDate.now();
				LocalDate returnDate = LocalDate.now();

				member = issueDetailsDAO.getMemberByMemberCode(detailsForm.getMemberCode());
				detailsForm.setMemberName(member.getMemberName());

				if (member.getMemberType().equals("student")) {
					returnDate = returnDate.plusDays(8);
					System.out.println(detailsForm);
				}
				if (member.getMemberType().equals("faculty")) {
					returnDate = returnDate.plusDays(90);
					System.out.println(detailsForm);
				}

				detailsForm.setIssueDate(issueDate.toString());
				detailsForm.setReturnDate(returnDate.toString());
				System.out.println("--------------------------------------");
				System.out.println(detailsForm);

				HttpSession httpSession = request.getSession();

				httpSession.setAttribute("member", member);
				httpSession.setAttribute("book", book);
				httpSession.setAttribute("issueDate", issueDate);
				httpSession.setAttribute("returnDate", returnDate);
				return mapping.findForward("member");
			}
		}
		if (request.getParameter("issue") != null) {
			if (request.getParameter("issue").equals("issueBook")) {
				System.out.println("Issue Book Button Click");
				HttpSession httpSession = request.getSession();
				LocalDate issueDate = null;
				LocalDate returnDate = null;

				if (httpSession.getAttribute("book") != null)
					book = (Book) httpSession.getAttribute("book");
				if (httpSession.getAttribute("member") != null)
					member = (Member) httpSession.getAttribute("member");
				if (httpSession.getAttribute("issueDate") != null)
					issueDate = (LocalDate) httpSession.getAttribute("issueDate");
				if (httpSession.getAttribute("returnDate") != null)
					returnDate = (LocalDate) httpSession.getAttribute("returnDate");

				Random random = new Random();
				Date issueD = Date.from(issueDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
				Date returnD = Date.from(returnDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				details = new IssueDetails(detailsForm.getIssueCode(), issueD, returnD, book, member);
				issueDetailsDAO.issueNewBook(details);
				System.out.println("Book Issued Successfully !!");
			}
		}

		return mapping.findForward("success");
	}
}
