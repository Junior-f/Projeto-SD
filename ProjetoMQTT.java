
package projetomqtt;
import java.text.SimpleDateFormat;


public class ProjetoMQTT {

    public static void main(String[] args) throws InterruptedException {
        ClienteMQTT clienteMQTT = new ClienteMQTT("tcp://broker.mqttdashboard.com:1883", null, null);
        clienteMQTT.iniciar();

       Ouvinte ouvinte = new Ouvinte(clienteMQTT, "Juior",0);
       

        while (true) {
            Thread.sleep(10);
            String mensagem = "Mensagem enviada em " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(System.currentTimeMillis());
           clienteMQTT.publicar("", mensagem.getBytes(), 0);
        }

    }

}