package project2.agent;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Project2Agent  {

    public static void main(String[] args) {
        jade.core.Runtime r = jade.core.Runtime.instance();
        Profile p = new ProfileImpl("localhost", 1010, "testLocal");
        ContainerController main = r.createMainContainer(p);
        try {
            AgentController gui = main.createNewAgent("gui", "jade.tools.rma.rma", null);
            gui.start();
            AgentController sender = main.createNewAgent("sender", "project2.agent.sende2", null);
            sender.start();
            AgentController reciever = main.createNewAgent("reciever", "project2.agent.reciever2", null);
            reciever.start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Project2Agent.class.getName()).log(Level.SEVERE, null, ex);
        }

      //  launch(args);
    }
/*
    @Override
 
    public void start(Stage primaryStage) throws Exception {
        FlowPane p =new FlowPane(30,20);
        p.setAlignment(Pos.CENTER);
        Button b1 =new Button("Translate");
        TextField tf1=new TextField("English");
        TextField tf2=new TextField("Arabik");
        p.getChildren().add(b1);
        p.getChildren().add(tf1);
        p.getChildren().add(tf2);
        b1.setOnAction(e->{
        sende2.word=tf1.getText();
       tf2.setText( reciever2.content);
        
        });
        
        
        ////////////////////////////
        Scene sc=new Scene(p,700,700);
        primaryStage.setTitle("Transaltor");
        primaryStage.setScene(sc);
        
        
        
    
    }
*/

}
