package com.seng4400;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Controller servlet class used to implement the GET functionality request and retrieve all answers and times and
 * write them to the web page to see all the results.
 *
 * @author  Sean Crocker
 * @version 1.0
 * @since   01/06/2022
 */
@WebServlet(name = "Controller", value = "/_ah/api/echo/v1/answer")
public class Controller extends HttpServlet {

    /**
     * The function that implements the servlet get request functionality which retrieves the list of documents from the
     * firestore database and calls the print output function to write all the results to the web page.
     *
     * @param request       The http servlet request
     * @param response      The http servlet response
     * @throws IOException  Throws exception if the response writer is unavailable
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            FirestoreOptions firestoreOptions = FirestoreOptions.getDefaultInstance();
            Firestore db = firestoreOptions.getService();
            ApiFuture<QuerySnapshot> query = db.collection("Answer").get();
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            printOutput(documents, response);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function responsible for printing the web page displaying the table of results where one column features the
     * answers and the other has the times. The refresh header is also set to a value of one to refresh the page every
     * second.
     *
     * @param documents     The list of query document snapshots which contain the answer values.
     * @param response      The http servlet response
     * @throws IOException  Throws exception if the response writer is unavailable
     */
    private void printOutput(List<QueryDocumentSnapshot> documents, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");                // Set the context type
        response.setIntHeader("Refresh", 1);           // Set the refresh header to refresh every second
        PrintWriter printWriter = response.getWriter();     // Get the response writer the print the web page

        printWriter.print("<!DOCTYPE html>");
        printWriter.print("<html lang='en'>");
        printWriter.print("<body>");
        printWriter.print("<table>");
        for (QueryDocumentSnapshot document : documents) {
            printWriter.print("<tr>");
            printWriter.print("<td>"+document.get("answer")+"</td>");
            printWriter.print("<td>"+document.get("time_taken")+"</td>");
            printWriter.print("</tr>");
        }
        printWriter.print("</table>");
        printWriter.print("</body>");
        printWriter.print("</html>");
    }
}
