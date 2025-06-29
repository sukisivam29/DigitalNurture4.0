SET SERVEROUTPUT ON;

BEGIN
    EXECUTE IMMEDIATE 'DROP PROCEDURE ProcessMonthlyInterest';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -4043 THEN RAISE; END IF; 
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE ACCOUNTS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE ACCOUNTS (
    ACCOUNT_ID     NUMBER PRIMARY KEY,
    CUSTOMER_NAME  VARCHAR2(100),
    ACCOUNT_TYPE   VARCHAR2(20), 
    BALANCE        NUMBER(12,2)
);
/

BEGIN
    INSERT INTO ACCOUNTS VALUES (1, 'John Smith', 'SAVINGS', 10000.00);
    INSERT INTO ACCOUNTS VALUES (2, 'Alice Johnson', 'CURRENT', 20000.00);
    INSERT INTO ACCOUNTS VALUES (3, 'Robert Lee', 'SAVINGS', 5000.00);
    INSERT INTO ACCOUNTS VALUES (4, 'Emily Clark', 'SAVINGS', 15000.00);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE ACCOUNTS
    SET BALANCE = BALANCE + (BALANCE * 0.01)
    WHERE ACCOUNT_TYPE = 'SAVINGS';

    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all savings accounts.');
END;
/

BEGIN
    ProcessMonthlyInterest;
END;
/

BEGIN
    FOR acc IN (SELECT * FROM ACCOUNTS) LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || acc.ACCOUNT_ID || 
                             ', Name: ' || acc.CUSTOMER_NAME || 
                             ', Type: ' || acc.ACCOUNT_TYPE || 
                             ', Balance: ' || acc.BALANCE);
    END LOOP;
END;
/
