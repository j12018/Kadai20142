package seisaku.bord;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class gods extends Activity {

    Button b1;
    Button btn1;
    private Button finishButton;

    MyAsyncHttpClient myAsyncHttpClient;
    private static final String url = "http://j12025.sangi01.net/upload/post.php";

    private final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
    private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
    LinearLayout lay0, lay1, lay2, lay3, lay4, lay5, lay6, lay7;
    Button btn_add;
    Button btn_del0, btn_del1, btn_del2, btn_del3, btn_del4;

    int weight[] = {1, 1, 1, 1, 1, 1, 1, 0};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gods);


        ((Button) findViewById(R.id.select)).setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        final LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View[] view = new View[1];
                        String[] str_items = {
                                "ドラスレ",
                                "ブロックス",
                                "Gods Gambit",
                                "キャンセル"};

                        new AlertDialog.Builder(gods.this)
                                .setTitle("タイトルです")
                                .setItems(str_items, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int which) {

                                                //選択したアイテムの番号(0～)がwhichに格納される
                                                switch (which) {
                                                    case 0:
                                                        // 選択１
                                                        // インテントの生成
                                                        // 遷移先のActivityを指定して、Intentを作成する
                                                        Intent intent2 = new Intent();
                                                        intent2.setClassName("seisaku.bord", "seisaku.bord.sub");
                                                        // SubActivity の起動
                                                        startActivity(intent2);
                                                        // setContentView(R.layout.activity_main);
                                                        break;

                                                    case 1:
                                                        // 選択２
                                                        // インテントの生成
                                                        // 遷移先のActivityを指定して、Intentを作成する
                                                        Intent intent = new Intent();
                                                        intent.setClassName("seisaku.bord", "seisaku.bord.MainActivity");
                                                        // SubActivity の起動
                                                        startActivity(intent);
                                                        // setContentView(R.layout.activity_main);
                                                        break;
                                                    case 2:
                                                        // インテントの生成
                                                        // 遷移先のActivityを指定して、Intentを作成する
                                                        Intent intent3 = new Intent();
                                                        intent3.setClassName("seisaku.bord", "seisaku.bord.gods");
                                                        // SubActivity の起動
                                                        startActivity(intent3);
                                                        // setContentView(R.layout.activity_main);
                                                        break;
                                                    default:
                                                        // キャンセル
                                                        Toast.makeText(gods.this, "キャンセルが選ばれました", Toast.LENGTH_LONG).show();
                                                        break;
                                                }
                                            }
                                        }
                                ).show();
                    }
                });


        lay0 = (LinearLayout)findViewById(R.id.lay0);
        lay1 = (LinearLayout)findViewById(R.id.lay1);
        lay2 = (LinearLayout)findViewById(R.id.lay2);
        lay3 = (LinearLayout)findViewById(R.id.lay3);
        lay4 = (LinearLayout)findViewById(R.id.lay4);
        lay5 = (LinearLayout)findViewById(R.id.lay5);

        lay7 = (LinearLayout)findViewById(R.id.lay7);


        btn_add = (Button)findViewById(R.id.Btn_add);

        btn_del0 = (Button)findViewById(R.id.Btn_del0);
        btn_del1 = (Button)findViewById(R.id.Btn_del1);
        btn_del2 = (Button)findViewById(R.id.Btn_del2);
        btn_del3 = (Button)findViewById(R.id.Btn_del3);
        btn_del4 = (Button)findViewById(R.id.Btn_del4);

        btn_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i=0;i<5;i++){
                    if(weight[i]==0){
                        weight[i]++;
                        weight[5]--;
                        update();
                        break;
                    }
                }
            }
        });
        btn_del0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weight[0]--;
                weight[5]++;
                update();
            }
        });
        btn_del1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weight[1]--;
                weight[5]++;
                update();
            }
        });
        btn_del2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weight[2]--;
                weight[5]++;
                update();
            }
        });
        btn_del3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weight[3]--;
                weight[5]++;
                update();
            }
        });
        btn_del4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                weight[4]--;
                weight[5]++;
                update();
            }
        });

        b1 = (Button) findViewById(R.id.Btn_send);

        myAsyncHttpClient = new MyAsyncHttpClient(getApplicationContext());


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.Text1);
                Spinner spinner = (Spinner) findViewById(R.id.spinner1);
                Spinner spinner11 = (Spinner) findViewById(R.id.spinner11);

                EditText editText2 = (EditText) findViewById(R.id.Text2);
                Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
                Spinner spinner22 = (Spinner) findViewById(R.id.spinner21);

                EditText editText3 = (EditText) findViewById(R.id.Text3);
                Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
                Spinner spinner33 = (Spinner) findViewById(R.id.spinner31);

                EditText editText4 = (EditText) findViewById(R.id.Text4);
                Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
                Spinner spinner44 = (Spinner) findViewById(R.id.spinner41);

                EditText editText5 = (EditText) findViewById(R.id.Text5);
                Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
                Spinner spinner55 = (Spinner) findViewById(R.id.spinner51);


                String moji1 = editText.getText().toString();
                String moji2 = spinner.getSelectedItem().toString();
                String moji3 = spinner11.getSelectedItem().toString();

                String moji21 = editText2.getText().toString();
                String moji22 = spinner2.getSelectedItem().toString();
                String moji23 = spinner22.getSelectedItem().toString();

                String moji31 = editText3.getText().toString();
                String moji32 = spinner3.getSelectedItem().toString();
                String moji33 = spinner33.getSelectedItem().toString();

                String moji41 = editText4.getText().toString();
                String moji42 = spinner4.getSelectedItem().toString();
                String moji43 = spinner44.getSelectedItem().toString();

                String moji51 = editText5.getText().toString();
                String moji52 = spinner5.getSelectedItem().toString();
                String moji53 = spinner55.getSelectedItem().toString();


                for (int i = 0; i < 5; i++) {
                    myAsyncHttpClient.newRequestParams();
                    if (i == 0) {
                        //aaやbbはweb側と合わせる
                        myAsyncHttpClient.setParams("aa", moji1);    //送るファイルを設定
                        myAsyncHttpClient.setParams("bb", moji2);    //送るファイルを設定
                        myAsyncHttpClient.setParams("cc", moji3);    //送るファイルを設定
                    } else if (i == 1) {
                        myAsyncHttpClient.newRequestParams();
                        myAsyncHttpClient.setParams("aa", moji21);    //送るファイルを設定
                        myAsyncHttpClient.setParams("bb", moji22);    //送るファイルを設定
                        myAsyncHttpClient.setParams("cc", moji23);    //送るファイルを設定

                    } else if (i == 2) {
                        myAsyncHttpClient.newRequestParams();
                        myAsyncHttpClient.setParams("aa", moji31);    //送るファイルを設定
                        myAsyncHttpClient.setParams("bb", moji32);    //送るファイルを設定
                        myAsyncHttpClient.setParams("cc", moji33);    //送るファイルを設定

                    } else if (i == 3) {

                        myAsyncHttpClient.newRequestParams();
                        myAsyncHttpClient.setParams("aa", moji41);    //送るファイルを設定
                        myAsyncHttpClient.setParams("bb", moji42);    //送るファイルを設定
                        myAsyncHttpClient.setParams("cc", moji43);    //送るファイルを設定
                    }else if (i == 4) {

                        myAsyncHttpClient.newRequestParams();
                        myAsyncHttpClient.setParams("aa", moji51);    //送るファイルを設定
                        myAsyncHttpClient.setParams("bb", moji52);    //送るファイルを設定
                        myAsyncHttpClient.setParams("cc", moji53);    //送るファイルを設定
                    }
                    myAsyncHttpClient.access1();
                }

            }
        });

    }

    public void update(){
        lay0.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[0]));
        lay1.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[1]));
        lay2.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[2]));
        lay3.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[3]));
        lay4.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[4]));
        lay7.setLayoutParams(new LinearLayout.LayoutParams(MP,0, weight[7]));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // BackBtnアクション
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            this.finish();
        }
        return false;
    }
}



