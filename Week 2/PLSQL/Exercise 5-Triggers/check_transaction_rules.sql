CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.balance%TYPE;
BEGIN
    -- Check balance for withdrawals
    IF :NEW.transaction_type = 'WITHDRAWAL' THEN
        SELECT balance INTO v_balance FROM Accounts WHERE account_id = :NEW.account_id;
        IF v_balance < :NEW.amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal.');
        END IF;
    END IF;

    -- Ensure deposits are positive
    IF :NEW.transaction_type = 'DEPOSIT' AND :NEW.amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
END CheckTransactionRules;
/
