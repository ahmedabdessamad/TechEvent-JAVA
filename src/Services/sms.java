/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.SmsSubmissionResponseMessage;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;

/**
 *
 * @author Ahmed Abdessamed
 */
public class sms   {
   public void sendSms (String ch) throws IOException, NexmoClientException{
   
   NexmoClient client = new NexmoClient.Builder()
  .apiKey("e9547644")
  .apiSecret("2Qnn5Zga4bqI2py1")
  .build();

String messageText = "Hello from TechEvent l'event que tu a interessé  deroule le  ";
TextMessage message = new TextMessage("Nexmo",ch, messageText);

SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

for (SmsSubmissionResponseMessage responseMessage : response.getMessages()) {
    System.out.println(responseMessage);
}
   
   }
}
