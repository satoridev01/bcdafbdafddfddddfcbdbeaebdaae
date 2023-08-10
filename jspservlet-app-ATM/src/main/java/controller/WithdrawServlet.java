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

@WebServlet(urlPatterns= {"/jspservlet-app-ATM/withdraw"})
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WithdrawServlet() {
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
		PrintWriter out = response.getWriter();
		
		String accountType = request.getParameter("account-type");
		double amtavl = 2000;
		double withamt = Double.parseDouble(request.getParameter("amount"));
		int pin =Integer.parseInt(request.getParameter("pin"));
		String click = request.getParameter("click");
		
		AccountDetails account = new AccountDetails(accountType,withamt,amtavl,pin); 
		
		AmountDetails amtdetails = new AmountDetails();
		
		double balance = amtdetails.withdrawAmount(account.getWithdrawOrDepositAmount(), account.getAvailableBalance());;
		
		if(click != null) {
			if(account.getWithdrawOrDepositAmount()<=account.getAvailableBalance()) {
				request.setAttribute("message", balance);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
			
			else {
				response.setContentType("text/html");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('amount enter is out of available balance');");
				out.println("</script>");
//				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
//				dispatcher.forward(request, response);
			}
		}
	}

}
