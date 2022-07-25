package uz.jl.javaservlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/calculator")
public class Calculator extends HttpServlet {

    public static final List<String> OPERATORS = List.of("+", "-", "*", "/");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/calculator.html");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String operator = req.getParameter("operator");
        if (validateInput(a, b, operator)) {
            int result = switch (operator) {
                case "+" -> Integer.parseInt(a) + Integer.parseInt(b);
                case "-" -> Integer.parseInt(a) - Integer.parseInt(b);
                case "*" -> Integer.parseInt(a) * Integer.parseInt(b);
                case "/" -> Integer.parseInt(a) / Integer.parseInt(b);
                default -> 0;
            };
            writer.println("<h1>Result is : " + result + "</h1>");
        } else writer.println("invalid input");
    }


    private boolean validateInput(String a, String b, String operator) {
        return Utils.isDigit(a) && Utils.isDigit(b) && OPERATORS.contains(operator);
    }

}
