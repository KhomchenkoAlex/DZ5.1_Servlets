package servlets;

import data.GuestBook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/guestbook")
public class HomePageServlet extends HttpServlet {
    GuestBook guestBook = new GuestBook();
    int numOfGuest = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        if (session.isNew())
            numOfGuest++;
        LocalDateTime time = LocalDateTime.now();
        String name = request.getParameter("name");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String message = request.getParameter("message");
        guestBook.putGuestBookEntry(time, name, message, rating);
        request.setAttribute("entries", guestBook.getGuestBookMap());
        request.setAttribute("num", numOfGuest);
        request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
        session.invalidate();
    }
}

