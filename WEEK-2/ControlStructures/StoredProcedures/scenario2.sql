CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_department_id NUMBER,
    p_bonus_percent NUMBER
)
AS
BEGIN

    UPDATE Employees
    SET Salary = Salary +
                 (Salary * p_bonus_percent / 100)
    WHERE DepartmentID = p_department_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE(
        'Bonus updated successfully.'
    );

END;
/