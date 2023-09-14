package com.example.tic_tac_toe_2_online;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bb[] = new Button[9];
    TextView display, win;
    Button reset;
    int id, count = 0;
    ArrayList list = new ArrayList<>();
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display);
        win = findViewById(R.id.win);
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(this);
        for (int i = 0; i < bb.length; i++) {
            id = getResources().getIdentifier("bb" + i, "id", getPackageName());
            bb[i] = findViewById(id);
            bb[i].setOnClickListener(this);

        }


    }

    @Override
    public void onClick(View v) {
        for (int i = 0; i < bb.length; i++) {
            if (v.getId() == bb[i].getId()) {

                bb[i].setText("x");
                count++;
                list.add(i);
                bb[i].setEnabled(false);
                win();

                if (count <= 4) {
                    while (true) {
                        int min = 0, max = 9;
                        int r = new Random().nextInt(max - min) + min;
                        System.out.println("random=" + r);
                        if (!list.contains(r)) {
                            bb[r].setText("o");
                            bb[r].setEnabled(false);
                            list.add(r);
                            win();
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("list=" + list);
        if (v.getId() == reset.getId()) {
            reset();
        }
    }

    private void reset() {
        for (int i = 0; i < bb.length; i++) {
            bb[i].setText("");
            bb[i].setEnabled(true);
            reset.setVisibility(View.VISIBLE);
            count=0;
            list.clear();



        }
    }

    private void win() {
        b1 = bb[0].getText().toString();
        b2 = bb[1].getText().toString();
        b3 = bb[2].getText().toString();
        b4 = bb[3].getText().toString();
        b5 = bb[4].getText().toString();
        b6 = bb[5].getText().toString();
        b7 = bb[6].getText().toString();
        b8 = bb[7].getText().toString();
        b9 = bb[8].getText().toString();


        if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
            if (b1.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();

        } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
            if (b4.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
            if (b7.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win ");
            }
            diseble();
        } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
            if (b1.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
            if (b2.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
            if (b3.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
            if (b1.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
            if (b3.equalsIgnoreCase("x")) {
                win.setText("x is win");
            } else {
                win.setText("o is win");
            }
            diseble();
        }
        if (count == 9) {
            Toast.makeText(MainActivity.this, "Draw Game!", Toast.LENGTH_LONG).show();

        }

    }

    private void diseble() {

        for (int i = 0; i < bb.length; i++) {
            bb[i].setEnabled(false);
        }
    }
}