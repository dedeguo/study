package cn.dedeguo.util;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class MacTest {

    public static void main(String[] args) throws SocketException {
        StringBuilder sb=new StringBuilder();
        Enumeration<NetworkInterface> allNetInterfaces  = NetworkInterface.getNetworkInterfaces();
        byte[] mac=null;
        while (allNetInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = allNetInterfaces.nextElement();
            if (networkInterface.isLoopback() || networkInterface.isVirtual()
            || networkInterface.isPointToPoint() || !networkInterface.isUp()){
                continue;
            }else {
                mac=networkInterface.getHardwareAddress();
                if (mac!=null){
                    for (int i=0;i<mac.length;i++){
                        sb.append(String.format("%02X%s",mac[i],(i<mac.length-1)?"":"#"));
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
