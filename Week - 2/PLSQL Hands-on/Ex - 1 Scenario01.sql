BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE CUSTOMERS';
EXCEPTION
    WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE CUSTOMERS (
    CUSTOMER_ID     NUMBER PRIMARY KEY,
    NAME            VARCHAR2(100),
    DOB             DATE,
    LOAN_INTEREST   NUMBER(5,2)
);

INSERT INTO CUSTOMERS VALUES (1, 'John Smith', TO_DATE('1950-03-10', 'YYYY-MM-DD'), 8.50);
INSERT INTO CUSTOMERS VALUES (2, 'Alice Johnson', TO_DATE('1980-07-15', 'YYYY-MM-DD'), 7.75);
INSERT INTO CUSTOMERS VALUES (3, 'Robert Lee', TO_DATE('1945-12-01', 'YYYY-MM-DD'), 9.00);
COMMIT;

SET SERVEROUTPUT ON;

BEGIN
    FOR cust_rec IN (
        SELECT CUSTOMER_ID, DOB, LOAN_INTEREST
        FROM CUSTOMERS
    )
    LOOP
        DECLARE
            v_age NUMBER;
        BEGIN
            v_age := TRUNC(MONTHS_BETWEEN(SYSDATE, cust_rec.DOB) / 12);
            IF v_age > 60 THEN
                UPDATE CUSTOMERS
                SET LOAN_INTEREST = cust_rec.LOAN_INTEREST - 1
                WHERE CUSTOMER_ID = cust_rec.CUSTOMER_ID;

                DBMS_OUTPUT.PUT_LINE('Discount applied to Customer ID: ' || cust_rec.CUSTOMER_ID);
            END IF;
        END;
    END LOOP;

    COMMIT;
END;
/

