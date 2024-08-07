DECLARE
    CURSOR c_customers IS
        SELECT customer_id, balance
        FROM Customers
        WHERE balance > 10000;

    v_customer_id Customers.customer_id%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id;
        EXIT WHEN c_customers%NOTFOUND;

        UPDATE Customers
        SET IsVIP = TRUE
        WHERE customer_id = v_customer_id;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/
