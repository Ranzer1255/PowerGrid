package net.ranzer.powergrid.api;

import net.ranzer.powergrid.credit.exception.InsufficientFundsException;

public interface ICreditHolder {

	//TODO make name of currency settable in configs
	int getCredit();

	void setCredit(int amount);

	default int deposit(int amount){
		int rtn = getCredit() + amount;
		setCredit(rtn);
		return rtn;
	}

	/**
	 * withdraws from this holder's account
	 *
	 * @param amount the amount to be withdrawn
	 * @return the balance remaining
	 * @throws InsufficientFundsException if balance is lower than amount
	 */
	default int withdraw(int amount) throws InsufficientFundsException{ //?there has to be a better way
		if (getCredit()<amount) throw new InsufficientFundsException();

		setCredit(-amount);

		return getCredit();
	}

}
