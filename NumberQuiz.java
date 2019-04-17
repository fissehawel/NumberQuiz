import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/NumberQuiz"})
public class NumberQuiz extends HttpServlet {

    private static int qsNum = 0;        // Question Number;
    private static Quiz[] quizs = new Quiz[5];
    private static int score = 0;

      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

            String num1 = "1.0";
            String num2 = "1.0";
            String num3 = "1.0";
            String num4 = "1.0";

            out.println(" <h2> The Number Quiz</h2>");
            out.println("<form action='NumberQuiz'>");
            out.println(" <p> Your current score is" + score + " </p>");
            out.println();

            out.println(" <p> Guess the next number </p>");
            out.println(" <p> " + quizs[0] + " </p>");
            out.println();
            out.print(" <p><label>Your answer <input type=\"text\" name=\"answer\" size = \"10\" > </label></p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
