
package project2.agent;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

public class reciever2 extends Agent {
    @Override
    protected void setup(){
    System.out.println("resiever created ");
        System.out.println("the locla name is : "+getAID().getLocalName());
        System.out.println("print contint\n---------------------------");
        addBehaviour(new CyclicBehaviour() {
        @Override
        public void action() {
          ACLMessage aa = receive();
          if(aa!=null){  
          System.out.println("sender is : "+aa.getSender());
            System.out.println("------------------------------");
          String see="يري",drink="يشرب",play="يلعب";
          String con=aa.getContent();
            if(con.equalsIgnoreCase("see")){
                System.out.println("see meens : "+see);
            }else if (con.equalsIgnoreCase("drink")) {
                 System.out.println("drink meens "+drink); 
            }else if (con.equalsIgnoreCase("play")) {
                 System.out.println("play meens "+play); 
            } 
            else{
                System.out.println("not found");
            }
            
            //****************************
             ACLMessage repaly = aa.createReply();
                    repaly.setPerformative(ACLMessage.QUERY_IF);
                    System.out.println("if you need enter anothor word enter true else enter false");
                     Scanner in =new Scanner(System.in);
                    String bool =in.next();
                    repaly.setContent(bool);
                    send(repaly);
            
          }else{
          block();
          }

        }
    });

        
    }
    
    
}
