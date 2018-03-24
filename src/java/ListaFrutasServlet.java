
import com.sun.xml.ws.policy.privateutil.PolicyUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/index.html"})
public class ListaFrutasServlet extends HttpServlet {

    private List<String> frutas;

    public ListaFrutasServlet() {
        frutas = new ArrayList<String>();
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Limao");
        frutas.add("Maca");
        frutas.add("Maracuja");
        frutas.add("Abacaxi");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String comand = "alfa";
            comand = request.getParameter("comando");

            if("alfa".equals(comand)){
                Collections.sort(frutas);        
            }
            if ("rand".equals(comand)){
                Collections.shuffle(frutas);
            }
            
        
            response.setContentType("text/html;charset=UTF-8");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pessoas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");            

            for (String frutas : frutas) {
                out.println("<li>" + frutas + "</li>");
            }
            
            out.println("</ul>");
            out.println("<a href = '?comando=alfa'>Ordem Alfabetica</a><BR>");            
            out.println("<a href = '?comando=rand'>Ordem Aleatória</a><BR>");
            out.println("<a href = '?comando=qtdletras'>Ordem Tamanho Palavra</a><BR>");
            out.println("</body>");
            out.println("</html>");
        }       
        

    }
    
    

}
