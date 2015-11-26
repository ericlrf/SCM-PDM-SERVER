package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Java responsavel por tratar as requisicoes HTTP originadas da
 * aplicacao Android para dispositivos moveis
 */
public class TaxasCambio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("{\n" +
"    \"taxa\":{\n" +
"        \"compra\":3.7380,\n" +
"        \"venda\":3.7386\n" +
"    },\n" +
"    \"paridade\":{\n" +
"        \"compra\":1.0000,\n" +
"        \"venda\":1.0000\n" +
"    },\n" +
"    \"moeda\":{\n" +
"        \"codigo\":220,\n" +
"        \"tipo\":\"A\",\n" +
"        \"nome\":\"Dolar dos EUA\"\n" +
"        },\n" +
"    \"pais\":{\n" +
"        \"codigo\":2496,\n" +
"        \"nome\":\"Estados Unidos\"\n" +
"    }\n" +
"}\n" +
"");
        }
        System.out.println("-> o host {" + request.getRemoteHost() + "} fez a requisição {" + request.getQueryString() + "} em {" + new Date(System.currentTimeMillis()) + "} <-");
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

}
