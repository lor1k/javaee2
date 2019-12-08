package servlets;

import http.HttpDataPoster;
import org.ajax4jsf.javascript.JSObject;
import org.openfaces.org.json.JSONObject;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/httpGetFactServlet")
public class httpGetFactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        int num = Integer.parseInt(request.getParameter("num"));

        JsonObject obj = Json.createObjectBuilder().add("num", num).build();
        //JSONObject
        String s = new HttpDataPoster("https://androidserver1.000webhostapp.com/?action=fact", obj).getData();
        resp.getWriter().write(s);
    }
}
