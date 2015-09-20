package AccountGenerator;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountGenerator {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Balance bal = new Balance();
		String input = sc.next();
		String[] file = input.split("\\,");
		bal.AccountNumber = file[0];
		bal.AccountName = file[1];
		bal.AccountBalance = Double.parseDouble(file[2]);
		bal.Accrual = Double.parseDouble(file[3]);
		bal.cashIndicator = Boolean.valueOf(file[4]);
		account acc = new account();
		String balance = acc.accountGenerator(bal);
		
		System.out.println(balance);
	}

}

class account{
	public String accountGenerator(Balance bal){
		//AccountNumber
		
		String accountNum = bal.AccountNumber;
		int len = accountNum.length();
		int finalAccLen = 12-len;
		String accountNumStr = "";
		for(int i=0; i<finalAccLen; i++){
			accountNumStr = accountNumStr+"0";
		}
		
		accountNumStr = accountNumStr+accountNum;
		
		//*********************
		
		//Account Balance
		
		Double accountBal = bal.AccountBalance;
		DecimalFormat dec = new DecimalFormat("#0.0000000");
		String accountBalStr = dec.format(accountBal);
		String[] accBal = accountBalStr.split("\\.");
		String bal1 = accBal[0];
		String bal2 = accBal[1];
		String big="";
		if(accountBal>10000000){
			big = "BIG";
		}
		
		Double ba2 = Double.parseDouble(bal2);
		if(ba2/1 == 0){
			bal2 = "000";
		}
		else{
			bal2 = bal2.replaceAll("0*$", "");
		}
		
		int balLen = bal1.length();
		int finalbalLen = 17-balLen;
		String balanceStr = "";
		for(int i=0;i<finalbalLen; i++){
			balanceStr = balanceStr+"0";
		}
		balanceStr = balanceStr+bal1+bal2;
		/*************************/
		
		//Accrual
		Double accrual = bal.Accrual;
		DecimalFormat accformat = new DecimalFormat("#0.0000000");
		String accountAccrualStr = accformat.format(accrual);
		String[] accAccrual = accountAccrualStr.split("\\.");
		String acc1 = accAccrual[0];
		String acc2 = accAccrual[1];
		
		Double ac2 = Double.parseDouble(acc2);
		if(ac2/1 == 0){
			acc2 = "000";
		}
		else{
			acc2 = acc2.replaceAll("0*$", "");
		}
		
		int accLen = acc1.length();
		int finalaccLen = 7-accLen;
		String accrualStr = "";
		for(int i=0;i<finalaccLen; i++){
			accrualStr = accrualStr+"0";
		}
		accrualStr = accrualStr+acc1+acc2;
		/**********************/
		
		//AccountName
		String name = bal.AccountName;
		int namelen = name.length();
		int finalnamelen = 30-namelen;
		String finalname = "";
		for(int i=0;i<finalnamelen; i++){
			finalname = finalname+" ";
		}
		finalname = name+finalname;
		
		/*********************/
		
		//cashIndicator
		int i=0;
		if(bal.cashIndicator){
			i = 1;
		}
		else{
			i=0;
		}
		/**********************/
		
		String finalAccount = accountNumStr+balanceStr+accrualStr+finalname+i+big;
		return finalAccount;
	}
}
class Balance{;
	String AccountNumber;
	Double AccountBalance;
	Double Accrual;
	String AccountName;
	Boolean cashIndicator;
}