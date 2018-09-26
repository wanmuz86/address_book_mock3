package my.com.commonroom.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY_FIRST_NAME =
            "my.com.commonroom.addressbook.FIRST_NAME";
    public static final String EXTRA_REPLY_LAST_NAME =
            "my.com.commonroom.addressbook.LAST_NAME";
    public static final String EXTRA_REPLY_ADDRESS1 =
            "my.com.commonroom.addressbook.ADDRESS1";
    public static final String EXTRA_REPLY_ADDRESS2 =
            "my.com.commonroom.addressbook.ADDRESS2";
    public static final String EXTRA_REPLY_PHONE =
            "my.com.commonroom.addressbook.PHONE";
    public static final String EXTRA_REPLY_CELL =
            "my.com.commonroom.addressbook.CELL";
    public static final String EXTRA_REPLY_EMAIL =
            "my.com.commonroom.addressbook.EMAIL";

    private EditText mFirstNameText,mLastNameText,mAddress1Text, mAddress2Text, mPhoneText, mCellText, mEmailText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        mFirstNameText = findViewById(R.id.first_nameEditText);
        mLastNameText = findViewById(R.id.last_nameEditText);
        mAddress1Text = findViewById(R.id.address1EditText);
        mAddress2Text = findViewById(R.id.address2EditText);
        mCellText = findViewById(R.id.cellEditText);
        mPhoneText = findViewById(R.id.phoneEditText);
        mEmailText =findViewById(R.id.emailEditText);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mFirstNameText.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String firstName = mFirstNameText.getText().toString();
                    String lastName = mLastNameText.getText().toString();
                    String address1 = mAddress1Text.getText().toString();
                    String address2 = mAddress2Text.getText().toString();
                    String cell = mCellText.getText().toString();
                    String phone = mPhoneText.getText().toString();
                    String email = mEmailText.getText().toString();

                    replyIntent.putExtra(EXTRA_REPLY_FIRST_NAME, firstName);
                    replyIntent.putExtra(EXTRA_REPLY_LAST_NAME, lastName);
                    replyIntent.putExtra(EXTRA_REPLY_ADDRESS1, address1);
                    replyIntent.putExtra(EXTRA_REPLY_ADDRESS2, address2);
                    replyIntent.putExtra(EXTRA_REPLY_PHONE, phone);
                    replyIntent.putExtra(EXTRA_REPLY_CELL, cell);
                    replyIntent.putExtra(EXTRA_REPLY_EMAIL, email);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });

    }
}
