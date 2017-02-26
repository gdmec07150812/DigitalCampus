package com.gdmec.jacky.digitalcampus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.*;

public class Login extends AppCompatActivity {
    EditText input_account;
    EditText input_password;
    String account;
    String password;
    Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        input_account = (EditText) findViewById(R.id.input_account);
        input_password = (EditText) findViewById(R.id.input_password);
        account = input_account.getText().toString();
        password = input_password.getText().toString();
        button_login= (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("进入");
                query();
            }
        });
    }

    public void query() {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try {
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from account");
                while (resultSet.next()) {
                    if (resultSet.getString("account") == account && resultSet.getString("password") == password) {
                        System.out.println("登录成功");
                    }else{
                        System.out.println("登录失败");
                    }
                }
            } catch (SQLException e) {

            }
        }
        DBConnection.close(conn);
    }
}
