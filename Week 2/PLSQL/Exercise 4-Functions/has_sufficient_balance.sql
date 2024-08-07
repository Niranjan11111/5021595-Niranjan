CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_account_id IN Accounts.account_id%TYPE,
    p_amount IN NUMBER
) RETURN BOOLEAN IS
    v_balance Accounts.balance%TYPE;
BEGIN
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_account_id;
    RETURN v_balance >= p_amount;
END HasSufficientBalance;
/
