package com.shinemirai.jiaodazhushou.activity;

import static java.lang.Thread.sleep;

import android.app.Dialog;
import android.hardware.ConsumerIrManager;
import android.os.Environment;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.Button;
import android.widget.EditText;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.shinemirai.jiaodazhushou.R;
import com.shinemirai.jiaodazhushou.entity.AccountDatasEntity;
import com.shinemirai.jiaodazhushou.entity.ClassRoomEntity;
import com.shinemirai.jiaodazhushou.entity.ScheduleEntity;
import com.shinemirai.jiaodazhushou.util.CookieUtils;
import com.shinemirai.jiaodazhushou.util.CustomProgressDialog;
import com.shinemirai.jiaodazhushou.util.SpDataUtils;
import com.shinemirai.jiaodazhushou.util.StringUtils;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class LoginActivity extends BaseActivity{
    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;
    private Dialog mDialog;
    @Override
    protected int initLayout() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.send_login_btn);

        AccountDatasEntity accountDatasEntity = SpDataUtils.getAccountDatas(this);
        if(accountDatasEntity != null && !StringUtils.isEmpty(accountDatasEntity.getAccount()))
        {
            etAccount.setText(accountDatasEntity.getAccount());
            etPassword.setText(accountDatasEntity.getPassword());
        }
        else
            showToast("第一次登录需要输入账号密码哦");
    }

    @Override
    protected void initData() {
        AccountDatasEntity accountDatasEntity = SpDataUtils.getAccountDatas(this);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String account = etAccount.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    //等待动画
                    mDialog = CustomProgressDialog.createLoadingDialog(mContext,"正在加载中");
                    mDialog.setCancelable(false);
                    mDialog.show();
                    btnLogin.setEnabled(true);

                    login(account,password);
                }
            });
    }

}
