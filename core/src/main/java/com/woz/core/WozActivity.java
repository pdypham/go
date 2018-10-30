package com.woz.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by woz on 3/25/18.
 */

public abstract class WozActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getApplication() instanceof WozApplication){
            ((WozApplication) getApplication()).setCurrentActivity(this);
        }
        setContentView(setLayoutView());
        addView();

//        init Tool Bar
        setToolBar();

        initView();

        loadData();
    }

    protected void addView(){

    }

    protected void setToolBar(){

    }


    @Override
    public void onClick(View v) {

    }



    protected boolean isHideSoftKeyBoardTouchOutSide(){
        return true;
    }




    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(isHideSoftKeyBoardTouchOutSide()){
            View viewFocus = getWindow().getCurrentFocus();
            if(viewFocus instanceof EditText){
                int[] screenLocation = new int[2];
                viewFocus.getLocationOnScreen(screenLocation);

                float x = event.getRawX() + viewFocus.getLeft() - screenLocation[0];
                float y = event.getRawY() + viewFocus.getTop() - screenLocation[1];

                if(event.getAction()== MotionEvent.ACTION_DOWN){
                    if(x < viewFocus.getLeft() || x >= viewFocus.getRight()
                            || y < viewFocus.getTop() || y >= viewFocus.getBottom()){

                        InputMethodManager iMM = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                        if(iMM != null) {
                            hideSoftKeyboard();
                            handlerSoftKeyBoard();

                        }

                    }else {
                        handlerSoftKeyBoard();
                    }
                }


            }
        }

        return super.dispatchTouchEvent(event);
    }


    protected void hideSoftKeyboard(){

        View viewFocus = getCurrentFocus();

        InputMethodManager iMM = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if(iMM != null && viewFocus != null) {
            iMM.hideSoftInputFromWindow(viewFocus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            handlerSoftKeyBoard();
        }
    }

    protected void hideSimpleSoftKeyboard(){
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }




    protected void handlerSoftKeyBoard(){

    }

    protected void toastMessage(String data){
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
    }




    protected String setTitleToolBar(){
        return null;
    }



    protected abstract int setLayoutView();

    protected abstract void initView();


    protected abstract void loadData();


    public void startActivity(Class cl){

        startActivity(new Intent(WozActivity.this,cl));
    }

    public void startActivity(Class cl, int flag){
        Intent intent = new Intent(WozActivity.this,cl);
        intent.addFlags(flag);
        startActivity(intent);
    }


    public void startActivityForResult(Class cl, int requestCode){
        startActivityForResult(new Intent(WozActivity.this,cl),requestCode);
    }

    public void startActivityForResult(Class cl, Bundle bundle, int requestCode){

        Intent intent = new Intent(WozActivity.this,cl);
        intent.putExtras(bundle);

        startActivityForResult(intent,requestCode);
    }


    public void startActivity(Class cl, Bundle bundle){

        Intent intent = new Intent(WozActivity.this,cl);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    protected int setIconToolbar(){
        return 0;
    }


    public  void showLoading(){}
    public  void hideLoading(){}

    public void handlerErrorRetrofit(){}
}
