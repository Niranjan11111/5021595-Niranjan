CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN Accounts.account_id%TYPE,
    p_to_account_id IN Accounts.account_id%TYPE,
    p_amount IN NUMBER
) IS
    insufficient_funds EXCEPTION;
    v_balance Accounts.balance%TYPE;
BEGIN
    -- Check balance of source account
    SELECT balance INTO v_balance FROM Accounts WHERE account_id = p_from_account_id FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE insufficient_funds;
    END IF;

    -- Perform transfer
    UPDATE Accounts SET balance = balance - p_amount WHERE account_id = p_from_account_id;
    UPDATE Accounts SET balance = balance + p_amount WHERE account_id = p_to_account_id;

    COMMIT;
EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Insufficient funds in account ' || p_from_account_id);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END TransferFunds;
/
