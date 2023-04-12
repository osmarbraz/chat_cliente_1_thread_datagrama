
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String args[]) {
        try {
            DatagramSocket con = new DatagramSocket();//cria o objeto
            System.out.println("Inicio cliente");
            String mensagem = "";
            while (!mensagem.equals("fim")) {
                mensagem = JOptionPane.showInputDialog("Digite a Mensagem ou fim para sair");
                //Converte a mensagem em um vetor de byte
                byte dado[] = mensagem.getBytes();
                //Configura o pacote
                DatagramPacket pacote = new DatagramPacket(dado, dado.length, InetAddress.getByName("localhost"), 4444);
                //envia o pacote
                con.send(pacote);
            }
        } catch (IOException ioe) {
            System.out.println("Excecao: " + ioe.getMessage());
        }
    }
}
