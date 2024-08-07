DECLARE
    CURSOR c_accounts IS
        SELECT account_id, balance
        FROM Accounts;

    v_account_id Accounts.account_id%TYPE;
    v_balance Accounts.balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 50; -- Define the annual fee amount
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        UPDATE Accounts
        SET balance = balance - v_annual_fee
        WHERE account_id = v_account_id;
    END LOOP;
    CLOSE c_accounts;
    COMMIT;
END;
/
