package edu.servlet;

import edu.bean.UserFolder;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class Servlet extends HttpServlet {
    @EJB
    UserFolder userFolder;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().write("Here are files from a root:");
        resp.getWriter().write(userFolder.revealFiles());
    }
}
