CREATE OR REPLACE PROCEDURE SafeTransferFunds (
    p_from_account_id IN Accounts.account_id%TYPE,
    p_to_account_id IN Accounts.account_id%TYPE,
    p_amount IN NUMBER
) IS
    INSUFFICIENT_FUNDS EXCEPTION;
    v_balance Accounts.balance%TYPE;
BEGIN
    -- Check balance of from account
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_account_id FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE INSUFFICIENT_FUNDS;
    END IF;

    -- Perform transfer
    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN INSUFFICIENT_FUNDS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account_id);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END SafeTransferFunds;
/
