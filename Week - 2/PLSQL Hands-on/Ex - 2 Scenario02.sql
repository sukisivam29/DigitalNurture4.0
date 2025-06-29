SET SERVEROUTPUT ON;

BEGIN
    EXECUTE IMMEDIATE 'DROP PROCEDURE UpdateEmployeeBonus';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -4043 THEN RAISE; END IF;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE EMPLOYEES';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

CREATE TABLE EMPLOYEES (
    EMP_ID        NUMBER PRIMARY KEY,
    NAME          VARCHAR2(100),
    DEPARTMENT    VARCHAR2(50),
    SALARY        NUMBER(10,2)
);

BEGIN
    INSERT INTO EMPLOYEES VALUES (1, 'Alice', 'SALES', 50000);
    INSERT INTO EMPLOYEES VALUES (2, 'Bob', 'HR', 45000);
    INSERT INTO EMPLOYEES VALUES (3, 'Charlie', 'SALES', 55000);
    INSERT INTO EMPLOYEES VALUES (4, 'Diana', 'IT', 60000);
    INSERT INTO EMPLOYEES VALUES (5, 'Ethan', 'SALES', 52000);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    dept_name IN VARCHAR2,
    bonus_pct IN NUMBER
) IS
BEGIN
    UPDATE EMPLOYEES
    SET SALARY = SALARY + (SALARY * bonus_pct / 100)
    WHERE UPPER(DEPARTMENT) = UPPER(dept_name);

    DBMS_OUTPUT.PUT_LINE('Bonus of ' || bonus_pct || '% applied to department: ' || dept_name);
END;
/

BEGIN
    UpdateEmployeeBonus('SALES', 10);
END;
/

BEGIN
    FOR emp IN (SELECT * FROM EMPLOYEES) LOOP
        DBMS_OUTPUT.PUT_LINE('ID: ' || emp.EMP_ID || 
                             ', Name: ' || emp.NAME || 
                             ', Dept: ' || emp.DEPARTMENT || 
                             ', Salary: ' || emp.SALARY);
    END LOOP;
END;
/
