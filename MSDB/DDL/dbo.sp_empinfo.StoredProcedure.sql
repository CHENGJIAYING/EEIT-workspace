USE [DemoLab]
GO
/****** Object:  StoredProcedure [dbo].[sp_empinfo]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_empinfo]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_empinfo] AS' 
END
GO
ALTER   PROCEDURE [dbo].[sp_empinfo] @EMPLOYEE_ID int, @SALARY decimal(8,2) OUTPUT 
  AS  
  SET NOCOUNT ON;
  SELECT @SALARY = SALARY
    FROM EMPLOYEES
   WHERE EMPLOYEE_ID = @EMPLOYEE_ID;
GO
