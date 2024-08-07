DECLARE
    CURSOR c_customers IS
        SELECT customer_id, loan_interest_rate, age
        FROM Customers
        WHERE age > 60;

    v_customer_id Customers.customer_id%TYPE;
    v_loan_interest_rate Customers.loan_interest_rate%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_loan_interest_rate;
        EXIT WHEN c_customers%NOTFOUND;

        UPDATE Customers
        SET loan_interest_rate = v_loan_interest_rate - 1
        WHERE customer_id = v_customer_id;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/
