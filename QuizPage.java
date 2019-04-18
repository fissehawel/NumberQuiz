import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/QuizPage"})
public class QuizPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Quiz quiz = (Quiz)session.getAttribute("quiz");
        response.setContentType("text/html");
        String page = "<html lang = \"en\">\n" +
                "    <head>\n" +
                "      <title>Number Quiz</title>\n" +
                "      <style>\n" +
                "        body{\n" +
                "          \n" +
                "        }\n" +
                "      </style>\n" +
                "    </head>";
        page += " <body>\n" +
                "      <h2> The Number Quiz</h2>\n" +
                "      <form action = \"NumberQuiz\" method = \"post\">\n" +
                "       <p> Your current score is " + quiz.score + " </p>" +
                "       <p> Guess the next number </p>" +
                "       <p> " + quiz.getQuestion()[quiz.index] + " </p>" +
                "       <p><label>Your answer <input type=\"text\" name=\"answer\" size = \"5\" > </label></p>" +
                "        <input type = \"submit\" value = \"Submit\">\n" +
                "      </form>\n" +
                "  </body>\n" +
                "</html>";

        PrintWriter out = response.getWriter();
        out.println(page);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req,resp); // To handle the request using the method doPost()
    }

}
