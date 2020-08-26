package in.bank.entity;

public class Transaction {
	private int transaction_ID;
	private int account_ID;
	private int branch_ID;
	private int transaction_Type_Id;
	private String date;
	private String time;
	private int employee_Id;
	private double amount;
	
	public int getTransaction_ID() {
		return transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		this.transaction_ID = transaction_ID;
	}
	public int getAccount_ID() {
		return account_ID;
	}
	public void setAccount_ID(int account_ID) {
		this.account_ID = account_ID;
	}
	public int getBranch_ID() {
		return branch_ID;
	}
	public void setBranch_ID(int branch_ID) {
		this.branch_ID = branch_ID;
	}
	public int getTransaction_Type_Id() {
		return transaction_Type_Id;
	}
	public void setTransaction_Type_Id(int transaction_Type_Id) {
		this.transaction_Type_Id = transaction_Type_Id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(int employee_Id) {
		this.employee_Id = employee_Id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}
