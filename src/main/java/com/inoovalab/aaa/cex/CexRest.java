package com.inoovalab.aaa.cex;

import com.inoovalab.aaa.cex.email.EmailService;
import com.inoovalab.aaa.cex.model.*;
import org.glassfish.jersey.client.ClientResponse;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.MessagingException;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CexRest {





    public static void main(String[] args) throws GeneralSecurityException, IOException, MessagingException {
        String usernamebs="cvkx6595";
        String apiKeybs="BeDA1gQKvbETOkjkAdwY5HOodxqAP6qr";
        String apiSecretbs="X5Fk7d682Yq8LXikDj4DfiZXNJytddCt";
/*        String usernameCEX="up109035641";
        String apiKeyCEX="7NPYD6dWoTk7xK4B0tZ05ciElTk";
        String apiSecretCEX="IFE7GRsQYC7MfUkS0nbSKnUNg";*/
       // int nonce = Integer.valueOf((int) (System.currentTimeMillis() / 1000));

       // String signature=signature(usernamebs,apiKeybs,apiSecretbs,nonce);
       // int noncecex = Integer.valueOf((int) (System.currentTimeMillis() / 1000));
       // System.out.println(nonce);

        //System.out.println(new CexRest().signature(usernamebs,apiKeybs,apiSecretbs,nonce));

        //System.out.println(transfer(usernamebs,apiKeybs,apiSecretbs,nonce));
        //getBSTbalance(apiKeybs,signature,nonce);
        //System.out.println(CexRest.class.getr);
      // System.out.println(EmailService.getGmailService("rilfiup@gmail.com", "rilfimail@gmail.com","CEX Status","jhbjhvftrddrfytf"));
        double bitstampAskPrice = 0;
        double CEXBuyPrice=0;
        double threshold1=0;

        double CEXAskPrice = 0;
        double bitstampBuyPrice = 0;
        while (true){

            try {
                 bitstampAskPrice = getAskPriceFrombitstamp().getAsk();
                 CEXBuyPrice = getBuyPriceFromCEX().getBid();
                 threshold1 = bitstampAskPrice / 100;

                 CEXAskPrice = getBuyPriceFromCEX().getAsk();
                 bitstampBuyPrice = getAskPriceFrombitstamp().getBid();
            }catch (NullPointerException e){
                System.out.println("Empty Stream");
            }
            double threshold2=bitstampAskPrice/100;
            String prtText1="";
            String prtText2="";
           // nonce++;
            try {


               // double BSTBalance = getBSTbalance(usernamebs, apiKeybs, apiSecretbs, nonce).getEur_balance();
                double difPers1 = (CEXBuyPrice - bitstampAskPrice) / bitstampAskPrice * 100;
                double difPers2 = (bitstampBuyPrice - CEXAskPrice )/ CEXAskPrice * 100;

                 prtText1 = String.format("To CEX - BST ask: %1$.5f, CEX buying price: %2$.5f, different: %3$.5f, diff %% : %4$.5f", bitstampAskPrice, CEXBuyPrice, CEXBuyPrice - bitstampAskPrice, difPers1);
                 prtText2 = String.format("To bitstamp - CEX ask: %1$.5f, BST buying price: %2$.5f, different: %3$.5f, diff %% : %4$.5f", CEXAskPrice, bitstampBuyPrice, bitstampBuyPrice - CEXAskPrice, difPers2);
                //sendSMS(prtText1);
                /*try {
                    System.out.println(EmailService.getGmailService("imran876@gmail.com", "rilfimail@gmail.com","CEX Status",prtText2));
                    System.out.println(EmailService.getGmailService("rilfi@live.com", "rilfimail@gmail.com","CEX Status",prtText2));

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }*/

                System.out.println(prtText1);
               // System.out.println(prtText2);
                //System.out.println("-------------------------------------------------------------------------------------------");
               // System.out.println(prtText);
            }
            catch (NullPointerException e){

            }

            if(CEXBuyPrice-bitstampAskPrice>threshold1){

                System.out.println("############################"+sendSMS(prtText1));
                try {
                    System.out.println(EmailService.getGmailService("imran876@gmail.com", "rilfimail@gmail.com","CEX Status",prtText1));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

                //stem.out.println(transfer(usernamebs,apiKeybs,apiSecretbs,nonce));

            }
           /* if(bitstampBuyPrice-CEXAskPrice>threshold2) {
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+sendSMS(prtText2));
                try {
                    System.out.println(EmailService.getGmailService("imran876@gmail.com", "rilfimail@gmail.com","CEX Status",prtText2));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }*/

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



    }

  /*  static boolean isDifferent(String currencyPair){





    }*/
    public static String sendSMS(String message ) {




        Client client = ClientBuilder.newClient();
        String responce1 = client.target("https://cpsolutions.dialog.lk/index.php/cbs/sms/send").queryParam("destination","94776284627").queryParam("q","15186921391127")
                .queryParam("message",message)
                .queryParam("from","Ammicoin")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);
        String responce2 = client.target("https://cpsolutions.dialog.lk/index.php/cbs/sms/send").queryParam("destination","94772246726").queryParam("q","15186921391127")
                .queryParam("message",message)
                .queryParam("from","Ammicoin")
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        return responce1;

    }

    private static TickerBST getAskPriceFrombitstamp() {
        Client client = ClientBuilder.newClient();
        TickerBST tickerBST = client.target("https://www.bitstamp.net/api/v2/ticker/btceur/")
                .request(MediaType.APPLICATION_JSON)
                .get(TickerBST.class);

        return tickerBST;
    }
    private static TickerCEX getBuyPriceFromCEX() {
        Client client = ClientBuilder.newClient();
        TickerCEX ticker = client.target("https://cex.io/api/ticker/BTC/EUR")
                .request(MediaType.APPLICATION_JSON)
                .get(TickerCEX.class);

        return ticker;

    }
/*    public static BTBalance getBSTbalance( String usernamebs, String apiKeybs, String apiSecretbs, int nonce) {

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://www.bitstamp.net/api/v2/balance/xrpeur/");
        String signature = signature(usernamebs, apiKeybs, apiSecretbs, nonce);
        KeySet keySet = new KeySet();
        keySet.setKey(apiKeybs);
        keySet.setSignature(signature);
        keySet.setNonce(nonce);




        Form form = new Form();
        form.param("key", apiKeybs);
        form.param("signature", signature);
        form.param("nonce", String.valueOf(nonce));
        BTBalance requestResult=null;
        try {


             requestResult =
                    target.request(MediaType.APPLICATION_JSON_TYPE)
                            .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                                    BTBalance.class);
        }
        catch (ForbiddenException forbiddenException){
            System.out.println("Authentication Failed");
        }



        return requestResult;

    }*/
/*    public static BTBalance getCEXbalance(String usernamebs, String apiKeybs, String apiSecretbs, int nonce){

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://cex.io/api/balance/");
        String signature=signature(usernamebs, apiKeybs, apiSecretbs, nonce);
        Form form = new Form();
        form.param("key", apiKeybs);
        form.param("signature", signature);
        form.param("nonce", String.valueOf(nonce));
        BTBalance requestResult=null;
        try {


            requestResult =
                    target.request(MediaType.APPLICATION_JSON_TYPE)
                            .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                                    BTBalance.class);
        }
        catch (ForbiddenException forbiddenException){
            System.out.println("Authentication Failed");
        }



        return requestResult;


    }*/

/*    private static String transfer(String usernamebs, String apiKeybs, String apiSecretbs, int nonce) {
        Client client = ClientBuilder.newClient();

        WebTarget target = client.target("https://www.bitstamp.net/api/v2/xrp_withdrawal/");
        String signature=signature(usernamebs, apiKeybs, apiSecretbs, nonce);


        Form form = new Form();
        form.param("key", apiKeybs);
        form.param("signature", signature);
        form.param("nonce", String.valueOf(nonce));
        form.param("amount", String.valueOf(20));
        form.param("address", "rE1sdh25BJQ3qFwngiTBwaq3zPGGYcrjp1");
        form.param("destination_tag", "52209");

        String requestResult =
                target.request(MediaType.APPLICATION_JSON_TYPE)
                        .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                                String.class);

       // Response response = target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(withdrawal, MediaType.APPLICATION_JSON_TYPE));
       *//* if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server.");
        }*//*

        return requestResult;


    }*/


    private static  String signature( String username,String apiKey,String apiSecret,  int nonce ){

        String message = new String(nonce + username + apiKey);
        Mac hmac = null;

        try {
            hmac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key =
                    new SecretKeySpec(((String) apiSecret).getBytes("UTF-8"), "HmacSHA256");
            hmac.init(secret_key);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return String.format("%X", new BigInteger(1, hmac.doFinal(message.getBytes())));

    }

}
