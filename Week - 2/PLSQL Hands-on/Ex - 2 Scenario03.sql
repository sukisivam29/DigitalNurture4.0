SET SERVEROUTPUT ON;

BEGIN
    EXECUTE IMMEDIATE 'DROP PROCEDURE TransferFunds';
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
    BALANCE        NUMBER(12,2)
);

BEGIN
    INSERT INTO ACCOUNTS VALUES (1, 'John Smith', 10000.00);
    INSERT INTO ACCOUNTS VALUES (2, 'Alice Johnson', 5000.00);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account   IN NUMBER,
    p_to_account     IN NUMBER,
    p_amount         IN NUMBER
) IS
    v_from_balance NUMBER;
BEGIN
    SELECT BALANCE INTO v_from_balance
    FROM ACCOUNTS
    WHERE ACCOUNT_ID = p_from_account;

    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE - p_amount
    WHERE ACCOUNT_ID = p_from_account;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE + p_amount
    WHERE ACCOUNT_ID = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Transfer of $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account || ' successful.');
    COMMIT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: One of the accounts does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
        ROLLBACK;
END;
/

BEGIN
    TransferFunds(1, 2, 2000);
END;
/

BEGIN
    FOR acc IN (SELECT * FROM ACCOUNTS ORDER BY ACCOUNT_ID) LOOP
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || acc.ACCOUNT_ID || 
                             ', Name: ' || acc.CUSTOMER_NAME || 
                             ', Balance: ' || acc.BALANCE);
    END LOOP;
END;
/
