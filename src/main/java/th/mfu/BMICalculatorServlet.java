package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet(urlPatterns = "/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        
        Double height = Double.parseDouble(request.getParameter("height"));
        Double weight = Double.parseDouble(request.getParameter("weight"));
        
        //TODO: calculate bmi

        Double BMI = weight/(height*height);
        long BMIint = Math.round(BMI);

        //TODO: determine the built from BMI

        String type = "";
        if(BMIint < 18.5)
        {
            type = "underweight";
        }
        if(BMIint >= 18.5 && BMIint < 25)
        {
            type = "normal";
        }
        if(BMIint >= 25 && BMIint < 30)
        {
            type = "overweight";
        }
        if(BMIint >= 30 && BMIint < 35)
        {
            type = "obese";
        }
        if(BMIint >= 35)
        {
            type = "extremely obese";
        }
      
        //TODO: add bmi and built to the request's attribute

        request.setAttribute("BMIint", BMIint);
        request.setAttribute("type", type);

        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
    }
    
}
