USE [DemoLab]
GO
/****** Object:  View [dbo].[salvu50]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[salvu50]'))
EXEC dbo.sp_executesql @statement = N'CREATE   VIEW [dbo].[salvu50]
  AS 
  SELECT employee_id ID_NUMBER, last_name NAME,
         salary*12 ANN_SALARY
    FROM employees
   WHERE department_id = 50;
' 
GO
