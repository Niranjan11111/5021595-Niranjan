DECLARE
    CURSOR c_loans IS
        SELECT customer_id, due_date
        FROM Loans
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;

    v_customer_id Loans.customer_id%TYPE;
    v_due_date Loans.due_date%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_customer_id, v_due_date;
        EXIT WHEN c_loans%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Reminder: Loan for customer ' || v_customer_id || ' is due on ' || v_due_date);
    END LOOP;
    CLOSE c_loans;
END;
/
