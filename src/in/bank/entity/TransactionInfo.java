package in.bank.entity;

public class TransactionInfo {
	private int transaction_ID;
	private String account_Number;
	private String branch_Name;
	private String transaction_Date;
	private String transaction_Time;
	private String employeeName;
	private double amount;
	private String transaction_Type;
	public int getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public String getAccount_Number() {
		return account_Number;
	}
	public void setAccount_Number(String account_Number) {
		this.account_Number = account_Number;
	}
	public String getBranch_Name() {
		return branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}
	public String getTransaction_Date() {
		return transaction_Date;
	}
	public void setTransaction_Date(String transaction_Date) {
		this.transaction_Date = transaction_Date;
	}
	public String getTransaction_Time() {
		return transaction_Time;
	}
	public void setTransaction_Time(String transaction_Time) {
		this.transaction_Time = transaction_Time;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getTransaction_Type() {
		return transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		this.transaction_Type = transaction_Type;
	}

}
