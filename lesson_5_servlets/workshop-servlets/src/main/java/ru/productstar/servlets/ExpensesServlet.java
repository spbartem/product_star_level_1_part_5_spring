package ru.productstar.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.model.Expense;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExpensesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        context.log("[ExpensesServlet] doGet");

        var expenses = new ArrayList<Expense>((List) context.getAttribute("expenses"));

        int freeMoney = (int) context.getAttribute("freeMoney");
        for (var k : req.getParameterMap().keySet()) {
            int value = Integer.parseInt(req.getParameter(k));
            freeMoney -= value;
            expenses.add(new Expense(k, value));
        }

        context.setAttribute("freeMoney", freeMoney);
        context.setAttribute("expenses", expenses);
        resp.getWriter().println("Expenses were added");
    }
}
