package onlinestoreapp.controller;

import java.sql.SQLException;

import onlinestoreapp.model.Model;
import onlinestoreapp.view.View;

public class Controller {

    /**
      *Model model & View view variables from the class model & view, and provided Will be the main object can call any method from
      Class model & view
     */
    private Model model;
    private View view;

    // στον constructor περνάω 2 input το model και το view.
    public Controller(Model model, View view) {
        // initialize the variables 
        this.model = model;
        this.view = view;
    }
  
    public void view() {
        /**
         * If became in the main object the view. Calls from Class view the 
         method generalView. eg view = new View (); view.generalView (); instead 
         doing here object to this method has already been done by the main.
         */
        view.generalView(); // call generalView method from the View class 
    }

}
