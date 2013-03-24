package com.hamzeen.sms;

import java.util.ArrayList;
import java.util.List;

import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.Service;
import org.smslib.Message.MessageTypes;
import org.smslib.modem.SerialModemGateway;

/**
 * This class enables to listen incoming messages from Processing.
 * 
 * @author Hamzeen. H.
 * @created 3/24/2013, 8:57 AM
 */
public class ReceiveSms {
	Service srv;
	SerialModemGateway gw;
	private ArrayList<String> incomingMsgList;
	private ArrayList<InboundMessage> inboundMsgList;
	String msg;

	public ReceiveSms(String modem, String port, int freq,
			String provider, String model, int messageCount) {
		srv = Service.getInstance();
		gw = new SerialModemGateway(modem, port, freq, provider,
				model);
		gw.setInbound(true);
		gw.setOutbound(false);
		gw.setSimPin("0000");

		InboundNotification inboundNotification;
		if (messageCount > 1) {
			inboundNotification = new InboundNotification(
					messageCount);
		} else {
			inboundNotification = new InboundNotification();
			System.out
					.println("[smsP5] Please provide a valid message count to process.");
		}

		srv.setInboundMessageNotification(inboundNotification);
		try {
			srv.addGateway(gw);
		} catch (GatewayException e) {
			System.out
					.println("[smsP5] Unable to attach gateway: "
							+ e.getMessage());
		}

		try {
			srv.startService();
		} catch (Exception e) {
			System.out
					.println("[smsP5] Unable to start the service: "
							+ e.getMessage());
		}
		srv.getSettings().SERIAL_NOFLUSH = false;

		incomingMsgList = new ArrayList();
		inboundMsgList = new ArrayList<InboundMessage>();
	}

	public List<String> getIncomingMsgList() {
		return incomingMsgList;
	}

	public List<InboundMessage> getInboundMsgList() {
		return inboundMsgList;
	}

	boolean isNewMessage(String message) {
		boolean result = true;
		if (incomingMsgList.size() == 0) {
			return result;
		}

		for (String msg : incomingMsgList) {
			if (message.equals(msg)) {
				return false;
			}
		}
		return result;
	}

	public class InboundNotification implements
			IInboundMessageNotification {
		private int messagesToKeep = 5;

		public InboundNotification() {
		}

		public InboundNotification(int messagesToKeep) {
			this.messagesToKeep = messagesToKeep - 1;
		}

		public void process(AGateway gateway,
				MessageTypes messageType,
				InboundMessage inboundMessage) {

			// used for debugging.
			/*
			 * System.out.println("[smsP5] :: Message Count: " +
			 * getIncomingMsgList().size());
			 */

			msg = inboundMessage.getText();
			if (isNewMessage(msg)) {
				if (incomingMsgList.size() > messagesToKeep) {
					try {
						srv.deleteMessage(inboundMsgList.get(0));
					} catch (Exception e) {
						System.out.println("TimeOutException");
					}
					incomingMsgList.remove(0);
					inboundMsgList.remove(0);
				}
				incomingMsgList.add(msg);
				inboundMsgList.add(inboundMessage);
			}
		}
	}
}
