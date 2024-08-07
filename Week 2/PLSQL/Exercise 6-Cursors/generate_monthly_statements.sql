DECLARE
    CURSOR c_transactions IS
        SELECT customer_id, transaction_type, amount, transaction_date
        FROM Transactions
        WHERE TRUNC(transaction_date, 'MM') = TRUNC(SYSDATE, 'MM');

    v_customer_id Transactions.customer_id%TYPE;
    v_transaction_type Transactions.transaction_type%TYPE;
    v_amount Transactions.amount%TYPE;
    v_transaction_date Transactions.transaction_date%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customer_id, v_transaction_type, v_amount, v_transaction_date;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id ||
                             ', Type: ' || v_transaction_type ||
                             ', Amount: ' || v_amount ||
                             ', Date: ' || v_transaction_date);
    END LOOP;
    CLOSE c_transactions;
END;
/
