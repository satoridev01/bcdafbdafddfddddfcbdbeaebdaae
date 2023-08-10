package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountDetails;
import service.AmountDetails;

@WebServlet(urlPatterns= {"/jspservlet-app-ATM/balance"})
public class BalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BalanceServlet() {
        super();
      
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
		int pin =Integer.parseInt(request.getParameter("pin"));
		String click = request.getParameter("click");
		
		AccountDetails account = new AccountDetails(accountType,0,amtavl,pin); 
		
		AmountDetails amtdetails = new AmountDetails();
		
		double balance = amtdetails.accountBalance(account.getAvailableBalance());
		
		if(click != null) {
			System.out.println(balance);
			request.setAttribute("balamt", balance);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	
}
