package com.nkxgen.spring.jdbc.model;

public class service {
	static int value = 0;

	public static Customer dotheservice(Customertrail customertrail) {
		Customer customer = new Customer();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customertrail dotheservice1(Customertrail customertrail) {
		Customertrail customer = new Customertrail();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public static Customertrail dotheservice2(CustomerViewModel customertrail) {
		Customertrail customer = new Customertrail();
		customer.setId(customertrail.getId());
		customer.setcustTitle(customertrail.getTitle());
		customer.setcust_type(customertrail.getType());
		customer.setcust_caddress(customertrail.getCurrentAddress());
		customer.setcust_capincode(customertrail.getCurrentPINCode());
		customer.setcust_dob(customertrail.getDateOfBirth());
		customer.setcust_mobile1(customertrail.getMobile1());
		customer.setcust_mobile1(customertrail.getMobile2());
		customer.setcust_rphone(customertrail.getResidencePhone());
		customer.setcust_raddress(customertrail.getResidenceAddress());

		return customer;
	}

	public Customertrail changing(Customertrail customer2, CustomerSub customerSub) {
		customer2.setcustTitle(customerSub.getTitle());
		customer2.setcust_mobile1(customerSub.getPhoneNo());
		customer2.setcust_raddress(customerSub.getAddress());
		return customer2;
	}

	public Transaction transactionSet(transactioninfo tarn) {
		Transaction t = new Transaction();
		t.setTran_amount(tarn.getAmount());
		t.setTran_anct_id(tarn.getAccountNumber());
		t.setTran_date(tarn.getDate());
		t.setTran_mode("cash");
		t.setTran_processedby(1);
		return t;
	}

	// =============================================================================

	public EMIpay changeToEmiObj(LoanAccount account) {
		EMIpay obj1 = new EMIpay();
		obj1.setLoanId(account.getLoanId());
		// obj.setAccountHolder(account.);
		obj1.setLoanType(account.getLoanType());
		obj1.setLoanamount(account.getLoanAmount());
		obj1.setNOI(account.getLoanDuration());
		obj1.setInterestRate(account.getInterestRate());
		obj1.setLoan_pending(account.getdeductionAmt());
		obj1.setRemainMonths(
				service.calRM(account.getdeductionAmt(), account.getLoanAmount(), account.getLoanDuration()));
		obj1.setEmi(service.calEMI(account.getLoanAmount(), account.getLoanDuration(), account.getLoanType()));
		obj1.setInterest(
				service.calinterest(account.getLoanAmount(), account.getLoanDuration(), account.getInterestRate()));
		obj1.setTotal(service.total(account.getLoanAmount(), account.getLoanDuration(), account.getInterestRate(),
				account.getdeductionAmt(), account.getLoanType()));
		// obj.setPastDue();
		obj1.setComplete(service.complete(account.getLoanDuration(), account.getdeductionAmt(), account.getLoanAmount(),
				account.getInterestRate()));
		return obj1;
	}

	public static int calRM(double amount, double lamount, int duration) {
		value = (int) (amount / (lamount / duration));
		return value;
	}

	public static int calEMI(double lamount, int duration, String typee) {

		value = (int) (lamount / duration);
		return value;
	}

	public static long calinterest(double lamount, int duration, double ir) {
		long value1 = (long) ((lamount / duration) * (ir) / 1200);
		return value1;
	}

	public static double total(double lamount, int duration, double ir, double damount, String typee) {
		long value2 = service.calinterest(lamount, duration, ir) + service.calEMI(lamount, duration, typee);
		return value2;

	}

	public static long complete(int duration, double damount, double lamount, double ir) {
		long value2 = (long) (service.calinterest(lamount, duration, ir) + damount);
		return value2;

	}

}
