package project2.agent;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import java.util.Scanner;

public class sende2 extends Agent  {
protected void setup(){
    System.out.println("sender2 is createt");
    System.out.println("the local name is : "+getAID().getLocalName());
    //send message 
    ACLMessage acl =new ACLMessage();
    acl.addReceiver(new AID("reciever",false));
    Scanner in =new Scanner(System.in);
    String word =in.next();
    
acl.setContent(word);
acl.setPerformative(ACLMessage.QUERY_IF);
    send(acl);
    
    ///////////////////////////////////////
    //get replay
        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage rep = receive();
                if (rep != null) {
                    String r = rep.getContent();
                    if (r.equalsIgnoreCase("true")) {
                       String word2=in.next();
                       acl.setContent(word2);
                        send(acl);
                        
                    }else{
                        System.out.println("thanks");
                    }
  
                } else {
                    block();
                }

            }
        });

    
}    
}
