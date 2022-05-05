USE [DemoLab]
GO
/****** Object:  StoredProcedure [dbo].[upd_emp_sal]    Script Date: 2022/3/19 下午 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[upd_emp_sal]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[upd_emp_sal] AS' 
END
GO
ALTER   PROCEDURE [dbo].[upd_emp_sal] @EMPLOYEE_ID int, @SALARY decimal(8,2)
  AS
  BEGIN
    UPDATE EMPLOYEES
       SET SALARY = @SALARY
     WHERE EMPLOYEE_ID = @EMPLOYEE_ID;
	IF @@ROWCOUNT = 0
	SELECT FORMATMESSAGE('無員工資料 %i',  @EMPLOYEE_ID); 
  END;
GO
