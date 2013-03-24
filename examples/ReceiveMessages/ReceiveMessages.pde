/**
 * Exampple on receiving incoming short messages with 
 * smsP5 library.
 * 
 * @author Hamzeen. H.
 * @created 03/24/2013
 */
import com.hamzeen.sms.*;
import org.smslib.InboundMessage;

ReceiveSms receiver;
ArrayList<String> incomingMsgList;
ArrayList<InboundMessage> inboundMsgs;

PFont font;

void setup(){
  size(400,400);
  receiver = new ReceiveSms("modem.com1", "COM3", 19200,"Huawei", "E220",3);

  font = createFont( "Arial", 16 );
  textFont(font);
  textAlign(LEFT);
  noStroke();
}

void draw() {
  background(0);
  incomingMsgList = new ArrayList<String>(receiver.getIncomingMsgList());
  inboundMsgs = new ArrayList<InboundMessage>(receiver.getInboundMsgList());
  
  if(frameCount%32>7){
    fill(255,255,255);
    rect(width-30, 7,25,25);
  }else{
    fill(0,0,0);
    rect(width-30, 7,25,25);
  }

  fill(200);
  text("Messages:"+incomingMsgList.size(), width-140, 28);
  if(incomingMsgList.size() > 0) {
    for(int i =0;i<incomingMsgList.size();i++){
      String str = incomingMsgList.get(incomingMsgList.size()-1-i).toString();
      text(str, 20, 60+(i*30));
    }
  }
}
