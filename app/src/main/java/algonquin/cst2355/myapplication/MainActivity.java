package algonquin.cst2355.myapplication;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * This class contain the checkPasswordComplexity() method to check if the
 * password inout the edittext has an uppercase letter,
 * a lower letter, a number, and a special symbol
 *
 * @author Dongmei Tan
 * @version 1
 */
public class MainActivity extends AppCompatActivity {

        /**
         * This holds the text at the center of the screen
         */
        private TextView tv = null;

        /**
         * This holds the password vale at the center of the screen
         */
        private EditText et = null;

        /**
         * This holds button at the bottom of the screen
         */
        private Button btn = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //loads the XML file on Screen:
            setContentView(R.layout.activity_main);

            tv = findViewById(R.id.textView);
            et = findViewById(R.id.editText);
            btn = findViewById(R.id.button);
            btn.setOnClickListener(click -> {
                String password = et.getText().toString();
                if (checkPasswordComplexity(password)) {
                    tv.setText("Your password meets the requirements");
                } else {
                    tv.setText("You shall not pass!");
                }
            });
        }

        /**
         * This function checks if this string has an Upper Case letter,
         * a lower case letter, a number, and a special symbol.
         *
         * @param pw The string object that we are checking
         * @return Return true if String pw has an Upper Case letter,
         * a lower case letter, a number, and a special symbol, or it
         * returns false.
         */

        boolean checkPasswordComplexity(String pw) {

            boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
            foundNumber = foundSpecial = foundLowerCase = foundUpperCase = false;

            int length = pw.length();
            for (int i = 0; i < length; i++) {
                char c = pw.charAt(i);
                if (isDigit(c)) {
                    foundNumber = true;
                } else if (isUpperCase(c)) {
                    foundUpperCase = true;
                } else if (isLowerCase(c)) {
                    foundLowerCase = true;
                } else if (isSpecialCharacter(c)) {
                    foundSpecial = true;
                }
            }

            Context context = getApplicationContext();
            CharSequence text = "";
            int duration = Toast.LENGTH_SHORT;

            if (!foundUpperCase) {
                text = "Your password does not have an upper case letter!";
                Toast.makeText(context, text, duration).show();
                return false;
            }
            if (!foundLowerCase) {
                text = "Your password does not have a lower case letter!";
                Toast.makeText(context, text, duration).show();
                return false;
            }
            if (!foundNumber) {
                text = "Your password does not have a number!";
                Toast.makeText(context, text, duration).show();
                return false;
            }
            if (!foundSpecial) {
                text = "Your password does not have a special letter!";
                Toast.makeText(context, text, duration).show();
                return false;
            } else {
                return true;
            }

        }

        /**
         * This function is to check if the char c is one of the special characters
         *
         * @param c The char argument that we are checking
         * @return true if c is one of the special characters, or it returns false
         */

        boolean isSpecialCharacter(char c) {
            switch (c) {
                case '#':
                case '?':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '!':
                case '@':
                    return true;
                default:
                    return false;
            }
        }
    }
