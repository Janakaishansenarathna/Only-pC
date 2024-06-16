/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ManufacturerDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //get manufacturer id using url parameters
        String manufacturerId = request.getParameter("manufacturer_id");
        Dbcon dbConnector = new Dbcon();
        try {
            dbConnector.connect();
            //delete manufaturer that have manufacturerid of recived parameter from manufacturer table
            String query = "DELETE FROM manufacturer WHERE manufacturer_id = ?";
            dbConnector.executePreparedStatement(query, manufacturerId);
            dbConnector.disconnect();
            out.println("Success");
        } catch (ClassNotFoundException | SQLException ex) {
            out.println("Exception occurred: " + ex.getMessage());
        }
    }
}
