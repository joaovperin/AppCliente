/*
 * AppCliente
 * CopyRight Rech Informática Ltda. Todos os direitos reservados.
 */
package br.perin.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Descrição da classe.
 */
public class Sender {

    public static void main(String[] args) throws Exception {

        new Sender().server();
        new Sender().cliente();
        new Sender().cliente();
        new Sender().cliente();
        new Sender().cliente();
        new Sender().cliente();
    }

    private void cliente() {
        Socket socket = null;
        try {
//            String ip = "201.87.177.161";
//            int port = 6969;

            String ip = "192.168.0.235";
            int port = 6969;
            InetAddress addr = InetAddress.getByName(ip);

            socket = new Socket(ip, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // envia pro servidor a string
            out.write("qualquer string");
            out.flush();
            socket.shutdownOutput();
            // recebe do servidor
            String ret = in.readLine();
            System.out.println("retorno do servico :" + ret);
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void server() throws Exception {
        new Thread(() -> {
            String fraseCliente;
            int porta = 6969;
            ServerSocket socketRecepcao;
            try {
                socketRecepcao = new ServerSocket(porta);
                System.out.println("Start server.");
                while (true) {
                    Socket socketConexao = socketRecepcao.accept();
                    BufferedReader doCliente = new BufferedReader(new InputStreamReader(socketConexao.getInputStream()));
                    DataOutputStream paraCliente = new DataOutputStream(socketConexao.getOutputStream());
                    fraseCliente = doCliente.readLine();
                    System.out.println("Msg: " + fraseCliente);
                }
            } catch (IOException ex) {
                System.out.println("falha: " + ex);
            }
        }).start();
    }

}
