import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_server")
public class Servlet_server extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException {
        super.init();
        message = "Hello World";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response content
        response.setContentType("text/html");
        //output text
        PrintWriter out = response.getWriter();
        out.write("<h1>"+message+"</h1>");
    }
}
