CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE SavingsAccounts
    SET balance = balance + (balance * 0.01);
    COMMIT;
END ProcessMonthlyInterest;
/
