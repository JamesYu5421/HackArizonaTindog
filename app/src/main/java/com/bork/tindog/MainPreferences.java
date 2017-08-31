package com.bork.tindog;
    import android.app.Activity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.CheckBox;
    import android.widget.Toast;

    public class MainPreferences extends Activity {
        private CheckBox cbBoy, cbGirl, cbAggressive, cbOld, cbContagious, cbDisability, cbGoodest1, cbGoodest2, cbGoodest3, cbGoodest4, cbCutest1, cbCutest2, cbCutest3,cbCutest4;


        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_preferences);

            cbBoy = (CheckBox) findViewById(R.id.cbBoy);
            cbGirl = (CheckBox) findViewById(R.id.cbGirl);
            cbAggressive = (CheckBox) findViewById(R.id.cbAggressive);
            cbOld = (CheckBox) findViewById(R.id.cbOld);
            cbContagious = (CheckBox) findViewById(R.id.cbContagious);
            cbDisability = (CheckBox) findViewById(R.id.cbDisability);
            cbGoodest1 = (CheckBox) findViewById(R.id.cbGoodest1);
            cbGoodest2 = (CheckBox) findViewById(R.id.cbGoodest2);
            cbGoodest3 = (CheckBox) findViewById(R.id.cbGoodest3);
            cbGoodest4 = (CheckBox) findViewById(R.id.cbGoodest4);
            cbCutest1 = (CheckBox) findViewById(R.id.cbCutest1);
            cbCutest2 = (CheckBox) findViewById(R.id.cbCutest2);
            cbCutest3 = (CheckBox) findViewById(R.id.cbCutest3);
            cbCutest4 = (CheckBox) findViewById(R.id.cbCutest4);


            cbBoy.setOnClickListener(checkboxClickListener);
            cbGirl.setOnClickListener(checkboxClickListener);
            cbAggressive.setOnClickListener(checkboxClickListener);
            cbOld.setOnClickListener(checkboxClickListener);
            cbDisability.setOnClickListener(checkboxClickListener);
            cbGoodest1.setOnClickListener(checkboxClickListener);
            cbGoodest2.setOnClickListener(checkboxClickListener);
            cbGoodest3.setOnClickListener(checkboxClickListener);
            cbGoodest4.setOnClickListener(checkboxClickListener);
            cbCutest1.setOnClickListener(checkboxClickListener);
            cbCutest2.setOnClickListener(checkboxClickListener);
            cbCutest3.setOnClickListener(checkboxClickListener);
            cbCutest4.setOnClickListener(checkboxClickListener);

            Button backbutton = (Button) findViewById(R.id.backbutton);
            backbutton.setOnClickListener(new View.OnClickListener(){
                @Override

                public void onClick(View view){
                    Intent intnt = new Intent(MainPreferences.this, MainActivity.class);
                    startActivity(intnt);
                }
            });
        }


        View.OnClickListener checkboxClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    String text = null;
                    switch (view.getId()){
                        case R.id.cbBoy:
                            text = "";
                            break;
                        case R.id.cbGirl:
                            text = "";
                            break;
                        case R.id.cbAggressive:
                            text="";
                            break;
                        case R.id.cbOld:
                            text = "";
                            break;
                        case R.id.cbDisability:
                            text = "";
                            break;
                        case R.id.cbGoodest1:
                            text="";
                            break;
                        case R.id.cbGoodest2:
                            text="";
                            break;
                        case R.id.cbGoodest3:
                            text="";
                            break;
                        case R.id.cbGoodest4:
                            text="";
                            break;
                        case R.id.cbCutest1:
                            text="";
                            break;
                        case R.id.cbCutest2:
                            text="";
                            break;
                        case R.id.cbCutest3:
                            text="";
                            break;
                        case R.id.cbCutest4:
                            text="";
                            break;
                    }
                    Toast.makeText(MainPreferences.this, text, Toast.LENGTH_LONG).show();
                }
            }
        };
    }

