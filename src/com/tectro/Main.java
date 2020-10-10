package com.tectro;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try
        {
            ServerSocket server = new ServerSocket(25565, 0 , InetAddress.getByName("localhost"));
            while (true)
            {
                Socket client = server.accept();
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeDouble(CalculateFunction());
            }
        }
        catch (Exception exc)
        {
            System.out.println(exc.getMessage());
        }

    }

    public static double CalculateFunction()
    {
        double result = 0;

        for(double i = 1; i<=2.0 ; i+=0.1)
            result += Math.sin(i);

        return result;
    }
}


