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
        // 원래 Message와 Items는 한 창에서 동시 구현이 불가능!
        //dialog.setMessage("여기는 메시지를 쓰는 곳입니다.");
        //단순목록
        /*dialog.setItems(itemArr, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 클릭된 항목의 번호를 which가 갖고있음. (0~)
                butDialog.setText(itemArr[which]);
            }
        });*/ //ctrl + shift + / : 주석처리

 //     라디오 버튼 목록

        /*dialog.setSingleChoiceItems(itemArr, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 클릭된 항목의 번호를 which가 갖고있음. (0~)
                butDialog.setText(itemArr[which]);
            }
        });*/

 //    체크박스 목록
 //    선택 여부 배열
        boolean[] checkedItems = {true, false, true, false};
        dialog.setMultiChoiceItems(itemArr, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
               if(isChecked) //체크가 되어있는가
                    butDialog.setText(itemArr[which]);
            }
        });


        dialog.setPositiveButton("OK", null);
        dialog.show();
    }
}
