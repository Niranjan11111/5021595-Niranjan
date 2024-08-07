CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN Employees.department_id%TYPE,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET salary = salary + (salary * p_bonus_percentage / 100)
    WHERE department_id = p_department_id;
    COMMIT;
END UpdateEmployeeBonus;
/
