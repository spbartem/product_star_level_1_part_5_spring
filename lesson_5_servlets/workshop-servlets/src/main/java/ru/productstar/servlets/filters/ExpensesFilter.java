package ru.productstar.servlets.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.productstar.servlets.service.CheckLogin;

import java.io.IOException;

public class ExpensesFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        var context = req.getServletContext();
        context.log("[ExpensesFilter] doFilter");

        if (!CheckLogin.isAuthorized((HttpServletRequest) req, (HttpServletResponse) resp)) {return;}

        int freeMoney = (int) context.getAttribute("freeMoney");
        for (var k : req.getParameterMap().keySet()) {
            if (req.getParameter(k).equals("")) { throw new NullPointerException("Expense is empty"); }
            int value = Integer.parseInt(req.getParameter(k));
            freeMoney -= value;
            if (freeMoney < 0) {
                resp.getWriter().println("Not enough money");
                return;
            }
        }

        chain.doFilter(req, resp);
    }
}
