package com.example.amir.ende_crypt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btco=(Button)findViewById(R.id.btncon);
        btco.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                EditText entxt = (EditText) findViewById(R.id.ed_encrytxt1);
                EditText enkey = (EditText) findViewById(R.id.ed_enkey2);
                EditText etxt = (EditText) findViewById(R.id.ed_urentxt3);

                String str=entxt.getText().toString();
                int ekey=Integer.parseInt(enkey.getText().toString());
                int i,j=0;
                int k;
                int nu;
                char []a=new char[str.length()];

                for(i=0;i<str.length();i++)
                {
                    a[i]=str.charAt(i);
                }

                for(i=0;i<str.length();i++)
                {
                    if(str.charAt(i)==' ')
                    {
                        continue;
                    }
                    if(i<2)
                    {
                        a[i]=(char) (a[i]+2);
                    }
                    if(i>=2 && i<10)
                    {
                        a[i]=(char) (a[i]+i);
                    }
                    if(i>=10 && i<=50)
                    {
                        a[i]=(char) (a[i]+2);
                    }
                    if(i>50 && i<=str.length())
                    {
                        a[i]=(char) (a[i]+3);
                    }
                }
                String at="";
                for(i=0;i<str.length();i++)
                {
                    at=at+a[i];
                }


                if(4==String.valueOf(ekey).length())
                {
                    String ke=String.valueOf(ekey);
                    char ker[]=new char[ke.length()];
                    for(i=0;i<ke.length();i++)
                    {
                        ker[i]=ke.charAt(i);
                    }
                    for(i=0;i<4;i++)
                    {
                        ker[i]=(char) (ker[i]-10);
                    }
                    String y="";
                    for(i=0;i<4;i++)
                    {
                        y=y+ker[i];
                    }
                    String r=at+y;
                    etxt.setText(r);


                }

            }
        });

        Button btrv=(Button)findViewById(R.id.btnrvt);
        btrv.setOnClickListener(new View.OnClickListener()
        {
            EditText dtxt = (EditText) findViewById(R.id.ed_dectxt5);
            EditText dkey = (EditText) findViewById(R.id.ed_dkey4);
            EditText ortxt = (EditText) findViewById(R.id.ed_or6);

            @Override
            public void onClick(View v) {



                String str1=dtxt.getText().toString();
                int drkey=Integer.parseInt(dkey.getText().toString());

                String decryptkey;
                decryptkey=String.valueOf(drkey);
                char []b=new char[str1.length()-4];
                int i;
                String key=str1.substring(str1.length()-4);
                char []keyarr=new char [key.length()];
                for(i=0;i<key.length();i++)
                {
                    keyarr[i]=key.charAt(i);
                }
                for(i=0;i<key.length();i++)
                {
                    keyarr[i]=(char) (keyarr[i]+10);
                }
                String keydcry="";
                for(i=0;i<key.length();i++)
                {
                    keydcry=keydcry+keyarr[i];
                }
                for(i=0;i<str1.length()-4;i++)
                {
                    b[i]=str1.charAt(i);
                }
                String w="";
                for(i=0;i<str1.length()-4;i++)
                {
                    w=w+b[i];
                }
                for(i=0;i<w.length();i++)
                {

                    if(decryptkey.equals(keydcry))
                    {
                        if(w.charAt(i)==' ')
                        {
                            continue;
                        }
                        if(i<2)
                        {
                            b[i]=(char) (b[i]-2);
                        }
                        if(i>=2 && i<10)
                        {
                            b[i]=(char) (b[i]-i);
                        }
                        if(i>=10 && i<=50)
                        {
                            b[i]=(char) (b[i]-2);
                        }
                        if(i>50 && i<=w.length())
                        {
                            b[i]=(char) (b[i]-3);
                        }
                    }

                }
                String yu="";
                for(i=0;i<w.length();i++)
                {
                    yu=yu+b[i];
                }

                ortxt.setText(yu);


            }
        });






    }
}
