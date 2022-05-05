USE [DemoLab]
GO
/****** Object:  View [dbo].[dept_sum_vu]    Script Date: 2022/3/19 ¤U¤È 01:44:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[dept_sum_vu]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[dept_sum_vu](name, minsal, maxsal, avgsal)
  AS
  SELECT d.department_name, MIN(e.salary), 
         MAX(e.salary),AVG(e.salary)
    FROM employees e, departments d
   WHERE e.department_id = d.department_id 
   GROUP BY d.department_name;
' 
GO
