CREATE OR REPLACE FUNCTION CalculateAge (
    p_date_of_birth IN DATE
) RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    SELECT TRUNC((SYSDATE - p_date_of_birth) / 365.25) INTO v_age FROM DUAL;
    RETURN v_age;
END CalculateAge;
/
