package com.example.scv;

public class Sole{
    public java.util.List<Sola> Sole = new java.util.ArrayList<Sola>();
    private String ternutnaKrajsava = "";
    public final String PREFS_NAME = "MyPrefsFile";
    public final String PREF_IZBRANA_SOLA_KEY = "izbranaSola";


    public void Load(){
        Sola ersSola = new Sola();
        ersSola.ime = "Elektro in računalniška šola";
        ersSola.krajsava = "ERŠ";
        ersSola.url_strani = "https://ers.scv.si/sl/";
        ersSola.barva = R.style.ers_style;
        ersSola.url_urnik = "https://www.easistent.com/urniki/24353264bf0bc2a4b9c7d30eb8093fc21bb6c766";
        ersSola.slika = R.drawable.ers;

        Sole.add(ersSola);

        Sola ssgoSola = new Sola();
        ssgoSola.ime = "Šola za strojništvo, geotehniko in okolje";
        ssgoSola.krajsava = "ŠSGO";
        ssgoSola.url_strani = "https://ssgo.scv.si/sl/";
        ssgoSola.barva = R.style.ssgo_style;
        ssgoSola.url_urnik = "https://www.easistent.com/urniki/25447b9cd323fcb5b062a7a450fd3bff7da2b270";
        ssgoSola.slika = R.drawable.ssgo;

        Sole.add(ssgoSola);

        Sola ssdSola = new Sola();
        ssdSola.ime = "Šola za storitvene dejavnosti";
        ssdSola.krajsava = "ŠSD";
        ssdSola.url_strani = "https://storitvena.scv.si/sl/";
        ssdSola.barva = R.style.ssd_style;
        ssdSola.url_urnik = "https://www.easistent.com/urniki/642f7c2194b696dce4345e4a06f14d3510784603";
        ssdSola.slika = R.drawable.ssd;

        Sole.add(ssdSola);

        Sola gimSola = new Sola();
        gimSola.ime = "Gimnazija";
        gimSola.krajsava = "GIM";
        gimSola.url_strani = "https://gimnazija.scv.si/";
        gimSola.barva = R.style.gim_style;
        gimSola.url_urnik ="https://www.easistent.com/urniki/b29317ef35a6e16dc2012e97a575322a8eae7f56";
        gimSola.slika = R.drawable.gim;

        Sole.add(gimSola);

        Sola vssSola = new Sola();
        vssSola.ime = "Višja strokovna šola";
        vssSola.krajsava = "VSŠ";
        vssSola.url_strani = "https://vss.scv.si/sl/";
        vssSola.barva = R.style.vss_style;
        vssSola.url_urnik = "https://vss.scv.si/sl/studenti/urniki/";
        vssSola.slika = R.drawable.vss;

        Sole.add(vssSola);

        Sola micSola = new Sola();
        micSola.ime = "Medpodjetniško izobraževalni center";
        micSola.krajsava = "MIC";
        micSola.url_strani = "https://mic.scv.si/";
        micSola.barva = R.style.mic_style;
        micSola.slika = R.drawable.mic;



        Sole.add(micSola);



    }

    public Sola dobiTrenutnoSolo(){
        for(Sola so:this.Sole){
            if(so.krajsava.equals(this.ternutnaKrajsava)){
                return so;
            }
        }

        return new Sola();
    }

    public void shraniIzbranoSolo(String krajsava){
        this.ternutnaKrajsava = krajsava;
    }
}