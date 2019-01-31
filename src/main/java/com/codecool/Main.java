package com.codecool;

public class Main {

    public static void main(String[] args) {

        ESProvider esp = new ESProvider(new FactParser("./Films.xml"), new RuleParser("./Rules.xml"));
        //esp.collectAnswers();
        //System.out.println(esp.evaluate());
        /*Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://ncore.cc/torrents.php?action=details&id=2164634"));
            d.browse(new URI("https://www.youtube.com/watch?v=bAuIXCDd2Fw&t=70s"));
        } catch (Exception e){
            e.printStackTrace();
        }*/
        System.out.println(esp.evaluate2());


    }
}
