package com.hamzeen.sms;

import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

/**
 * This class facilitates sending SMS from Processing.
 * 
 * @author Hamzeen. H.
 * @created 3/23/2013, 6:39 PM
 */
public class SendSms {
	Service srv;
	SerialModemGateway gw;

	public SendSms(String modem, String port, int freq,
			String provider, String model) {
		srv = Service.getInstance();
		gw = new SerialModemGateway("modem.com1", "COM3", 19200,
				"Huawei", "E220");
		gw.setInbound(true);
		gw.setOutbound(true);
		gw.setSimPin("0000");

		gw.setSmscNumber("+9477000003");
		OutboundNotification outboundNotification = new OutboundNotification();
		srv.setOutboundMessageNotification(outboundNotification);
		try {
			srv.addGateway(gw);
		} catch (GatewayException e) {
			System.out
					.println("[smsP5] Unable to attach gateway: "
							+ e.getMessage());
		}
	}

	public void sendMessage(String phoneNumber, String message) {
		try {
			srv.startService();
			OutboundMessage msg = new OutboundMessage(
					phoneNumber, message);
			srv.sendMessage(msg);
			srv.stopService();
		} catch (Exception e) {
			System.out
					.println("[smsP5] Unable to start the service: "
							+ e.getMessage());
		}
	}

	/**
	 * Inner class, OutboundNotification
	 */
	public class OutboundNotification implements
			IOutboundMessageNotification {
		public OutboundNotification() {
		}

		public void process(AGateway gateway, OutboundMessage msg) {
			System.out
					.println("[smsP5] Outbound handler called from Gateway: "
							+ gateway.getGatewayId());
			System.out.println("[smsP5] " + msg);
		}
	}
}
