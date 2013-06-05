/**
 * Exampple on sending a short message with 
 * smsP5 library.
 * 
 * @author Hamzeen. H.
 * @created 3/23/2013
 */
import com.hamzeen.sms.*;

SendSms sender;
boolean messageSent;

void setup() {
  size(400,300);
  org.apache.log4j.BasicConfigurator.configure();
  sender = new SendSms("modem.com1", "COM3", 19200, "Huawei", "E220");
}

void draw() {
  background(0);
  if(messageSent){
    text("The message was sent",width/2-100,height/2-20);
  }
}

void keyPressed(){
  sender.sendMessage("+94777602705","Hello Short Messaging Service.");
  messageSent = true;
}

