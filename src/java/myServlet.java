

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alunocmc
 */
@WebServlet(urlPatterns = {"/myServlet"})
public class myServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private String notaMedia(double media) {
           if (media < 3) {
               return "reprovado!";
           } else if (media >= 3 && media <= 5) {
               return "exame";
           } else {
               return "aprovado";
           }
       }
        
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        double n1 = Double.parseDouble(request.getParameter("nota1"));
        double n2 = Double.parseDouble(request.getParameter("nota2"));
        double n3 = Double.parseDouble(request.getParameter("nota3"));
        
        double media = (n1 + n2 + n3) / 3;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CALCULADORA GUILHERME MARTINS</title>");  
            
            out.println("<style>");
            out.println("body {");
            out.println("  text-align: center;");
            out.println("  margin: 0;");
            out.println("  color: #000;");
            out.println("  font-family: Arial, sans-serif;");
            out.println("  background-image: url('imgs/corinthians.jpg');");
            out.println("  background-size: cover;");
            out.println("}");
                
                
            out.println("h1 {");
            out.println(" font-size: 50px;");
            out.println(" text-transform: uppercase;");
            out.println("}");
            out.println("</style>");
            
            
            
            out.println("</head>");         
            
            
            out.println("<body>");
            out.println("<h1> Media do Semestre</h1>");
            out.println("<h2> Sua media foi : " + media +  "</h2>");
            out.println("<h2> Seu resultado foi :" + notaMedia(media) +  "</h2>");
            out.println("</body>");
            out.println("</html>");
            
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
