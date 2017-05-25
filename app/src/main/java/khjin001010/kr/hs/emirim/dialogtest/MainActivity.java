package khjin001010.kr.hs.emirim.dialogtest;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String[] itemArr = {"한채영","강예원","홍진경","홍진영"};
    Button butDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butDialog = (Button)findViewById(R.id.but_dialog);
        butDialog.setOnClickListener(this); //버튼이 클릭되는 지 감시하는 감시자

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("첫 번째, 다이얼로그");
        dialog.setIcon(R.drawable.images);
        dialog.setMessage("여기는 메시지를 쓰는 곳입니다.");
        dialog.setItems(itemArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 클릭된 항목의 번호를 which가 갖고있음. (0~)
                butDialog.setText(itemArr[which]);

            }
        });
        dialog.setPositiveButton("Ok", null);
        dialog.show();
    }
}
