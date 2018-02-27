package be.vdab.servlets;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.repositories.PizzaRepository;

/**
 * Servlet implementation class PizzasServlet
 */
@WebServlet("/pizzas.htm")
public class PizzasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/pizzas.jsp";   
    private final PizzaRepository pizzaRepository = new PizzaRepository();
    private static final String PIZZAS_REQUESTS = "pizzasRequests";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzasServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	this.getServletContext().setAttribute(PIZZAS_REQUESTS, new AtomicInteger());
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	((AtomicInteger) this.getServletContext().getAttribute(PIZZAS_REQUESTS)).incrementAndGet();
    			request.setAttribute("pizzas", pizzaRepository.findAll());
    			request.getRequestDispatcher(VIEW).forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
