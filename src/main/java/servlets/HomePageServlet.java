package servlets;

import data.GuestBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/s")
public class HomePageServlet extends HttpServlet {
    GuestBook guestBook = new GuestBook();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LocalDateTime time = LocalDateTime.now();
        String name = request.getParameter("name");
        String rating = request.getParameter("rating");
        String message = request.getParameter("message");
        guestBook.putGuestBookEntry(time, name, message, rating);
        request.setAttribute("entries", guestBook.getGuestBookMap());
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }
}

