package servlets;

import http.HttpDataGetter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/httpGetBaseServlet")
public class httpGetBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String s = new HttpDataGetter("https://androidserver1.000webhostapp.com/?action=base").getData();
        HttpSession session = request.getSession();
        resp.getWriter().write(s);

    }


}
