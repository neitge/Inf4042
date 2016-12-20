package com.example.android_calculatrice;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.app.Activity;

public class MainActivity extends Activity implements OnClickListener {
	Button one;
	Button two;
	Button three;
	Button four;
	Button five;
	Button six;
	Button seven;
	Button eight;
	Button nine;
	Button zero;
	Button plus;
	Button minus;
	Button mul;
	Button div;
	Button equal;
	Button point;
	EditText calculatrice;
	
	boolean clear;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		one = (Button)findViewById(R.id.one);
		two = (Button)findViewById(R.id.two);
		three = (Button)findViewById(R.id.three);
		four = (Button)findViewById(R.id.four);
		five = (Button)findViewById(R.id.five);
		six = (Button)findViewById(R.id.six);
		seven = (Button)findViewById(R.id.seven);
		eight = (Button)findViewById(R.id.eight);
		nine = (Button)findViewById(R.id.nine);
		zero = (Button)findViewById(R.id.zero);
		plus = (Button)findViewById(R.id.plus);
		minus = (Button)findViewById(R.id.minus);
		mul = (Button)findViewById(R.id.mul);
		div = (Button)findViewById(R.id.div);
		equal = (Button)findViewById(R.id.equal);
		point = (Button)findViewById(R.id.point);
		calculatrice = (EditText)findViewById(R.id.calc_screen);
		
		calculatrice.setText("");
		
		one.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		zero.setOnClickListener(this);
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		mul.setOnClickListener(this);
		div.setOnClickListener(this);
		equal.setOnClickListener(this);
		point.setOnClickListener(this);
		
		clear = false;
		
	}

	@Override
	public void onClick(View v) {
		if(clear){
			calculatrice.setText("");
			clear = false;
		}
		int id = v.getId();
		String addSymbol="";
		switch(id){
		case R.id.one:
			addSymbol = "1";
			break;
		case R.id.two:
			addSymbol = "2";
			break;
		case R.id.three:
			addSymbol = "3";
			break;
		case R.id.four:
			addSymbol = "4";
			break;
		case R.id.five:
			addSymbol = "5";
			break;
		case R.id.six:
			addSymbol = "6";
			break;
		case R.id.seven:
			addSymbol = "7";
			break;
		case R.id.eight:
			addSymbol = "8";
			break;
		case R.id.nine:
			addSymbol = "9";
			break;
		case R.id.zero:
			addSymbol = "0";
			break;
		case R.id.plus:
			addSymbol = "+";
			break;
		case R.id.minus:
			addSymbol = "-";
			break;
		case R.id.mul:
			addSymbol = "*";
		case R.id.div:
			addSymbol = "/";
			break;

			break;
		case R.id.point:
			addSymbol = ".";
			break;
		case R.id.equal:
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("js");
		    String expres = calculatrice.getText().toString();
		    try {
				calculatrice.setText(((double)engine.eval(expres)) + "");
			} catch (Exception e) {
				
			}
		    clear=true;
		    return
			break;
		}
		calculatrice.setText(calculatrice.getText().toString()+addSymbol);
		
	}

	
}
