package com.woz.wozpi.Widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.woz.wozpi.R;
import com.woz.wozpi.utils.AppUtil;

public class WozInput extends RelativeLayout implements TextWatcher,View.OnFocusChangeListener{

    private EditText mInputEdit;
    private String mValueError;

    public WozInput(Context context) {
        super(context);
        initView(context,null);
    }

    public WozInput(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    public WozInput(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context,attrs);
    }


    private void initView(Context context,AttributeSet attrs){
        LayoutInflater.from(context).inflate(R.layout.widget_woz_input,this,true);

        if(attrs != null){
            TypedArray types = context.getTheme()
                    .obtainStyledAttributes(attrs,R.styleable.WozInput,0,0);


            View layoutEdit = findViewById(R.id.layoutEdit);
            View layoutPopup = findViewById(R.id.layoutPopup);


            mInputEdit = findViewById(R.id.inputEdit);
            mInputEdit.addTextChangedListener(this);
            mInputEdit.setOnFocusChangeListener(this);



            if(types.hasValue(R.styleable.WozInput_style)){
                int styleText = types.getInt(R.styleable.WozInput_style,0);
                if(styleText == 0){
                    //show edit
                    layoutPopup.setVisibility(GONE);

                    int styleEdit = types.getInt(R.styleable.WozInput_styleEdit,0);
                    switch (styleEdit){
                        case 0:
                            mInputEdit.setInputType(InputType.TYPE_CLASS_TEXT);
                            break;
                        case 1:
                            mInputEdit.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            break;
                        case 2:
                            mInputEdit.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                            break;
                        case 3:
                            mInputEdit.setInputType(InputType.TYPE_CLASS_PHONE);
                            break;
                    }



                }else {
                    layoutEdit.setVisibility(GONE);
                }

            }




            if(types.hasValue(R.styleable.WozInput_hintText)){
//                String hintText = types.getString(R.styleable.WozInput_hintText);

            }


            types.recycle();

        }
    }


    /**
        for text change EditTex
    */
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if(getStatusEditText()){
            setEndIconEditText(R.drawable.ic_baseline_check_success);
        }else {
            setEndIconEditText(R.drawable.ic_baseline_check_error);
        }
    }



    @Override
    public void onFocusChange(View view, boolean isFocus) {

        if(!isFocus) {
            if (!getStatusEditText() && !TextUtils.isEmpty(mValueError)) {
                setEndIconEditText(R.drawable.ic_baseline_check_error);

            } else {
                setEndIconEditText(R.drawable.ic_baseline_check_success);

            }
        }
    }



    private boolean getStatusEditText(){

        int styleInput = mInputEdit.getInputType();
        String value = mInputEdit.getText().toString();
        boolean result = true;
        switch (styleInput){
            case InputType.TYPE_NUMBER_VARIATION_PASSWORD:
               result = AppUtil.isPassword(value);
               mValueError = getResources().getString(R.string.value_error_password);
                break;
            case InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS:
                result = AppUtil.isValidEmail(value);
                mValueError = getResources().getString(R.string.value_error_email);
                break;
            case InputType.TYPE_CLASS_PHONE:
                result = AppUtil.isValidPhone(value);
                mValueError = getResources().getString(R.string.value_error_phone);
                break;
        }
        return result;
    }

    private void setEndIconEditText(int res){
        if(mInputEdit != null){
            mInputEdit.setCompoundDrawablesWithIntrinsicBounds(0,0,res,0);
        }
    }




}
