USE [DemoLab]
GO
/****** Object:  StoredProcedure [dbo].[sp_employees]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_employees]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_employees] AS' 
END
GO
ALTER   PROCEDURE [dbo].[sp_employees] @CNT int
  AS
    SET NOCOUNT ON;
    SELECT TOP(@CNT) A.EMPLOYEE_ID, A.LAST_NAME, A.SALARY, A.DEPARTMENT_ID, 
           B.DEPARTMENT_NAME
      FROM EMPLOYEES A, DEPARTMENTS B
	 WHERE A.DEPARTMENT_ID = B.DEPARTMENT_ID
GO
