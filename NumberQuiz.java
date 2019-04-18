import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/NumberQuiz")

public class NumberQuiz extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
        if(quiz.index == 4){
            
             int ans = Integer.valueOf(request.getParameter("answer"));
             if(ans == quiz.getAnswer()[quiz.index]) {
                 quiz.score++;
             }

             response.setContentType("text/html");
            String page = "<html lang = \"en\">\n" +  "    <head>\n" +
                    "      <title>Number Quiz</title>\n" +
                    "      <style>\n" +
                            "        body{margin: 20px;\n" +
                            "          \n" +
                            "        }\n" +
                            "   .content {" +
                            "       width: 350px;    " +
                            "       padding: 10px;" +
                            "       border: 1px solid black" +
                            "}" +
                            "      </style>\n" +
                            "    </head>";
                    page += " <body>\n" +
                            "   <div class = 'content'>" +
                            "      <h2> The Number Quiz</h2>\n" +
                    "      <form action = \"NumberQuiz\" method = \"post\">\n" +
                    "       <p> Your current score is " + quiz.score + " </p>" +
                    "       <p> You have completed the Number Quiz, with a score of " + quiz.score + " out of 5 </p>" +
                    "      </form>\n" +
                    "     </div>" +
                    "  </body>\n" +
                    "</html>";

            PrintWriter out = response.getWriter();
            out.println(page);

        } else{
            int ans = Integer.valueOf(request.getParameter("answer"));
            if(ans == quiz.getAnswer()[quiz.index]) {
                quiz.score++;
            }
            quiz.index++;
            request.getRequestDispatcher("QuizPage").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("quiz", new Quiz());
        request.getRequestDispatcher("QuizPage").forward(request, response);

    }
}
