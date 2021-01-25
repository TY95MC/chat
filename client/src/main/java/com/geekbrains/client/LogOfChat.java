package com.geekbrains.client;

import java.io.FileWriter;
import java.io.IOException;

public class ChatLog {
    Controller userMsg = new Controller();
    FileWriter fr = null;
    public FileWriter getUserMsg() {
        String addedText = userMsg.msgField.getText();
        try{
            fr = new FileWriter("chatLog.txt");
            fr.write(addedText);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fr;
    }
}
