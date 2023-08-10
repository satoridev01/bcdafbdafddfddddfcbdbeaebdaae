package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountDetails;
import service.AmountDetails;

@WebServlet(urlPatterns= {"/jspservlet-app-ATM/deposit"})
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Entering do get");
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String accountType = request.getParameter("account-type");
		double amtavl = 2000;
		double deptamt = Double.parseDouble(request.getParameter("amount"));
		int pin =Integer.parseInt(request.getParameter("pin"));
		String click = request.getParameter("click");
		
		AccountDetails account = new AccountDetails(accountType,deptamt,amtavl,pin); 
		
		AmountDetails amtdetails = new AmountDetails();
		
		double balance = amtdetails.depositAmount(account.getWithdrawOrDepositAmount(), account.getAvailableBalance());
		
		if(click != null) {
			request.setAttribute("message", balance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
