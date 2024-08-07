CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN Customers.customer_id%TYPE,
    p_name IN Customers.name%TYPE,
    p_age IN Customers.age%TYPE,
    p_balance IN Customers.balance%TYPE
) IS
    customer_already_exists EXCEPTION;
BEGIN
    -- Check if customer already exists
    BEGIN
        SELECT customer_id FROM Customers WHERE customer_id = p_customer_id;
        RAISE customer_already_exists;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            NULL; -- Customer does not exist, proceed with insertion
    END;

    -- Insert new customer
    INSERT INTO Customers (customer_id, name, age, balance)
    VALUES (p_customer_id, p_name, p_age, p_balance);

    COMMIT;
EXCEPTION
    WHEN customer_already_exists THEN
        DBMS_OUTPUT.PUT_LINE('Error: Customer with ID ' || p_customer_id || ' already exists.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END AddNewCustomer;
/
