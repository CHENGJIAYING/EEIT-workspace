USE [DemoLab]
GO
/****** Object:  View [dbo].[EMP30]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[EMP30]'))
EXEC dbo.sp_executesql @statement = N'CREATE   VIEW [dbo].[EMP30]
  AS
  SELECT employee_id, last_name, email, hire_date, job_id,          salary, department_id
    FROM employees
   WHERE department_id = 30
   WITH CHECK OPTION;
' 
GO
