USE [DemoLab]
GO
/****** Object:  UserDefinedFunction [dbo].[GET_SAL]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[GET_SAL]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
BEGIN
execute dbo.sp_executesql @statement = N'CREATE   FUNCTION [dbo].[GET_SAL] (@EMPLOYEE_ID int) RETURNS DECIMAL(8,2)
  AS
  BEGIN
    DECLARE @SALARY DECIMAL(8,2);
    SELECT @SALARY = SALARY
	  FROM EMPLOYEES
	 WHERE EMPLOYEE_ID = @EMPLOYEE_ID;
    IF @@ROWCOUNT = 0 OR @SALARY IS NULL
	  SET @SALARY = 0;
	RETURN @SALARY;
  END;
' 
END
GO
