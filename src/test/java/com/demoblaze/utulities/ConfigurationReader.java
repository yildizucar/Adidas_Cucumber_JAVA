package com.demoblaze.utulities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();// properties dosyasina ulasmak icin nesne olusturulur

    /**sooyt yazamazisn mesela  maininide yazamasizn
     static block olursa herseyi yazarsi dedi*/

    static {   //static blok ile nesne icine atama yapiyoruz//configuration.reader sag tikla COPY PATH YAP VE TANIMA
        //static ile ilgili herseyi yazdiriyoruz
        //2- load the file into FileInputStream
        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            //3- load properties object with the file ( configuration.properties)
            properties.load(file);
            //close the file
            file.close();
        } catch (IOException e) { //IOexception ile daha genis oku dedik alt enter ile yaziyoruz bunlari /Burada yazilanlarin hepsi 1 kere yapilir
            // e.printStackTrace();//otomatik geliyor ama silmis hoca bunu

            System.out.println("File not found in configuration properties");
        }
    }
    // USE THE ABOVE CRETAED LOGIC TO CRETAE A RE-USABLE STATIC MEHOD
    //YENİDEN KULLANILABİLİR BİR STATİK YÖNTEM OLUŞTURMAK İÇİN YUKARIDA OLUŞTURULAN MANTIĞI KULLANIN


    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }
}
