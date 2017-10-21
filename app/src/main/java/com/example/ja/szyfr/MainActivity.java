package com.example.ja.szyfr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private char[][] tab = new char[123][123];
    EditText tekst;
    EditText klucz;
    TextView wyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tablica();
        tekst = (EditText) findViewById(R.id.zaszyfruj1);
        klucz = (EditText) findViewById(R.id.pass1);
        wyswietl = (TextView) findViewById(R.id.okno);
    }

    public void tablica() {
        for (char a = 'a'; a <= 'z'; a++) {
            System.out.println("");
            char b = a;
            for (int z = 'a'; z <= 'z'; z++) {
                if (b == 'z' + 1) b = 'a';
                tab[a][z] = b;
                System.out.print(tab[a][z] + " ");
                b++;
            }}
        System.out.println("");
    }

    public void szyfruj(View v) {
        String x = tekst.getText().toString();
        String y = klucz.getText().toString();
        char[] teksttab = x.toCharArray();
        char[] klucztab = y.toCharArray();
        char[] wynik = new char[teksttab.length];
        for (int index = 0; index < teksttab.length; index++) {
            if(teksttab[index] == ' ')
                wynik[index]=' ';
            else{
                try {
                    wynik[index] = tab[teksttab[index]][klucztab[index]];
                }
                catch (ArrayIndexOutOfBoundsException e){
                    break;
                }
        }
        }
        String s = new String(wynik);
        wyswietl.setText(s);
    }

    public void deszyfruj(View v) {
        String x = tekst.getText().toString();
        String y = klucz.getText().toString();
        char[] teksttab = x.toCharArray();
        char[] klucztab = y.toCharArray();
        char[] wynik = new char[teksttab.length];
        for (int index = 0; index < teksttab.length; index++) {
            if (teksttab[index] != ' ') {
                for (int z = 'a'; z <= 'z'; z++) {
                    if (teksttab[index] == tab[klucztab[index]][z]) {
                        wynik[index] = (tab['a'][z]);
                    }
                }
            } else {
                wynik[index] = ' ';
            }
        }
        String s = new String(wynik);
        wyswietl.setText(s);
    }
}
