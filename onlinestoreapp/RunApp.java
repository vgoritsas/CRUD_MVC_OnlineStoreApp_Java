package onlinestoreapp;

import onlinestoreapp.controller.Controller;
import onlinestoreapp.model.Model;

import onlinestoreapp.view.View;

public class RunApp {

    public static void main(String[] args) {
        
        Model model = new Model(); // create object  Model
        View view = new View(model); // create object  view and gets as input the model
        Controller controller = new Controller(model, view); // create object controller and gets as inputs  view & model where create up
        controller.view(); // controller call method view from Controller class.
      
    }
    

}
