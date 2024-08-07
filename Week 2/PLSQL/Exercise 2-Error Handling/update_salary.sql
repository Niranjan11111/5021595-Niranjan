CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN Employees.employee_id%TYPE,
    p_percentage IN NUMBER
) IS
    employee_not_found EXCEPTION;
    v_salary Employees.salary%TYPE;
BEGIN
    -- Check if employee exists
    BEGIN
        SELECT salary INTO v_salary FROM Employees WHERE employee_id = p_employee_id FOR UPDATE;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RAISE employee_not_found;
    END;

    -- Update salary
    UPDATE Employees SET salary = salary + (salary * p_percentage / 100) WHERE employee_id = p_employee_id;

    COMMIT;
EXCEPTION
    WHEN employee_not_found THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/
