SET SERVEROUTPUT ON;

CREATE TABLE CUSTOMERS (
    CUSTOMER_ID   NUMBER PRIMARY KEY,
    NAME          VARCHAR2(100),
    BALANCE       NUMBER(12,2),
    ISVIP         CHAR(1) DEFAULT 'N' 
);

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE CUSTOMERS';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN
            RAISE;
        END IF;
END;
/

BEGIN
    INSERT INTO CUSTOMERS VALUES (1, 'John Smith', 8500.00, 'N');
    INSERT INTO CUSTOMERS VALUES (2, 'Alice Johnson', 12500.00, 'N');
    INSERT INTO CUSTOMERS VALUES (3, 'Robert Lee', 20000.00, 'N');
    INSERT INTO CUSTOMERS VALUES (4, 'Emily Clark', 9900.00, 'N');
    COMMIT;
END;
/

BEGIN
    FOR cust_rec IN (
        SELECT CUSTOMER_ID, BALANCE
        FROM CUSTOMERS
    )
    LOOP
        IF cust_rec.BALANCE > 10000 THEN
            UPDATE CUSTOMERS
            SET ISVIP = 'Y'
            WHERE CUSTOMER_ID = cust_rec.CUSTOMER_ID;

            DBMS_OUTPUT.PUT_LINE('Promoted to VIP: Customer ID = ' || cust_rec.CUSTOMER_ID);
        END IF;
    END LOOP;

    COMMIT;
END;
/

BEGIN
    FOR rec IN (SELECT * FROM CUSTOMERS) LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || rec.CUSTOMER_ID || ', Name: ' || rec.NAME || ', Balance: ' || rec.BALANCE || ', VIP: ' || rec.ISVIP);
    END LOOP;
END;
/
